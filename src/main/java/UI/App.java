package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import recover.BashExecutor;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String[] cmd = {"",""};
//        BashExecutor.exec(cmd);

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("App-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),640,480);

        stage.setScene(scene);
        stage.setTitle("Frecover");
        stage.show();
        stage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }
}
