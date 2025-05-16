package lab03;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListUpdateController {

    @FXML
    private ListView<String> listView;
    
    @FXML
    private Button addButton;
    
    private ObservableList<String> items;
    private int counter = 1;

    // Initialize method is automatically called after FXML loading
    @FXML
    private void initialize() {
        // Create observable list and set it to ListView
        items = FXCollections.observableArrayList();
        listView.setItems(items);
        
        // Add initial item
        items.add("Item " + counter++);
    }

    // This method will be called when the button is clicked
    @FXML
    private void handleAddItem() {
        // Add new item to the list
        items.add("Item " + counter++);
    }
}