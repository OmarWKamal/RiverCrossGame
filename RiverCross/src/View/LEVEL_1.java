package View;

import Level1Chars.Controller;
import Level1Chars.GameStates.CareTaker;
import Level1Chars.GameStates.GameState;
import Level1Chars.GameStates.Originator;
import Level1Chars.GameStates.SpriteGameState;
import Level1Chars.ICrosser;
import Level1Chars.Sprite;
import Level1Chars.Strategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LEVEL_1 implements java.io.Serializable {
    private Stage stage;
    private Scene scene;
    private start_page startpage;
    private Strategy strategy1;
    private Controller controller;

    public Controller getController() {
        return controller;
    }

    private Originator originator;
    private CareTaker caretaker;
    boolean gamestate; // false for a char undo, true for a move undo


    Image farmer_img = new Image("Assets/farmer.png");
    Sprite farmer = new Sprite(farmer_img);
    Image wolf_img = new Image("Assets/wolf.png");
    Sprite wolf = new Sprite(wolf_img);
    Image goat_img = new Image("Assets/sheep.png");
    Sprite goat = new Sprite(goat_img);
    Image raftImage = new Image("Assets/raft.png");
    Sprite raft = new Sprite(raftImage);
    Image plant_img = new Image("Assets/plant.png");
    Sprite plant = new Sprite(plant_img);

    SpriteGameState farmerState;
    SpriteGameState raftState;
    SpriteGameState goatState;
    SpriteGameState wolfState;
    SpriteGameState plantState;
    GameState gameState;
    //*******************************************************************************************************
    boolean riftLocation = false; //false lower, true upper
    int rowers = 0;
    int numOfSails = 0;
    int numOfundos = 2;

    public LEVEL_1() {
    }

    //*******************************************************************************************************
    public LEVEL_1(Stage stage) {
        this.stage = stage;
    }

    public boolean getRiftLocation() {
        return riftLocation;
    }

    public int getNumOfSails() {
        return numOfSails;
    }



    public void scene_build() {
        originator = new Originator();
        caretaker = new CareTaker();
        Pane root = new Pane();
        Canvas canvas = new Canvas(600, 600);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image image = new Image("Assets/background.png");
        Sprite background = new Sprite(image);
        background.setPositionX(0);
        background.setPositionY(0);
        background.render(gc);
        Image saveimg = new Image("Assets/save button.png");
        Sprite savebtn = new Sprite(saveimg);
        savebtn.setPositionX(150);
        savebtn.setPositionY(0);
        savebtn.render(gc);
        Image loadimg = new Image("Assets/loadbtn.png");
        Sprite loadbtn = new Sprite(loadimg);
        loadbtn.setPositionX(250);
        loadbtn.setPositionY(0);
        loadbtn.render(gc);

        //*******************************************************
        Button undo = new Button("Undo!!");
        root.getChildren().add(1, undo);
        //*******************************************************


        scene = new Scene(root, 600, 600);


        farmer.setPositionX(120);
        farmer.setPositionY(410);
        farmer.render(gc);

        wolf.setPositionX(200);
        wolf.setPositionY(410);
        wolf.render(gc);

        goat.setPositionX(460);
        goat.setPositionY(410);
        goat.render(gc);

        raft.setPositionX(350);
        raft.setPositionY(320);
        raft.render(gc);

        Image button_img = new Image("Assets/button.png");
        Sprite movebtn = new Sprite(button_img);
        movebtn.setPositionX(500);
        movebtn.setPositionY(0);
        movebtn.render(gc);

        plant.setPositionX(310);
        plant.setPositionY(410);
        plant.render(gc);

        Image resetimg = new Image("Assets/reset-button.png");
        Sprite resetbtn = new Sprite(resetimg);
        resetbtn.setPositionX(0);
        resetbtn.setPositionY(0);
        resetbtn.render(gc);

        //******************************************************************


        setGameState(farmer, raft, goat, wolf, plant);



        System.out.println("farmer state " + farmerState.getPositionX());
        System.out.println("farmergamestateeeeee state " + gameState.getFarmerState().getPositionX());


        System.out.println("size of memento is  " + caretaker.mementoSize());
        //******************************************************************


        undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameState oldGameState = new GameState();
                rowers = (rowers%2)+1;
                System.out.println("rowersssssss:      " + rowers);
                if (gamestate) {
                    oldGameState = (GameState) originator.restoreFromMemento(caretaker.getMementoUndoMove(rowers));
                } else {
                    if((oldGameState = (GameState) originator.restoreFromMemento(caretaker.getMementoUndoChar())) != null) {
                       // oldGameState = (GameState) originator.restoreFromMemento(caretaker.getMementoUndoChar());
                    } else {showerror();}
                }
                if (oldGameState != null) {
                    farmer.setPositionX(oldGameState.getFarmerState().getPositionX());
                    farmer.setPositionY(oldGameState.getFarmerState().getPositionY());
                    farmer.setLocation(oldGameState.getFarmerState().getLocation());
                    System.out.println("farmerlocation   " + farmer.getLocation());
                    controller.checkFarmerLocation(farmer.getLocation());

                    goat.setPositionX(oldGameState.getGoatState().getPositionX());
                    goat.setPositionY(oldGameState.getGoatState().getPositionY());
                    goat.setLocation(oldGameState.getGoatState().getLocation());
                    System.out.println("goatlocation   " + goat.getLocation());
                    controller.checkGoatLocation(goat.getLocation());

                    System.out.println("wolflocation   " + wolf.getLocation());
                    wolf.setPositionX(oldGameState.getWolfState().getPositionX());
                    wolf.setPositionY(oldGameState.getWolfState().getPositionY());
                    wolf.setLocation(oldGameState.getWolfState().getLocation());
                    controller.checkWolfLocation(wolf.getLocation());

                    raft.setPositionX(oldGameState.getRaftState().getPositionX());
                    raft.setPositionY(oldGameState.getRaftState().getPositionY());
                    raft.setLocation(oldGameState.getRaftState().getLocation());
                    System.out.println("raftlocation   " + raft.getLocation());

                    plant.setPositionX(oldGameState.getPlantState().getPositionX());
                    plant.setPositionY(oldGameState.getPlantState().getPositionY());
                    plant.setLocation(oldGameState.getPlantState().getLocation());
                    System.out.println("plantlocation   " + plant.getLocation());
                    controller.checkPlantLocation(plant.getLocation());

                    renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);

                    //controller.setCrossers(oldGameState.getCrossers());
                    //controller.setLowerBankCrossers(oldGameState.getLowerBankCrossers());
                    //controller.setUpperBankCrossers(oldGameState.getUpperBankCrossers());
                    System.out.println(controller.getCrossers().size() + " crossers size");
                    System.out.println(controller.getLowerBankCrossers().size() + " lowercrossers size");
                    System.out.println(controller.getUpperBankCrossers().size() + " uppercrossers size");

                    setGameState(farmer, raft, goat, wolf, plant);
                    numOfundos++;
                } else{showerror();}
            }
        });

        scene.setOnMouseClicked((MouseEvent) ->
                {
                    double x = MouseEvent.getSceneX();
                    double y = MouseEvent.getSceneY();


                    if ((x >= resetbtn.getPositionX()) && (x < resetbtn.getPositionX() + resetbtn.getWidth())
                            && (y >= resetbtn.getPositionY()) && (y < resetbtn.getPositionY() + resetbtn.getHeight())) {
                        gc.clearRect(0, 0, 600, 600);
                        initializePositions();

                        //setGameState(farmer, raft, goat, wolf, plant);
                        caretaker.clearStacks();

                        undo.setDisable(true);

                        //reset sprites's locaiton*********************************************************************
                        farmer.setLocation(1);
                        wolf.setLocation(1);
                        plant.setLocation(1);
                        goat.setLocation(1);
                        //*********************************************************************************************

                        renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                        controller.resetGame();
                    }
                    if ((x >= loadbtn.getPositionX()) && (x < loadbtn.getPositionX() + loadbtn.getWidth())
                            && (y >= loadbtn.getPositionY()) && (y < loadbtn.getPositionY() + loadbtn.getHeight())) {
                        controller.loadGame();
                        farmer.setPositionX(controller.x1.getPositionX());
                        farmer.setPositionY(controller.x1.getPositionY());
                        raft.setPositionX(controller.x2.getPositionX());
                        raft.setPositionY(controller.x2.getPositionY());
                        goat.setPositionX(controller.x3.getPositionX());
                        goat.setPositionY(controller.x3.getPositionY());
                        wolf.setPositionX(controller.x4.getPositionX());
                        wolf.setPositionY(controller.x4.getPositionY());
                        plant.setPositionX(controller.x5.getPositionX());
                        plant.setPositionY(controller.x5.getPositionY());

                        farmer.setLocation(controller.x1.getLocation());
                        raft.setLocation(controller.x2.getLocation());
                        goat.setLocation(controller.x3.getLocation());
                        wolf.setLocation(controller.x4.getLocation());
                        plant.setLocation(controller.x5.getLocation());
                        setGameState(farmer, raft, goat, wolf, plant);
                        undo.setDisable(false);
                        renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);

                    }
                    if ((x >= savebtn.getPositionX()) && (x < savebtn.getPositionX() + savebtn.getWidth())
                            && (y >= savebtn.getPositionY()) && (y < savebtn.getPositionY() + savebtn.getHeight())) {
                        controller.saveGame(farmer, raft, goat, wolf, plant);
                    }
                    if (raft.getPositionY() == 320) {
                        if ((x >= farmer.getPositionX()) && (x < farmer.getPositionX() + farmer.getWidth())
                                && (y >= farmer.getPositionY()) && (y < farmer.getPositionY() + farmer.getHeight())) {
                            controller.setCrossersMovingUp("farmer");
                            if (controller.CrosserOnRift()) {
                                farmer.setPositionX(380);
                                farmer.setPositionY(310);
                                farmer.setLocation(2);
                                gamestate = false;
                                setGameState(farmer, raft, goat, wolf, plant);
                                undo.setDisable(false);

                                System.out.println("*****************size of memento is  " + caretaker.mementoSize());
                                gc.drawImage(raftImage, 350, 320);

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror();
                            }

                        } else if ((x >= goat.getPositionX()) && (x < (goat.getPositionX() + goat.getWidth()))
                                && (y >= goat.getPositionY()) && (y < goat.getPositionY() + goat.getHeight())) {
                            controller.setCrossersMovingUp("goat");
                            if (controller.CrosserOnRift()) {
                                goat.setPositionX(370);
                                goat.setPositionY(310);
                                goat.setLocation(2);

                                gamestate = false;
                                setGameState(farmer, raft, goat, wolf, plant);
                                undo.setDisable(false);

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror();
                            }
                        } else if ((x >= wolf.getPositionX()) && (x < wolf.getPositionX() + wolf.getWidth())
                                && (y >= wolf.getPositionY()) && (y < wolf.getPositionY() + wolf.getHeight())) {
                            controller.setCrossersMovingUp("wolf");
                            if (controller.CrosserOnRift()) {
                                wolf.setPositionX(360);
                                wolf.setPositionY(310);
                                wolf.setLocation(2);

                                setGameState(farmer, raft, goat, wolf, plant);
                                undo.setDisable(false);
                                gamestate = false;

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror();
                            }

                        } else if ((x >= plant.getPositionX()) && (x < plant.getPositionX() + plant.getWidth())
                                && (y >= plant.getPositionY()) && (y < plant.getPositionY() + plant.getHeight())) {
                            controller.setCrossersMovingUp("plant");
                            if (controller.CrosserOnRift()) {
                                plant.setPositionX(360);
                                plant.setPositionY(310);
                                plant.setLocation(2);

                                setGameState(farmer, raft, goat, wolf, plant);
                                undo.setDisable(false);
                                gamestate = false;

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror();
                            }
                        } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0) && (y < 0 + button_img.getHeight())) {
                            if (controller.canMove(controller.getCrossers(), true)) {
                                if (farmer.getPositionX() != 120) {
                                    farmer.setPositionX(50);
                                    farmer.setPositionY(100);
                                    farmer.setLocation(4);
                                }
                                if (goat.getPositionX() != 460) {
                                    goat.setPositionX(100);
                                    goat.setPositionY(100);
                                    goat.setLocation(4);
                                }
                                if (wolf.getPositionX() != 200) {
                                    wolf.setPositionX(150);
                                    wolf.setPositionY(100);
                                    wolf.setLocation(4);
                                }
                                if (plant.getPositionX() != 310) {
                                    plant.setPositionX(250);
                                    plant.setPositionY(100);
                                    plant.setLocation(4);
                                }
                                raft.setPositionY(260);
                                riftLocation = true;
                                gamestate = true;
                                numOfSails++;
                                undo.setDisable(false);
                                controller.clearcrossers();
                                gc.drawImage(raftImage, 260, 320);
                                setGameState(farmer, raft, goat, wolf, plant);

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);

                                if (controller.success()) {
                                    Alert successalert = new Alert(Alert.AlertType.INFORMATION);
                                    successalert.setHeaderText("Congratulations!! ");

                                    if (numOfSails <= 8) {
                                        farmer.setRank(3);
                                        successalert.setContentText("Your rank is: \n ***");
                                        successalert.showAndWait();
                                    } else if ((numOfSails <= 11) && (numOfSails > 7)) {
                                        farmer.setRank(2);
                                        successalert.setContentText("Your rank is: \n **");
                                        successalert.showAndWait();
                                    } else {
                                        farmer.setRank(1);
                                        successalert.setContentText("Your rank is: \n *");
                                        successalert.showAndWait();
                                    }
                                    controller.saveGame(farmer, raft, goat, wolf, plant);
                                    controller.resetGame();
                                    undo.setDisable(true);
                                    caretaker.clearStacks();

                                    stage.setScene(startpage.getScene());
                                    initializePositions();

                                    //reset sprites's locaiton
                                    farmer.setLocation(1);
                                    wolf.setLocation(1);
                                    plant.setLocation(1);
                                    goat.setLocation(1);
                                    //**************

                                    renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                                }
                            } else {
                                showerror();
                            }
                        }
                    } else if (raft.getPositionY() == 260) {
                        if ((x >= farmer.getPositionX()) && (x < farmer.getPositionX() + farmer.getWidth())
                                && (y >= farmer.getPositionY()) && (y < farmer.getPositionY() + farmer.getHeight())) {
                            controller.setCrossersMovingDown("farmer");
                            if (controller.CrosserOnRift()) {
                                farmer.setPositionX(350);
                                farmer.setPositionY(260);
                                farmer.setLocation(3);

                                setGameState(farmer, raft, goat, wolf, plant);
                                undo.setDisable(false);
                                gamestate = false;
                                // gc.drawImage(raftImage, 260, 320);

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                                //moveSprite(farmer, wolf, goat, plant, gc, image, raftImage, button_img);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror();
                            }

                        } else if ((x >= goat.getPositionX()) && (x < (goat.getPositionX() + goat.getWidth()))
                                && (y >= goat.getPositionY()) && (y < goat.getPositionY() + goat.getHeight())) {
                            controller.setCrossersMovingDown("goat");
                            if (controller.CrosserOnRift()) {
                                goat.setPositionX(360);
                                goat.setPositionY(260);
                                goat.setLocation(3);

                                setGameState(farmer, raft, goat, wolf, plant);
                                undo.setDisable(false);
                                gamestate = false;
                                //gc.drawImage(raftImage, 350, 320);
                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                                //moveSprite(goat, wolf, farmer, plant, gc, image, raftImage, button_img);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror();
                            }
                        } else if ((x >= wolf.getPositionX()) && (x < wolf.getPositionX() + wolf.getWidth())
                                && (y >= wolf.getPositionY()) && (y < wolf.getPositionY() + wolf.getHeight())) {
                            controller.setCrossersMovingDown("wolf");
                            if (controller.CrosserOnRift()) {
                                wolf.setPositionX(360);
                                wolf.setPositionY(260);
                                wolf.setLocation(3);
                                setGameState(farmer, raft, goat, wolf, plant);
                                undo.setDisable(false);
                                gamestate = false;

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                                //  moveSprite(wolf, farmer, farmer, plant, gc, image, raftImage, button_img);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror();
                            }

                        } else if ((x >= plant.getPositionX()) && (x < plant.getPositionX() + plant.getWidth())
                                && (y >= plant.getPositionY()) && (y < plant.getPositionY() + plant.getHeight())) {
                            controller.setCrossersMovingDown("plant");
                            if (controller.CrosserOnRift()) {
                                plant.setPositionX(360);
                                plant.setPositionY(260);
                                plant.setLocation(3);
                                setGameState(farmer, raft, goat, wolf, plant);
                                undo.setDisable(false);
                                gamestate = false;
                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror();
                            }
                        } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0) && (y < 0 + button_img.getHeight())) {
                            if (controller.canMove(controller.getCrossers(), true)) {
                                if (farmer.getPositionX() != 50) {
                                    farmer.setPositionX(120);
                                    farmer.setPositionY(410);
                                    farmer.setLocation(1);
                                }
                                if (goat.getPositionX() != 100) {
                                    goat.setPositionX(460);
                                    goat.setPositionY(410);
                                    goat.setLocation(1);
                                }
                                if (wolf.getPositionX() != 150) {
                                    wolf.setPositionX(200);
                                    wolf.setPositionY(410);
                                    wolf.setLocation(1);
                                }
                                if (plant.getPositionX() != 250) {
                                    plant.setPositionX(310);
                                    plant.setPositionY(410);
                                    plant.setLocation(1);
                                }
                                controller.clearcrossers();
                                gamestate = true;
                                setGameState(farmer, raft, goat, wolf, plant);
                                numOfSails++;
                                undo.setDisable(false);
                                riftLocation = false;

                                background.render(gc);
                                raft.setPositionX(350);
                                raft.setPositionY(320);
                                raft.render(gc);
                                farmer.render(gc);
                                goat.render(gc);
                                savebtn.render(gc);
                                resetbtn.render(gc);
                                loadbtn.render(gc);

                                plant.render(gc);
                                wolf.render(gc);
                                movebtn.render(gc);
                            } else {
                                showerror();
                            }
                        }
                    }
                }
        );


    }

    public Scene getScene() {
        return this.scene;
    }

    public void setlevel_1(start_page startpage) {
        this.startpage = startpage;
    }

    private void showerror() {
        Alert error = new Alert(Alert.AlertType.INFORMATION);
        error.setHeaderText("Maximum number of rowers!");
        error.setContentText("Only 2 characters can move on the raft!!");
        error.showAndWait();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy1 = strategy;
    }


    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setStage(Stage primaryStage) {
        // TODO Auto-generated method stub
        this.stage = primaryStage;
    }

    private void initializePositions()
    {
        raft.setPositionX(350);
        raft.setPositionY(320);
        farmer.setPositionX(120);
        farmer.setPositionY(410);
        goat.setPositionX(460);
        goat.setPositionY(410);
        plant.setPositionX(310);
        plant.setPositionY(410);
        wolf.setPositionX(200);
        wolf.setPositionY(410);
    }

    public void setStartPage(start_page startpage2) {
        // TODO Auto-generated method stub
        this.startpage = startpage2;
    }

    private void renderSprites(GraphicsContext gc, Sprite background, Sprite savebtn, Sprite resetbtn, Sprite loadbtn, Sprite movebtn) {
        gc.clearRect(0, 0, 600, 600);
        background.render(gc);
        raft.render(gc);
        farmer.render(gc);
        goat.render(gc);
        plant.render(gc);
        savebtn.render(gc);
        resetbtn.render(gc);
        loadbtn.render(gc);
        wolf.render(gc);
        movebtn.render(gc);
    }
    //saving gamestate
    public void setGameState(Sprite farmer, Sprite raft, Sprite goat, Sprite wolf, Sprite plant) {
        farmerState = new SpriteGameState();
        goatState = new SpriteGameState();
        wolfState = new SpriteGameState();
        plantState = new SpriteGameState();
        raftState = new SpriteGameState();
        gameState = new GameState();

        farmerState.setPositionX(farmer.getPositionX());
        farmerState.setPositionY(farmer.getPositionY());
        farmerState.setLocation(farmer.getLocation());

        raftState.setPositionX(raft.getPositionX());
        raftState.setPositionY(raft.getPositionY());

        goatState.setPositionX(goat.getPositionX());
        goatState.setPositionY(goat.getPositionY());
        goatState.setLocation(goat.getLocation());

        wolfState.setPositionX(wolf.getPositionX());
        wolfState.setPositionY(wolf.getPositionY());
        wolfState.setLocation(wolf.getLocation());

        plantState.setPositionX(plant.getPositionX());
        plantState.setPositionY(plant.getPositionY());
        plantState.setLocation(plant.getLocation());

       // crossers = crossers;



        gameState.setFarmerState(farmerState);
        gameState.setRaftState(raftState);
        gameState.setGoatState(goatState);
        gameState.setWolfState(wolfState);
        gameState.setPlantState(plantState);
        gameState.setCrossers(controller.getCrossers());
        gameState.setLowerBankCrossers(controller.getLowerBankCrossers());
        gameState.setUpperBankCrossers(controller.getUpperBankCrossers());

        originator.setGameState(gameState);
        caretaker.addMemento(originator.saveMemento());
        System.out.println("saved memento");
    }
}