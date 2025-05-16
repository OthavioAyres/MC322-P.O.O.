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
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/part4_login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        // System.out.println(getClass().getResource("part1_text" + ".fxml"));

    }

}