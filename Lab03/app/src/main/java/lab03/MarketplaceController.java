package lab03;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import lab03.model.*;
import lab03.model.exceptions.OfertaNaoEncontradaException;
import lab03.model.exceptions.SaldoInsuficienteException;
import lab03.service.ClienteService;
import lab03.service.MarketplaceService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarketplaceController {
    @FXML
    private ListView<OfertaIngresso> listViewOfertas;
    
    @FXML
    private Label labelSaldoCliente;
    
    @FXML
    private Label labelTotalOfertas;
    
    @FXML
    private Button btnComprar;
    
    @FXML
    private Button btnDetalhes;
    
    private Cliente cliente;
    private Marketplace marketplace;
    private ObservableList<OfertaIngresso> ofertas;

    @FXML
    private void initialize() {
        // Obter o cliente atual do serviço
        cliente = ClienteService.getInstance().getClienteAtual();
        
        // Obter marketplace do serviço
        marketplace = MarketplaceService.getInstance().getMarketplace();
        
        // Configurar a lista de ofertas
        ofertas = FXCollections.observableArrayList(marketplace.listarOfertas());
        listViewOfertas.setItems(ofertas);
        
        // Mostrar o saldo do cliente
        labelSaldoCliente.setText(String.format("Saldo: R$ %.2f", cliente.getSaldo()));
        
        // Mostrar quantidade total de ofertas
        labelTotalOfertas.setText("Total de ofertas: " + ofertas.size());
        
        // Configurar o botão de compra para ser habilitado apenas quando um item estiver selecionado
        btnComprar.setDisable(true);
        if (btnDetalhes != null) {
            btnDetalhes.setDisable(true);
        }
        
        listViewOfertas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            boolean itemSelecionado = newSelection != null;
            btnComprar.setDisable(!itemSelecionado);
            if (btnDetalhes != null) {
                btnDetalhes.setDisable(!itemSelecionado);
            }
        });
        
        // Configurar duplo clique para mostrar detalhes
        listViewOfertas.setOnMouseClicked(event -> {
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
    private void onComprarIngresso(ActionEvent event) {
        OfertaIngresso ofertaSelecionada = listViewOfertas.getSelectionModel().getSelectedItem();
        if (ofertaSelecionada != null) {
            try {
                // Verificar se o cliente tem saldo suficiente
                if (cliente.getSaldo() < ofertaSelecionada.getPrecoPedido()) {
                    mostrarAlerta("Saldo Insuficiente", 
                            "Você não possui saldo suficiente para comprar este ingresso.", 
                            Alert.AlertType.WARNING);
                    return;
                }
                
                // Processar a compra
                cliente.debitarSaldo(ofertaSelecionada.getPrecoPedido());
                marketplace.processarCompra(cliente, ofertaSelecionada);
                ofertaSelecionada.getVendedor().adicionarSaldo(ofertaSelecionada.getPrecoPedido() * (1 - marketplace.getComissaoPorcentagem() / 100));
                
                // Atualizar a lista de ofertas
                ofertas.remove(ofertaSelecionada);
                
                // Atualizar o saldo exibido
                labelSaldoCliente.setText(String.format("Saldo: R$ %.2f", cliente.getSaldo()));
                
                // Atualizar o total de ofertas
                labelTotalOfertas.setText("Total de ofertas: " + ofertas.size());
                
                // Mostrar mensagem de sucesso
                mostrarAlerta("Compra Realizada", 
                        "Ingresso comprado com sucesso!", 
                        Alert.AlertType.INFORMATION);
                
            } catch (SaldoInsuficienteException e) {
                mostrarAlerta("Erro", "Saldo insuficiente: " + e.getMessage(), Alert.AlertType.ERROR);
            } catch (OfertaNaoEncontradaException e) {
                mostrarAlerta("Erro", "Oferta não disponível: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }
    
    @FXML
    private void exibirDetalhesEvento() {
        OfertaIngresso ofertaSelecionada = listViewOfertas.getSelectionModel().getSelectedItem();
        if (ofertaSelecionada != null) {
            try {
                // Carregar a tela de detalhes do evento
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/event_details.fxml"));
                Parent detalhesEvent = loader.load();
                
                // Obter o controlador e configurá-lo com o evento selecionado
                EventoDetalhesController controller = loader.getController();
                controller.setEvento(ofertaSelecionada.getIngresso().getEvento());
                controller.setTelaAnterior("marketplace");
                
                // Exibir a tela de detalhes
                Scene detalhesScene = new Scene(detalhesEvent, 600, 400);
                Stage stage = (Stage) listViewOfertas.getScene().getWindow();
                stage.setScene(detalhesScene);
                stage.setTitle("Detalhes do Evento - " + ofertaSelecionada.getIngresso().getEvento().getNome());
                
            } catch (IOException e) {
                mostrarAlerta("Erro", "Não foi possível exibir os detalhes: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }
    
    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
} 