import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("hehehhee");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}