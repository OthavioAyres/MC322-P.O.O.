package lab03;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import lab03.model.Cliente;
import lab03.service.ClienteService;

import java.io.IOException;

public class SelecaoClienteController {
    
    // Cliente 1 é o cliente padrão (João da Silva)
    private Cliente cliente1;
    
    // Cliente 2 é um cliente adicional (Maria Souza)
    private Cliente cliente2;
    
    @FXML
    private void initialize() {
        ClienteService clienteService = ClienteService.getInstance();
        
        // Verificar se o Cliente 1 já foi criado
        cliente1 = clienteService.buscarClientePorEmail("joao.silva@email.com");
        if (cliente1 == null) {
            cliente1 = new Cliente("João da Silva", "joao.silva@email.com");
            cliente1.adicionarSaldo(500.0); // Adicionar saldo inicial
            clienteService.registrarCliente(cliente1);
        }
        
        // Verificar se o Cliente 2 já foi criado
        cliente2 = clienteService.buscarClientePorEmail("maria.souza@email.com");
        if (cliente2 == null) {
            cliente2 = new Cliente("Maria Souza", "maria.souza@email.com");
            cliente2.adicionarSaldo(1000.0); // Adicionar saldo inicial para o cliente 2
            clienteService.registrarCliente(cliente2);
        }
    }
    
    @FXML
    private void logarCliente1(ActionEvent event) throws IOException {
        logarCliente(cliente1, event);
    }
    
    @FXML
    private void logarCliente2(ActionEvent event) throws IOException {
        logarCliente(cliente2, event);
    }
    
    private void logarCliente(Cliente cliente, ActionEvent event) throws IOException {
        // Definir o cliente como cliente atual no serviço
        ClienteService.getInstance().setClienteAtual(cliente);
        
        // Carregar a tela de dashboard
        Parent dashboard = FXMLLoader.load(getClass().getResource("/part4_dashboard.fxml"));
        Scene dashboardScene = new Scene(dashboard, 800, 600);
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(dashboardScene);
        stage.setTitle("Dashboard - " + cliente.getNome());
    }
} 