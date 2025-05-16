package lab03;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TextController {

    @FXML
    private Text simpleText;

    @FXML
    private TextField textField;

    @FXML
    private TextArea textArea;

    @FXML
    private void initialize() {
        // Initialize with some text
        simpleText.setText("JavaFX Text Demo");
        String content = simpleText.getText();
        System.out.println(content);
        
    }
}