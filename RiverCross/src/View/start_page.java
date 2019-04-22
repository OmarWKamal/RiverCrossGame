package View;

import View.LEVEL_1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class start_page {
    Stage stage;
    Scene scene;
    LEVEL_1 level_1;

    public start_page(Stage stage) {
        this.stage = stage;
    }

    public void scene_build() {
        //Group root = new Group();
        HBox root = new HBox(8);
        //Scene scene = new Scene (root,600,600);
        Canvas canvas = new Canvas(2000, 2000);
        //root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image image = new Image("Assets/background.png");
        BackgroundImage backgroundImage0 = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background0 = new Background(backgroundImage0);
        root.setBackground(background0);
        gc.drawImage(image, 0, 0);
        Button level_1btn = new Button();
        level_1btn.setPrefSize(230, 400);
        Image image1 = new Image("Assets/level 1 back button.png");
        BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        level_1btn.setBackground(background);
        level_1btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(level_1.getScene());

            }
        });

        Button level_2 = new Button();
        level_2.setPrefSize(230, 400);
        Image image2 = new Image("Assets/d.png");
        BackgroundImage backgroundImage2 = new BackgroundImage(image2, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background2 = new Background(backgroundImage2);
        level_2.setBackground(background2);
        level_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(level_2.getScene());
            }
        });
        root.getChildren().addAll(level_1btn, level_2);
        scene = new Scene(root, 800, 600);

    }

    public Scene getScene() {
        return this.scene;
    }

    public void setlevel_1(LEVEL_1 level_1) {
        this.level_1 = level_1;
    }


}
