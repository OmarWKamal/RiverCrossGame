package View;

import Level1Chars.Controller;
import Level1Chars.GameStates.CareTaker;
import Level1Chars.GameStates.GameState;
import Level1Chars.GameStates.Originator;
import Level1Chars.GameStates.SpriteGameState;
import Level1Chars.Sprite;
import Level1Chars.Strategy;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LEVEL_1 implements java.io.Serializable {
    private boolean gamestate; // false for a char undo, true for a move undo
    private Image farmer_img = new Image("Assets/farmer.png");
    private Sprite farmer = new Sprite(farmer_img);
    private Image wolf_img = new Image("Assets/wolf.png");
    private Sprite wolf = new Sprite(wolf_img);
    private Image goat_img = new Image("Assets/sheep.png");
    private Sprite goat = new Sprite(goat_img);
    private Image raftImage = new Image("Assets/raft.png");
    private Sprite raft = new Sprite(raftImage);
    private Image plant_img = new Image("Assets/plant.png");
    private Sprite plant = new Sprite(plant_img);
    private SpriteGameState farmerState;
    private SpriteGameState raftState;
    private SpriteGameState goatState;
    private SpriteGameState wolfState;
    private SpriteGameState plantState;
    private GameState gameState;
    //*******************************************************************************************************
    private boolean riftLocation = false; //false lower, true upper
    private int rowers = 0;
    private int numOfSails = 0;
    private Stage stage;
    private Scene scene;
    private start_page startpage;
    private Strategy strategy1;
    private Controller controller;
    private Originator originator;
    private CareTaker caretaker;

    public LEVEL_1() {
    }

    //*******************************************************************************************************
    public LEVEL_1(Stage stage) {
        this.stage = stage;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
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
        Image instructions = new Image("Assets/show.png");
        Sprite showbtn = new Sprite(instructions);
        showbtn.setPositionX(400);
        showbtn.setPositionY(0);
        showbtn.render(gc);


        //*******************************************************
        Image undoimage = new Image("Assets/undo.png");
        Sprite undo = new Sprite(undoimage);
        undo.setPositionX(0);
        undo.setPositionY(100);
        undo.render(gc);
        Image redoimage = new Image("Assets/redo.png");
        Sprite redo = new Sprite(redoimage);
        redo.setPositionX(0);
        redo.setPositionY(300);
        redo.render(gc);
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
        //******************************************************************


        scene.setOnMouseClicked((MouseEvent) ->
                {
                    double x = MouseEvent.getSceneX();
                    double y = MouseEvent.getSceneY();

                    if ((x >= undo.getPositionX()) && (x < undo.getPositionX() + undo.getWidth())
                            && (y >= undo.getPositionY()) && (y < undo.getPositionY() + undo.getHeight())) {
                        if (caretaker.getGamestatesUndo().empty()) {
                            showerror("No more Undos!!");
                        } else {
                            GameState oldGameState = new GameState();
                            if (gamestate) {
                                rowers = (rowers % 2) + 2;
                                oldGameState = (GameState) originator.restoreFromMemento(caretaker.getMementoUndoMove(rowers));
                            } else {
                                oldGameState = (GameState) originator.restoreFromMemento(caretaker.getMementoUndoChar());
                                if (oldGameState != null) {
                                    rowers--;
                                } else {
                                    showerror("No more undos!!");
                                }
                            }
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

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);

                                System.out.println(raft.getPositionY());
                                System.out.println(controller.getCrossers().size() + " crossers size");
                                System.out.println(controller.getLowerBankCrossers().size() + " lowercrossers size");
                                System.out.println(controller.getUpperBankCrossers().size() + " uppercrossers size");

                                setGameState(farmer, raft, goat, wolf, plant);
                                numOfSails--;
                                rowers = 0;

                        }

                    }


                    if ((x >= redo.getPositionX()) && (x < redo.getPositionX() + redo.getWidth())
                            && (y >= redo.getPositionY()) && (y < redo.getPositionY() + redo.getHeight())) {
                        GameState oldGameState = new GameState();
                        if (caretaker.getGamestatesRedo().empty()) {
                            showerror("No more redos!!");
                        } else {
                            oldGameState = (GameState) originator.restoreFromMemento(caretaker.redoGameState());
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

                            controller.setCrossers(oldGameState.getCrossers());
                            controller.setUpperBankCrossers(oldGameState.getUpperBankCrossers());
                            controller.setLowerBankCrossers(oldGameState.getLowerBankCrossers());

                            raft.setPositionY(oldGameState.getRaftState().getPositionY());
                            System.out.println(raft.getPositionY());
                            raft.render(gc);
                            //setGameState(farmer, raft, goat, wolf, plant);
                            controller.checkPlantLocation(plant.getLocation());
                            renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                        }

                    }


                    if ((x >= showbtn.getPositionX()) && (x < showbtn.getPositionX() + showbtn.getWidth())
                            && (y >= showbtn.getPositionY()) && (y < showbtn.getPositionY() + showbtn.getHeight())) {
                        Alert rulealert = new Alert(Alert.AlertType.INFORMATION);
                        rulealert.setHeaderText("RULES ");
                        rulealert.setContentText(
                                " 1- farmer only can row the raft \n 2- you can't leave goat and wolf alone without the farmer\n "
                                        + "3- you can't leave goat and plant together without the farmer \n"
                                        + " 4- the raft can left only two crossers");
                        rulealert.showAndWait();
                    }

                    if ((x >= resetbtn.getPositionX()) && (x < resetbtn.getPositionX() + resetbtn.getWidth())
                            && (y >= resetbtn.getPositionY()) && (y < resetbtn.getPositionY() + resetbtn.getHeight())) {
                        gc.clearRect(0, 0, 600, 600);
                        initializePositions();

                        caretaker.clearStacks();

                        //undo.setDisable(true);
                        farmer.setRank(0);

                        //reset sprites's locaiton*********************************************************************
                        farmer.setLocation(1);
                        wolf.setLocation(1);
                        plant.setLocation(1);
                        goat.setLocation(1);
                        //*********************************************************************************************

                        setGameState(farmer, raft, goat, wolf, plant);
                        renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                        controller.resetGame();
                    }
                    if ((x >= loadbtn.getPositionX()) && (x < loadbtn.getPositionX() + loadbtn.getWidth())
                            && (y >= loadbtn.getPositionY()) && (y < loadbtn.getPositionY() + loadbtn.getHeight())) {
                        if (controller.checkLoad()) {
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
                            //  undo.setDisable(false);
                            renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                            numOfSails = farmer.getRank();
                        } else {
                            showerror("Error loading");
                        }
                    }
                    if ((x >= savebtn.getPositionX()) && (x < savebtn.getPositionX() + savebtn.getWidth())
                            && (y >= savebtn.getPositionY()) && (y < savebtn.getPositionY() + savebtn.getHeight())) {
                        controller.saveGame(farmer, raft, goat, wolf, plant);
                    }
                    if (raft.getPositionY() == 320) {
                        if ((x >= farmer.getPositionX()) && (x < farmer.getPositionX() + farmer.getWidth())
                                && (y >= farmer.getPositionY()) && (y < farmer.getPositionY() + farmer.getHeight()) && farmer.getLocation() == 1
                                && raft.getPositionY() == 320) {

                            controller.setCrossersMovingUp("farmer");
                            if (controller.CrosserOnRift()) {
                                farmer.setPositionX(380);
                                farmer.setPositionY(310);
                                farmer.setLocation(2);

                                rowers++;
                                gamestate = false;
                                setGameState(farmer, raft, goat, wolf, plant);
                                //  undo.setDisable(false);

                                System.out.println("*****************size of memento is  " + caretaker.mementoSize());
                                gc.drawImage(raftImage, 350, 320);

                                showbtn.render(gc);
                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror("Only 2 can row!!");
                            }

                        } else if ((x >= goat.getPositionX()) && (x < (goat.getPositionX() + goat.getWidth()))
                                && (y >= goat.getPositionY()) && (y < goat.getPositionY() + goat.getHeight()) && goat.getLocation() == 1) {
                            controller.setCrossersMovingUp("goat");
                            if (controller.CrosserOnRift()) {
                                goat.setPositionX(370);
                                goat.setPositionY(310);
                                goat.setLocation(2);

                                rowers++;
                                gamestate = false;
                                setGameState(farmer, raft, goat, wolf, plant);
                                // undo.setDisable(false);

                                showbtn.render(gc);
                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);

                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror("Only 2 can row!!");
                            }
                        } else if ((x >= wolf.getPositionX()) && (x < wolf.getPositionX() + wolf.getWidth())
                                && (y >= wolf.getPositionY()) && (y < wolf.getPositionY() + wolf.getHeight()) && wolf.getLocation() == 1) {
                            controller.setCrossersMovingUp("wolf");
                            if (controller.CrosserOnRift()) {
                                wolf.setPositionX(360);
                                wolf.setPositionY(310);
                                wolf.setLocation(2);

                                showbtn.render(gc);
                                rowers++;
                                setGameState(farmer, raft, goat, wolf, plant);
                                // undo.setDisable(false);
                                gamestate = false;

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror("Only 2 can row!!");
                            }

                        } else if ((x >= plant.getPositionX()) && (x < plant.getPositionX() + plant.getWidth())
                                && (y >= plant.getPositionY()) && (y < plant.getPositionY() + plant.getHeight()) && plant.getLocation() == 1) {
                            controller.setCrossersMovingUp("plant");
                            if (controller.CrosserOnRift()) {
                                plant.setPositionX(360);
                                plant.setPositionY(310);
                                plant.setLocation(2);

                                showbtn.render(gc);
                                rowers++;
                                setGameState(farmer, raft, goat, wolf, plant);
                                // undo.setDisable(false);
                                gamestate = false;

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror("Only 2 can row!!");
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
                                farmer.setRank(numOfSails);
                                //  undo.setDisable(false);
                                controller.clearcrossers();
                                gc.drawImage(raftImage, 260, 320);
                                setGameState(farmer, raft, goat, wolf, plant);

                                showbtn.render(gc);
                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);

                                if (controller.success()) {
                                    farmer.setFinish(1);
                                    farmer.setRank(numOfSails);
                                    Alert successalert = new Alert(Alert.AlertType.INFORMATION);
                                    successalert.setHeaderText("Congratulations!! ");

                                    if (farmer.getRank() == 7) {
                                        successalert.setContentText("Your rank is: \n ***");
                                        successalert.showAndWait();
                                    } else if ((farmer.getRank() <= 11) && (farmer.getRank() > 7)) {
                                        successalert.setContentText("Your rank is: \n **");
                                        successalert.showAndWait();
                                    } else {
                                        successalert.setContentText("Your rank is: \n *");
                                        successalert.showAndWait();
                                    }
                                    controller.saveGame(farmer, raft, goat, wolf, plant);
                                    controller.resetGame();
//                                    controller3.loadGame();
                                    //    undo.setDisable(true);
                                    caretaker.clearStacks();

                                    //****************************************************
                                    startpage.scene_build();
                                    //****************************************************


                                    stage.setScene(startpage.getScene());
                                    initializePositions();

                                    //reset sprites's locaiton
                                    farmer.setLocation(1);
                                    wolf.setLocation(1);
                                    plant.setLocation(1);
                                    goat.setLocation(1);
                                    //**************

                                    renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);

                                }
                            } else
                                showerror("Invalid Move!!");
                        }
                    } else if (raft.getPositionY() == 260) {
                        if ((x >= farmer.getPositionX()) && (x < farmer.getPositionX() + farmer.getWidth())
                                && (y >= farmer.getPositionY()) && (y < farmer.getPositionY() + farmer.getHeight()) && farmer.getLocation() == 4) {
                            controller.setCrossersMovingDown("farmer");
                            if (controller.CrosserOnRift()) {
                                farmer.setPositionX(350);
                                farmer.setPositionY(260);
                                farmer.setLocation(3);

                                rowers++;
                                setGameState(farmer, raft, goat, wolf, plant);
                                //undo.setDisable(false);
                                gamestate = false;

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror("Only 2 can row!!");
                            }

                        } else if ((x >= goat.getPositionX()) && (x < (goat.getPositionX() + goat.getWidth()))
                                && (y >= goat.getPositionY()) && (y < goat.getPositionY() + goat.getHeight()) && goat.getLocation() == 4) {
                            controller.setCrossersMovingDown("goat");
                            if (controller.CrosserOnRift()) {
                                goat.setPositionX(360);
                                goat.setPositionY(260);
                                goat.setLocation(3);

                                rowers++;
                                setGameState(farmer, raft, goat, wolf, plant);
                                //undo.setDisable(false);
                                gamestate = false;
                                //gc.drawImage(raftImage, 350, 320);
                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                                //moveSprite(goat, wolf, farmer, plant, gc, image, raftImage, button_img);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror("Only 2 can row!!");
                            }
                        } else if ((x >= wolf.getPositionX()) && (x < wolf.getPositionX() + wolf.getWidth())
                                && (y >= wolf.getPositionY()) && (y < wolf.getPositionY() + wolf.getHeight()) && wolf.getLocation() == 4) {
                            controller.setCrossersMovingDown("wolf");
                            if (controller.CrosserOnRift()) {
                                wolf.setPositionX(360);
                                wolf.setPositionY(260);
                                wolf.setLocation(3);

                                rowers++;
                                setGameState(farmer, raft, goat, wolf, plant);
                                // undo.setDisable(false);
                                gamestate = false;

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                                //  moveSprite(wolf, farmer, farmer, plant, gc, image, raftImage, button_img);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror("Only 2 can row!!");
                            }

                        } else if ((x >= plant.getPositionX()) && (x < plant.getPositionX() + plant.getWidth())
                                && (y >= plant.getPositionY()) && (y < plant.getPositionY() + plant.getHeight())) {
                            controller.setCrossersMovingDown("plant");
                            if (controller.CrosserOnRift()) {
                                plant.setPositionX(360);
                                plant.setPositionY(260);
                                plant.setLocation(3);

                                rowers++;
                                setGameState(farmer, raft, goat, wolf, plant);
                                //undo.setDisable(false);
                                gamestate = false;
                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                                System.out.println(controller.canMove(controller.getCrossers(), true));
                            } else {
                                showerror("Only 2 can row!!");
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
                                riftLocation = false;
                                raft.setPositionY(320);
                                raft.render(gc);

                                renderSprites(gc, background, savebtn, resetbtn, loadbtn, movebtn, showbtn, undo, redo);
                            } else
                                showerror("Invalid Move!!");
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

    private void showerror(String errorstring) {
        Alert error = new Alert(Alert.AlertType.INFORMATION);
        error.setHeaderText("Maximum number of rowers!");
        error.setContentText(errorstring);
        error.showAndWait();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy1 = strategy;
    }

    public void setStage(Stage primaryStage) {
        // TODO Auto-generated method stub
        this.stage = primaryStage;
    }

    private void initializePositions() {
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

    private void renderSprites(GraphicsContext gc, Sprite background, Sprite savebtn, Sprite resetbtn, Sprite loadbtn, Sprite movebtn, Sprite showbtn, Sprite undo, Sprite redo) {
        gc.clearRect(0, 0, 600, 600);
        background.render(gc);
        raft.render(gc);
        farmer.render(gc);
        showbtn.render(gc);
        goat.render(gc);
        plant.render(gc);
        savebtn.render(gc);
        resetbtn.render(gc);
        loadbtn.render(gc);
        wolf.render(gc);
        undo.render(gc);
        movebtn.render(gc);
        redo.render(gc);
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