package View;

import Level1Chars.Controller;
import Level1Chars.ICrosser;
import Level1Chars.Sprite;
import Level1Chars.Strategy1;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LEVEL_1 {
    Stage stage;
    Scene scene;
    start_page startpage;
    Strategy1 strategy1;
    Controller controller;

    public LEVEL_1(Stage stage) {
        this.stage = stage;
    }

    public void scene_build() {
        //Group root = new Group();
        Pane root = new Pane();
        Canvas canvas = new Canvas(2000, 2000);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image image = new Image("Assets/background.png");
        gc.drawImage(image, 0, 0);
        scene = new Scene(root, 2000, 2000);
        Image image2 = new Image("Assets/raft.png");
        gc.drawImage(image2, 350, 320);

        Image farmer_img = new Image("Assets/farmer.png");
        Sprite farmer = new Sprite(farmer_img);
        farmer.setPositionX(120);
        farmer.setPositionY(410);
        farmer.render(gc);

        Image wolf_img = new Image("Assets/wolf.png");
        Sprite wolf = new Sprite(wolf_img);
        wolf.setPositionX(200);
        wolf.setPositionY(410);
        wolf.render(gc);

        Image goat_img = new Image("Assets/sheep.png");
        Sprite goat = new Sprite(goat_img);
        goat.setPositionX(460);
        goat.setPositionY(410);
        goat.render(gc);

        Image plant_img = new Image("Assets/plant.png");
        Sprite plant = new Sprite(plant_img);
        plant.setPositionX(310);
        plant.setPositionY(410);
        plant.render(gc);
        scene.setOnMouseClicked((MouseEvent) ->
                {
                    Point p = MouseInfo.getPointerInfo().getLocation();
                    double x=MouseEvent.getSceneX();
                    double y = MouseEvent.getSceneY();
                   /* System.out.println("mouse x :" + p.x);
                    System.out.println("mouse y :" + p.y);
                    System.out.println("farmer y :" + farmer.getPositionY());
                    System.out.println("farmer x :" + farmer.getPositionX());
                    System.out.println("farmer width :" + farmer.getPositionX() + farmer.getWidth());
                    System.out.println("farmer height :" + farmer.getPositionY() + farmer.getHeight());*/

                        if ((x >= farmer.getPositionX()) && (x <= farmer.getPositionX() + farmer.getWidth())
                                && (y <= farmer.getPositionY()) && (y <= farmer.getPositionY() + farmer.getHeight())) {
                            controller.setCrossers("farmer");
                            if(controller.isValid())
                                moveSprite(farmer, wolf, goat, plant, gc, image, image2);
                            else {
                                Alert error = new Alert(Alert.AlertType.INFORMATION);
                                error.setHeaderText("Maximum number of rowers!");
                                error.setContentText("Only 2 characters can move on the raft!!");
                                error.showAndWait();
                            }

                        }
                        else if ((x >= goat.getPositionX()) && (x <= (goat.getPositionX() + goat.getWidth()))
                                || (y >= goat.getPositionY()) && (y <= goat.getPositionY() + goat.getHeight())) {
                            controller.setCrossers("goat");
                            if(controller.isValid())
                                moveSprite(goat, wolf, farmer, plant, gc, image, image2);
                            else {
                                Alert error = new Alert(Alert.AlertType.INFORMATION);
                                error.setHeaderText("Maximum number of rowers!");
                                error.setContentText("Only 2 characters can move on the raft!!");
                                error.showAndWait();
                            }
                        } else if ((x >= wolf.getPositionX()) && (x <= wolf.getPositionX() + wolf.getWidth())
                                && (y >= wolf.getPositionY()) && (y <= wolf.getPositionY() + wolf.getHeight())) {
                            controller.setCrossers("wolf");
                            if(controller.isValid())
                                moveSprite(wolf, farmer, farmer, plant, gc, image, image2);
                            else {
                                Alert error = new Alert(Alert.AlertType.INFORMATION);
                                error.setHeaderText("Maximum number of rowers!");
                                error.setContentText("Only 2 characters can move on the raft!!");
                                error.showAndWait();
                            }

                        } else if ((x >= plant.getPositionX()) && (x <= plant.getPositionX() + plant.getWidth())
                                && (y >= plant.getPositionY()) && (y <= plant.getPositionY() + plant.getHeight())) {
                            controller.setCrossers("plant");
                            if(controller.isValid())
                                moveSprite(plant, wolf, goat, farmer, gc, image, image2);
                            else {
                                Alert error = new Alert(Alert.AlertType.INFORMATION);
                                error.setHeaderText("Maximum number of rowers!");
                                error.setContentText("Only 2 characters can move on the raft!!");
                                error.showAndWait();
                            }
                        }
                    /* else {
                        //elerror msh bytla3 shofo 7aga tanya
                        Alert error = new Alert(Alert.AlertType.INFORMATION);
                        error.setHeaderText("Maximum number of rowers!");
                        error.setContentText("Only 2 characters can move on the raft!!");
                        error.showAndWait();
                    }*/
                }
        );


    }

    public Scene getScene() {
        return this.scene;
    }

    public void setlevel_1(start_page startpage) {
        this.startpage = startpage;
    }

    public void setStrategy(Strategy1 strategy) {
        this.strategy1 = strategy;
    }
    private void moveSprite(Sprite spritemoved, Sprite sprite2,
                           Sprite sprite3, Sprite sprite4,
                           GraphicsContext gc, Image image,
                           Image image2)
    {
        spritemoved.setPositionX(380);
        spritemoved.setPositionY(310);
        gc.clearRect(0, 0, 2000, 2000);
        gc.drawImage(image, 0, 0);
        gc.drawImage(image2, 350, 320);
        spritemoved.render(gc);
        sprite2.render(gc);
        sprite3.render(gc);
        sprite4.render(gc);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
