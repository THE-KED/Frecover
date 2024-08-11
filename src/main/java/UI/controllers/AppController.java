package UI.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AppController {

    String javaVersion = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");

    @FXML
    Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

    @FXML
    private ListView<String> listView;

    @FXML
    public void initialize() {
        // Création d'une liste observable
        ObservableList<String> items = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3", "Item 4"
        );

        // Liaison de la liste observable avec le ListView
        listView.setItems(items);
    }

}
