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
    
    private Cliente cliente;
    private Marketplace marketplace;
    private ObservableList<OfertaIngresso> ofertas;

    @FXML
    private void initialize() {
        // Obter o cliente atual do serviço
        cliente = ClienteService.getInstance().getClienteAtual();
        
        // Criar marketplace fictício
        marketplace = criarMarketplaceFicticio();
        
        // Configurar a lista de ofertas
        ofertas = FXCollections.observableArrayList(marketplace.listarOfertas());
        listViewOfertas.setItems(ofertas);
        
        // Mostrar o saldo do cliente
        labelSaldoCliente.setText(String.format("Saldo: R$ %.2f", cliente.getSaldo()));
        
        // Mostrar quantidade total de ofertas
        labelTotalOfertas.setText("Total de ofertas: " + ofertas.size());
        
        // Configurar o botão de compra para ser habilitado apenas quando um item estiver selecionado
        btnComprar.setDisable(true);
        listViewOfertas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            btnComprar.setDisable(newSelection == null);
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
    
    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
    
    private Marketplace criarMarketplaceFicticio() {
        Marketplace marketplace = new Marketplace("Marketplace de Ingressos", 10.0);
        
        // Criar organizadora fictícia
        Organizadora organizadora = new Organizadora("Eventos Brasil", 123456789, "Av. Paulista, 1000");
        
        // Criar outros clientes para serem os vendedores
        Cliente vendedor1 = new Cliente("Maria Santos", "maria.santos@email.com");
        Cliente vendedor2 = new Cliente("João Oliveira", "joao.oliveira@email.com");
        Cliente vendedor3 = new Cliente("Ana Silva", "ana.silva@email.com");
        
        // Criar eventos fictícios
        EventoShow evento1 = new EventoShow("Show de Jazz", 200.00, organizadora, "2024-05-10", 3000, "Jazz Band");
        EventoShow evento2 = new EventoShow("Festival de Verão", 180.00, organizadora, "2024-06-12", 8000, "Vários Artistas");
        EventoShow evento3 = new EventoShow("Exposição de Fotografias", 50.00, organizadora, "2024-04-25", 500, "Fotógrafos Renomados");
        EventoShow evento4 = new EventoShow("Espetáculo de Dança", 120.00, organizadora, "2024-07-08", 1200, "Companhia Nacional");
        EventoShow evento5 = new EventoShow("Show Internacional", 350.00, organizadora, "2024-08-15", 12000, "Artista Internacional");
        
        // Criar ingressos para esses eventos
        Ingresso ingresso1 = new Ingresso(evento1, 200.00);
        Ingresso ingresso2 = new Ingresso(evento2, 180.00);
        Ingresso ingresso3 = new Ingresso(evento3, 50.00);
        Ingresso ingresso4 = new Ingresso(evento4, 120.00);
        Ingresso ingresso5 = new Ingresso(evento5, 350.00);
        
        // Adicionar ofertas ao marketplace
        marketplace.receberOferta(ingresso1, 190.00, vendedor1);  // Desconto pequeno
        marketplace.receberOferta(ingresso2, 160.00, vendedor2);  // Bom desconto
        marketplace.receberOferta(ingresso3, 45.00, vendedor3);   // Pequeno desconto
        marketplace.receberOferta(ingresso4, 100.00, vendedor1);  // Bom desconto
        marketplace.receberOferta(ingresso5, 300.00, vendedor2);  // Bom desconto
        
        return marketplace;
    }
} 