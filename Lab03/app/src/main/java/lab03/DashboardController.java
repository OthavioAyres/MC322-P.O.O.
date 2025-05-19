package lab03;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lab03.model.Cliente;
import lab03.service.ClienteService;

import java.io.IOException;

public class DashboardController {
    
    @FXML
    private Label labelBemVindo;
    
    @FXML
    private Label labelSaldo;
    
    private Cliente clienteAtual;
    
    @FXML
    private void initialize() {
        // Obter cliente atual
        clienteAtual = ClienteService.getInstance().getClienteAtual();
        
        // Atualizar labels com informações do cliente
        if (clienteAtual != null) {
            labelBemVindo.setText("Bem-vindo(a), " + clienteAtual.getNome() + "!");
            labelSaldo.setText(String.format("Saldo: R$ %.2f", clienteAtual.getSaldo()));
        }
    }

    private Stage getStage(ActionEvent event) {
        return (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
    }

    @FXML
    private void onLogout(ActionEvent event) throws IOException {
        // Voltar para a tela de seleção de cliente
        Parent selecaoCliente = FXMLLoader.load(getClass().getResource("/selecao_cliente.fxml"));
        Scene selecaoClienteScene = new Scene(selecaoCliente, 600, 400);
        Stage stage = getStage(event);
        stage.setScene(selecaoClienteScene);
        stage.setTitle("Seleção de Cliente");
    }
    
    @FXML
    private void onVerIngressos(ActionEvent event) throws IOException {
        Parent listaIngressos = FXMLLoader.load(getClass().getResource("/lista_ingressos.fxml"));
        Scene listaIngressosScene = new Scene(listaIngressos, 800, 600);
        Stage stage = getStage(event);
        stage.setScene(listaIngressosScene);
        stage.setTitle("Meus Ingressos");
    }
    
    @FXML
    private void onAbrirMarketplace(ActionEvent event) throws IOException {
        Parent marketplace = FXMLLoader.load(getClass().getResource("/marketplace.fxml"));
        Scene marketplaceScene = new Scene(marketplace, 800, 600);
        Stage stage = getStage(event);
        stage.setScene(marketplaceScene);
        stage.setTitle("Marketplace de Ingressos");
    }
    
    @FXML
    private void onComprarIngressos(ActionEvent event) throws IOException {
        Parent eventosDisponiveis = FXMLLoader.load(getClass().getResource("/eventos_disponiveis.fxml"));
        Scene eventosDisponiveisScene = new Scene(eventosDisponiveis, 800, 600);
        Stage stage = getStage(event);
        stage.setScene(eventosDisponiveisScene);
        stage.setTitle("Eventos Disponíveis");
    }
} 