package lab03;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    private Stage getStage(ActionEvent event) {
        return (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
    }

    @FXML
    private void onLogin(ActionEvent event) throws Exception {
        Parent dashboard = FXMLLoader.load(getClass().getResource("/part4_dashboard.fxml"));
        Scene dashboardScene = new Scene(dashboard, 800, 600);
        Stage stage = getStage(event);
        stage.setScene(dashboardScene);
        stage.setTitle("Dashboard");
    }

    @FXML
    private void onLogout(ActionEvent event) throws Exception {
        Parent login = FXMLLoader.load(getClass().getResource("/part4_login.fxml"));
        Scene loginScene = new Scene(login, 800, 600);
        Stage stage = getStage(event);
        stage.setScene(loginScene);
        stage.setTitle("Login");
    }
    
    @FXML
    private void onVerIngressos(ActionEvent event) throws Exception {
        Parent listaIngressos = FXMLLoader.load(getClass().getResource("/lista_ingressos.fxml"));
        Scene listaIngressosScene = new Scene(listaIngressos, 800, 600);
        Stage stage = getStage(event);
        stage.setScene(listaIngressosScene);
        stage.setTitle("Meus Ingressos");
    }
    
    @FXML
    private void onAbrirMarketplace(ActionEvent event) throws Exception {
        Parent marketplace = FXMLLoader.load(getClass().getResource("/marketplace.fxml"));
        Scene marketplaceScene = new Scene(marketplace, 800, 600);
        Stage stage = getStage(event);
        stage.setScene(marketplaceScene);
        stage.setTitle("Marketplace de Ingressos");
    }
    
    @FXML
    private void onComprarIngressos(ActionEvent event) throws Exception {
        // Por enquanto, apenas mostraremos uma mensagem de alerta
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
            javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Comprar Ingressos");
        alert.setHeaderText("Função não implementada");
        alert.setContentText("A funcionalidade de compra de ingressos ainda não foi implementada.");
        alert.showAndWait();
    }
}