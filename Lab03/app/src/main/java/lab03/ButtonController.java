package lab03;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class ButtonController {
    @FXML private Button basicButton;
    @FXML private ToggleButton toggleButton;
    @FXML private RadioButton radio1, radio2;
    @FXML private Text actionLabel;

    @FXML
    private void initialize() {
        // Create radio button group, just one can be assigned at a time
        ToggleGroup radioGroup = new ToggleGroup();
        radio1.setToggleGroup(radioGroup);
        radio2.setToggleGroup(radioGroup);
    }

    // Standard button handler
    @FXML
    private void handleBasicButtonClick() {
        actionLabel.setText("Basic button clicked!");
    }

    // Toggle button handler
    @FXML
    private void handleToggleButton() {
        String state = toggleButton.isSelected() ? "ON" : "OFF";
        actionLabel.setText("Toggle button: " + state);
    }

    // Radio button handler
    @FXML
    private void handleRadioButtonAction() {
        if (radio1.isSelected()) {
            actionLabel.setText("Selected: Option 1");
        } else if (radio2.isSelected()) {
            actionLabel.setText("Selected: Option 2");
        }
    }
}