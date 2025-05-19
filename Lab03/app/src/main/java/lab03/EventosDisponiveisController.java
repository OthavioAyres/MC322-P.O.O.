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
import lab03.model.*;
import lab03.model.exceptions.*;
import lab03.service.ClienteService;
import lab03.service.EventoService;

import java.io.IOException;
import java.util.Optional;

public class EventosDisponiveisController {
    @FXML
    private ListView<Evento> listViewEventos;
    
    @FXML
    private Label labelSaldoCliente;
    
    @FXML
    private Label labelTotalEventos;
    
    @FXML
    private Button btnComprar;
    
    @FXML
    private Button btnDetalhes;
    
    private Cliente cliente;
    private ObservableList<Evento> eventos;

    @FXML
    private void initialize() {
        // Obter o cliente atual do serviço
        cliente = ClienteService.getInstance().getClienteAtual();
        
        // Obter lista de eventos disponíveis
        eventos = FXCollections.observableArrayList(EventoService.getInstance().getEventosDisponiveis());
        listViewEventos.setItems(eventos);
        
        // Mostrar o saldo do cliente
        labelSaldoCliente.setText(String.format("Saldo: R$ %.2f", cliente.getSaldo()));
        
        // Mostrar quantidade total de eventos
        labelTotalEventos.setText("Total de eventos: " + eventos.size());
        
        // Configurar a célula personalizada para exibir os eventos
        listViewEventos.setCellFactory(lv -> new ListCell<Evento>() {
            @Override
            protected void updateItem(Evento evento, boolean empty) {
                super.updateItem(evento, empty);
                if (empty || evento == null) {
                    setText(null);
                } else {
                    int ingressosDisponiveis = (int)(evento.getQuantidadeParticipantes() - evento.getQuantidadeIngressosVendidos());
                    setText(String.format("Evento: %s - Data: %s - Preço: R$ %.2f - Ingressos disponíveis: %d", 
                            evento.getNome(), 
                            evento.getData(), 
                            evento.getPrecoIngresso(),
                            ingressosDisponiveis));
                }
            }
        });
        
        // Configurar duplo clique para mostrar detalhes
        listViewEventos.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                exibirDetalhesEvento();
            }
        });
        
        // Configurar os botões para serem habilitados apenas quando um item estiver selecionado
        btnComprar.setDisable(true);
        btnDetalhes.setDisable(true);
        
        listViewEventos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            boolean itemSelecionado = newSelection != null;
            btnComprar.setDisable(!itemSelecionado);
            btnDetalhes.setDisable(!itemSelecionado);
        });
    }
    
    @FXML
    private void onComprarIngresso(ActionEvent event) {
        Evento eventoSelecionado = listViewEventos.getSelectionModel().getSelectedItem();
        if (eventoSelecionado != null) {
            try {
                // Verificar se o cliente tem saldo suficiente
                if (cliente.getSaldo() < eventoSelecionado.getPrecoIngresso()) {
                    mostrarAlerta("Saldo Insuficiente", 
                            "Você não possui saldo suficiente para comprar este ingresso.", 
                            AlertType.WARNING);
                    return;
                }
                
                // Confirmar a compra
                Alert confirmacao = new Alert(AlertType.CONFIRMATION);
                confirmacao.setTitle("Confirmar Compra");
                confirmacao.setHeaderText("Confirmar compra do ingresso");
                confirmacao.setContentText(String.format(
                    "Você está comprando um ingresso para '%s' por R$ %.2f.\n\n" +
                    "Deseja confirmar a compra?",
                    eventoSelecionado.getNome(),
                    eventoSelecionado.getPrecoIngresso()
                ));
                
                Optional<ButtonType> confirmResult = confirmacao.showAndWait();
                if (confirmResult.isPresent() && confirmResult.get() == ButtonType.OK) {
                    // Processar a compra
                    eventoSelecionado.venderIngresso(cliente);
                    
                    // Atualizar o saldo exibido
                    labelSaldoCliente.setText(String.format("Saldo: R$ %.2f", cliente.getSaldo()));
                    
                    // Atualizar a lista de eventos
                    listViewEventos.refresh();
                    
                    // Mostrar mensagem de sucesso
                    mostrarAlerta("Compra Realizada", 
                            "Ingresso comprado com sucesso!", 
                            AlertType.INFORMATION);
                }
                
            } catch (IngressoEsgotadoException e) {
                mostrarAlerta("Erro", "Ingressos esgotados: " + e.getMessage(), AlertType.ERROR);
                // Remover evento da lista se não houver mais ingressos
                eventos.remove(eventoSelecionado);
                labelTotalEventos.setText("Total de eventos: " + eventos.size());
            } catch (EventoNaoEncontradoException e) {
                mostrarAlerta("Erro", "Evento não encontrado: " + e.getMessage(), AlertType.ERROR);
            }
        }
    }
    
    @FXML
    private void exibirDetalhesEvento() {
        Evento eventoSelecionado = listViewEventos.getSelectionModel().getSelectedItem();
        if (eventoSelecionado != null) {
            try {
                // Carregar a tela de detalhes do evento
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/event_details.fxml"));
                Parent detalhesEvent = loader.load();
                
                // Obter o controlador e configurá-lo com o evento selecionado
                EventoDetalhesController controller = loader.getController();
                controller.setEvento(eventoSelecionado);
                controller.setTelaAnterior("eventos_disponiveis");
                
                // Exibir a tela de detalhes
                Scene detalhesScene = new Scene(detalhesEvent, 600, 400);
                Stage stage = (Stage) listViewEventos.getScene().getWindow();
                stage.setScene(detalhesScene);
                stage.setTitle("Detalhes do Evento - " + eventoSelecionado.getNome());
                
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