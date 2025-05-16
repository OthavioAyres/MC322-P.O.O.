package lab03;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import lab03.model.Cliente;
import lab03.model.Ingresso;
import lab03.service.ClienteService;

import java.io.IOException;

public class ListaIngressosController {
    @FXML
    private ListView<Ingresso> listViewIngressos;
    
    @FXML
    private Label labelNomeCliente;
    
    @FXML
    private Label labelTotalIngressos;
    
    @FXML
    private Label labelSaldoCliente;
    
    private Cliente cliente;
    private ObservableList<Ingresso> ingressos;

    @FXML
    private void initialize() {
        // Obter o cliente atual do serviço
        cliente = ClienteService.getInstance().getClienteAtual();
        
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
        listViewIngressos.setCellFactory(lv -> new javafx.scene.control.ListCell<Ingresso>() {
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
    }
    
    @FXML
    private void onVoltar(ActionEvent event) throws IOException {
        // Voltar para a tela de dashboard
        Parent dashboard = FXMLLoader.load(getClass().getResource("/part4_dashboard.fxml"));
        Scene dashboardScene = new Scene(dashboard, 800, 600);
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(dashboardScene);
        stage.setTitle("Dashboard");
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
                exibirAlerta("Erro", "Não foi possível exibir os detalhes: " + e.getMessage());
            }
        }
    }
    
    private void exibirAlerta(String titulo, String mensagem) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
} 