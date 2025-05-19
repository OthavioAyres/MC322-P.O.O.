package lab03;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import lab03.model.*;
import lab03.model.exceptions.IngressoNaoPertenceAoClienteException;
import lab03.service.ClienteService;
import lab03.service.MarketplaceService;

import java.io.IOException;
import java.util.Optional;

public class ListaIngressosController {
    @FXML
    private ListView<Ingresso> listViewIngressos;
    
    @FXML
    private Label labelNomeCliente;
    
    @FXML
    private Label labelSaldoCliente;
    
    @FXML
    private Label labelTotalIngressos;
    
    @FXML
    private Button btnVender;
    
    @FXML
    private Button btnDetalhes;
    
    private Cliente cliente;
    private ObservableList<Ingresso> ingressos;
    private Marketplace marketplace;

    @FXML
    private void initialize() {
        // Obter o cliente atual do serviço
        cliente = ClienteService.getInstance().getClienteAtual();
        marketplace = MarketplaceService.getInstance().getMarketplace();
        
        // Configurar a lista de ingressos
        ingressos = FXCollections.observableArrayList(cliente.getIngressos());
        listViewIngressos.setItems(ingressos);
        
        // Configurar o label com o nome do cliente
        labelNomeCliente.setText("Cliente: " + cliente.getNome());
        
        // Mostrar quantidade total de ingressos
        labelTotalIngressos.setText("Total de ingressos: " + ingressos.size());
        
        // Mostrar o saldo do cliente
        labelSaldoCliente.setText(String.format("Saldo: R$ %.2f", cliente.getSaldo()));
        
        // Configurar a célula personalizada para exibir os ingressos
        listViewIngressos.setCellFactory(lv -> new ListCell<Ingresso>() {
            @Override
            protected void updateItem(Ingresso ingresso, boolean empty) {
                super.updateItem(ingresso, empty);
                if (empty || ingresso == null) {
                    setText(null);
                } else {
                    setText(String.format("Evento: %s - Data: %s - Preço: R$ %.2f", 
                            ingresso.getEvento().getNome(), 
                            ingresso.getEvento().getData(), 
                            ingresso.getPreco()));
                }
            }
        });
        
        // Configurar duplo clique para mostrar detalhes
        listViewIngressos.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                exibirDetalhesEvento();
            }
        });
        
        // Configurar os botões para serem habilitados apenas quando um item estiver selecionado
        btnVender.setDisable(true);
        btnDetalhes.setDisable(true);
        
        listViewIngressos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            boolean itemSelecionado = newSelection != null;
            btnVender.setDisable(!itemSelecionado);
            btnDetalhes.setDisable(!itemSelecionado);
        });
    }
    
    @FXML
    private void onVenderIngresso(ActionEvent event) {
        Ingresso ingressoSelecionado = listViewIngressos.getSelectionModel().getSelectedItem();
        if (ingressoSelecionado != null) {
            // Criar diálogo para definir o preço
            TextInputDialog dialog = new TextInputDialog(String.format("%.2f", ingressoSelecionado.getPreco()));
            dialog.setTitle("Vender Ingresso");
            dialog.setHeaderText("Defina o preço de venda");
            dialog.setContentText("Preço (R$):");
            
            // Configurar validação do input
            dialog.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
                if (!newValue.matches("\\d*(\\.\\d{0,2})?")) {
                    dialog.getEditor().setText(oldValue);
                }
            });
            
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(precoStr -> {
                try {
                    double precoVenda = Double.parseDouble(precoStr);
                    
                    // Confirmar a venda
                    Alert confirmacao = new Alert(AlertType.CONFIRMATION);
                    confirmacao.setTitle("Confirmar Venda");
                    confirmacao.setHeaderText("Confirmar venda do ingresso");
                    confirmacao.setContentText(String.format(
                        "Você está vendendo o ingresso para '%s' por R$ %.2f.\n" +
                        "Após a confirmação, o ingresso será removido da sua lista de ingressos.\n\n" +
                        "Deseja confirmar a venda?",
                        ingressoSelecionado.getEvento().getNome(),
                        precoVenda
                    ));
                    
                    Optional<ButtonType> confirmResult = confirmacao.showAndWait();
                    if (confirmResult.isPresent() && confirmResult.get() == ButtonType.OK) {
                        // Processar a venda
                        cliente.oferecerIngressoParaVenda(ingressoSelecionado, precoVenda, marketplace);
                        
                        // Atualizar a lista de ingressos
                        ingressos.remove(ingressoSelecionado);
                        labelTotalIngressos.setText("Total de ingressos: " + ingressos.size());
                        
                        // Mostrar mensagem de sucesso
                        Alert sucesso = new Alert(AlertType.INFORMATION);
                        sucesso.setTitle("Ingresso Colocado à Venda");
                        sucesso.setHeaderText("Ingresso colocado à venda com sucesso!");
                        sucesso.setContentText(String.format(
                            "Seu ingresso para '%s' foi colocado à venda por R$ %.2f.\n" +
                            "Você receberá o valor (menos a comissão de %.1f%%) até 48h após a venda.",
                            ingressoSelecionado.getEvento().getNome(),
                            precoVenda,
                            marketplace.getComissaoPorcentagem()
                        ));
                        sucesso.showAndWait();
                    }
                } catch (NumberFormatException e) {
                    mostrarAlerta("Erro", "Por favor, insira um valor válido.", AlertType.ERROR);
                } catch (IngressoNaoPertenceAoClienteException e) {
                    mostrarAlerta("Erro", e.getMessage(), AlertType.ERROR);
                }
            });
        }
    }
    
    @FXML
    private void exibirDetalhesEvento() {
        Ingresso ingressoSelecionado = listViewIngressos.getSelectionModel().getSelectedItem();
        if (ingressoSelecionado != null) {
            try {
                // Carregar a tela de detalhes do evento
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/event_details.fxml"));
                Parent detalhesEvent = loader.load();
                
                // Obter o controlador e configurá-lo com o evento selecionado
                EventoDetalhesController controller = loader.getController();
                controller.setEvento(ingressoSelecionado.getEvento());
                controller.setTelaAnterior("ingressos");
                
                // Exibir a tela de detalhes
                Scene detalhesScene = new Scene(detalhesEvent, 600, 400);
                Stage stage = (Stage) listViewIngressos.getScene().getWindow();
                stage.setScene(detalhesScene);
                stage.setTitle("Detalhes do Evento - " + ingressoSelecionado.getEvento().getNome());
                
            } catch (IOException e) {
                mostrarAlerta("Erro", "Não foi possível exibir os detalhes: " + e.getMessage(), AlertType.ERROR);
            }
        }
    }
    
    @FXML
    private void onVoltar(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("/part4_dashboard.fxml"));
        Scene dashboardScene = new Scene(dashboard, 800, 600);
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(dashboardScene);
        stage.setTitle("Dashboard");
    }
    
    private void mostrarAlerta(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
} 