package lab03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


    //CHANGE THE SCENE HERE TO START THE DESIRED PART OF THE CLASS
    // The possible scenes are:
    // - part1_text
    // - part2_button_with_action
    // - part3_updating_list
    // - part4_login (tela de login original)
    // - selecao_cliente (nova tela de seleção de cliente)
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/selecao_cliente.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Seleção de Cliente");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        // System.out.println(getClass().getResource("part1_text" + ".fxml"));

    }

}