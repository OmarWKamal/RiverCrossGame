package View;

import Level2Chars.Controller2;
import Level2Chars.Sprite2;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LEVEL_2 {
    Stage stage;
    Scene scene;
    start_page startpage;
    Controller2 controller2;
    int numOfSails = 0;

    public LEVEL_2(Stage stage) {
        this.stage = stage;
    }

    public int getNumOfSails() {
        return numOfSails;
    }

    public void setNumOfSails(int numOfSails) {
        this.numOfSails = numOfSails;
    }

    public void set_start_page(start_page startpage) {
        this.startpage = startpage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    private void renderChars(GraphicsContext gc, Sprite2 background, Sprite2 savebtn, Sprite2 raft
            , Sprite2 farmer1, Sprite2 farmer2, Sprite2 farmer3, Sprite2 farmer4,
                             Sprite2 loadbtn, Sprite2 movebtn, Sprite2 resetbtn, Sprite2 showbtn,
                             Sprite2 goat1) {
        gc.clearRect(0, 0, 700, 600);
        background.render(gc);
        raft.render(gc);
        savebtn.render(gc);
        farmer1.render(gc);
        farmer2.render(gc);
        farmer3.render(gc);
        loadbtn.render(gc);
        farmer4.render(gc);
        movebtn.render(gc);
        resetbtn.render(gc);
        showbtn.render(gc);
        goat1.render(gc);
    }

    public void scene_build() {
        Pane root = new Pane();
        Canvas canvas = new Canvas(700, 600);
        root.getChildren().add(canvas);
        controller2.initializeCrossers();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        scene = new Scene(root, 700, 600);
        Image bckgrndImage = new Image("Assets/background.png");
        Sprite2 background = new Sprite2(bckgrndImage);
        background.setPositionX(0);
        background.setPositionY(0);
        //background.render(gc);

        Image saveimg = new Image("Assets/save button.png");
        Sprite2 savebtn = new Sprite2(saveimg);
        savebtn.setPositionX(150);
        savebtn.setPositionY(0);
        //savebtn.render(gc);
        Image loadimg = new Image("Assets/loadbtn.png");
        Sprite2 loadbtn = new Sprite2(loadimg);
        loadbtn.setPositionX(250);
        loadbtn.setPositionY(0);
        //loadbtn.render(gc);
        Image showimg = new Image("Assets/show.png");
        Sprite2 showbtn = new Sprite2(showimg);
        showbtn.setPositionX(400);
        showbtn.setPositionY(0);
        //showbtn.render(gc);

        Image farmer1Image = new Image("Assets/farmerblue.png");
        Sprite2 farmer1 = new Sprite2(farmer1Image);
        farmer1.setPositionX(50);
        farmer1.setPositionY(410);
        //farmer1.render(gc);

        Image farmer2img = new Image("Assets/farmergreen.png");
        Sprite2 farmer2 = new Sprite2(farmer2img);
        farmer2.setPositionX(200);
        farmer2.setPositionY(410);
        //farmer2.render(gc);

        Image farmer3img = new Image("Assets/farmerpurple.png");
        Sprite2 farmer3 = new Sprite2(farmer3img);
        farmer3.setPositionX(350);
        farmer3.setPositionY(410);
        //farmer3.render(gc);

        Image raftImage = new Image("Assets/raft.png");
        Sprite2 raft = new Sprite2(raftImage);
        raft.setPositionX(350);
        raft.setPositionY(320);
        //raft.render(gc);

        Image farmer4img = new Image("Assets/farmeryellow.png");
        Sprite2 farmer4 = new Sprite2(farmer4img);
        farmer4.setPositionX(500);
        farmer4.setPositionY(410);
        //farmer4.render(gc);

        Image goat1img = new Image("Assets/goat bluee.png");
        Sprite2 goat1 = new Sprite2(goat1img);
        goat1.setPositionX(100);
        goat1.setPositionY(450);
        //goat1.render(gc);


        Image button_img = new Image("Assets/button.png");
        Sprite2 movebtn = new Sprite2(button_img);
        movebtn.setPositionX(500);
        movebtn.setPositionY(0);
        //movebtn.render(gc);

        Image resetimg = new Image("Assets/reset-button.png");
        Sprite2 resetbtn = new Sprite2(resetimg);
        resetbtn.setPositionX(0);
        resetbtn.setPositionY(0);
        //resetbtn.render(gc);

        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);

        System.out.println("             size of lowerbank cross " + controller2.getLowerBankCrossers().size());
        System.out.println("             size of UPPERBANK cross " + controller2.getUpperBankCrossers().size());
        System.out.println("                size of crossers cross " + controller2.getCrossers().size());
        scene.setOnMouseClicked((MouseEvent) -> {
            double x = MouseEvent.getSceneX();
            double y = MouseEvent.getSceneY();

            if ((x >= showbtn.getPositionX()) && (x < showbtn.getPositionX() + showbtn.getWidth())
                    && (y >= showbtn.getPositionY()) && (y < showbtn.getPositionY() + showbtn.getHeight())) {
                Alert rulealert = new Alert(Alert.AlertType.INFORMATION);
                rulealert.setHeaderText("RULE ");
                rulealert.setContentText(" 1- max wieght is 100 kg\n " + "2- all can row except the bag \n"
                        + " 3- the raft can left only two crossers");
                rulealert.showAndWait();
            }

            if ((x >= resetbtn.getPositionX()) && (x < resetbtn.getPositionX() + resetbtn.getWidth())
                    && (y >= resetbtn.getPositionY()) && (y < resetbtn.getPositionY() + resetbtn.getHeight())) {
                gc.clearRect(0, 0, 600, 600);
                raft.setPositionX(350);
                raft.setPositionY(320);
                farmer1.setPositionX(50);
                farmer1.setPositionY(410);
                // boy.setRank(0);
                farmer2.setPositionX(200);
                farmer2.setPositionY(410);
                farmer3.setPositionX(350);
                farmer3.setPositionY(410);
                farmer4.setPositionX(500);
                farmer4.setPositionY(410);
                // boy.setRank(0);
                goat1.setPositionX(100);
                goat1.setPositionY(450);
                // reset sprites's locaiton
                farmer1.setLocation(1);
                farmer4.setLocation(1);
                farmer3.setLocation(1);
                farmer2.setLocation(1);
                goat1.setLocation(1);
                // **************
                renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                controller2.resetGame();
            }
            boolean riftLocation;
            if ((x >= loadbtn.getPositionX()) && (x < loadbtn.getPositionX() + loadbtn.getWidth())
                    && (y >= loadbtn.getPositionY()) && (y < loadbtn.getPositionY() + loadbtn.getHeight())) {

                if (controller2.checkLoad()) {
                    controller2.loadGame2();
                    farmer1.setPositionX(controller2.x1.getPositionX());
                    farmer1.setPositionY(controller2.x1.getPositionY());
                    raft.setPositionX(controller2.x2.getPositionX());
                    raft.setPositionY(controller2.x2.getPositionY());
                    farmer2.setPositionX(controller2.x3.getPositionX());
                    farmer2.setPositionY(controller2.x3.getPositionY());
                    farmer4.setPositionX(controller2.x4.getPositionX());
                    farmer4.setPositionY(controller2.x4.getPositionY());
                    farmer3.setPositionX(controller2.x5.getPositionX());
                    farmer3.setPositionY(controller2.x5.getPositionY());
                    goat1.setPositionX(controller2.x6.getPositionX());
                    goat1.setPositionY(controller2.x6.getPositionY());
                    farmer1.setRank(controller2.x1.getRank());
                    numOfSails = farmer1.getRank();
                    farmer1.setLocation(controller2.x1.getLocation());
                    raft.setLocation(controller2.x2.getLocation());
                    farmer2.setLocation(controller2.x3.getLocation());
                    farmer4.setLocation(controller2.x4.getLocation());
                    farmer3.setLocation(controller2.x5.getLocation());

                    renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                } else {
                    Alert nosavealert = new Alert(Alert.AlertType.INFORMATION);
                    nosavealert.setHeaderText("ATTENtion");
                    nosavealert.setContentText("no previous saved games");
                    nosavealert.showAndWait();

                }

            }
            if ((x >= savebtn.getPositionX()) && (x < savebtn.getPositionX() + savebtn.getWidth())
                    && (y >= savebtn.getPositionY()) && (y < savebtn.getPositionY() + savebtn.getHeight())) {
                // controller2.saveGame2(boy, raft, girl, man, woman,bag);
                controller2.saveGame(farmer1, farmer2, farmer3, farmer4, goat1, raft);
            }
            if (raft.getPositionY() == 320) {
                if ((x >= farmer1.getPositionX()) && (x < farmer1.getPositionX() + farmer1.getWidth())
                        && (y >= farmer1.getPositionY())
                        && (y < farmer1.getPositionY() + farmer1.getHeight() && (farmer1.getLocation() == 1))
                        && (raft.getPositionY() == 320)) {

                    System.out.println("aaaaaaaaaaaaaaaaaaaasize of lowerbank cross " + controller2.getLowerBankCrossers().size());
                    System.out.println("aaaaaaaaaaaaaaaaaasize of UPPERBANK cross " + controller2.getUpperBankCrossers().size());
                    System.out.println("aaaaaaaaaaaaaaaaaaasize of crossers cross " + controller2.getCrossers().size());

                    controller2.setCrossersMovingUp("farmer1");

                    if (controller2.CrosserOnRift()) {
                        farmer1.setPositionX(380);
                        farmer1.setPositionY(310);
                        farmer1.setLocation(2);


                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                        System.out.println("size of lowerbank cross " + controller2.getLowerBankCrossers().size());
                        System.out.println("size of UPPERBANK cross " + controller2.getUpperBankCrossers().size());
                        System.out.println("size of crossers cross " + controller2.getCrossers().size());
                        // moveSprite(farmer, wolf, goat, plant, gc, image, image2, button_img);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        showerror();
                    }

                } else if ((x >= goat1.getPositionX()) && (x < (goat1.getPositionX() + goat1.getWidth()))
                        && (y >= goat1.getPositionY())
                        && (y < goat1.getPositionY() + goat1.getHeight() && (goat1.getLocation() == 1))) {
                    controller2.setCrossersMovingUp("animal");
                    if (controller2.CrosserOnRift()) {
                        goat1.setPositionX(360);
                        goat1.setPositionY(310);
                        goat1.setLocation(2);
                        System.out.println("size of lowerbank cross " + controller2.getLowerBankCrossers().size());
                        System.out.println("size of UPPERBANK cross " + controller2.getUpperBankCrossers().size());
                        System.out.println("size of crossers cross " + controller2.getCrossers().size());
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                    } else {
                        showerror();
                    }
                } else if ((x >= farmer2.getPositionX()) && (x < (farmer2.getPositionX() + farmer2.getWidth()))
                        && (y >= farmer2.getPositionY())
                        && (y < farmer2.getPositionY() + farmer2.getHeight() && (farmer2.getLocation() == 1))
                        && (raft.getPositionY() == 320)) {
                    controller2.setCrossersMovingUp("farmer2");
                    if (controller2.CrosserOnRift()) {
                        farmer2.setPositionX(370);
                        farmer2.setPositionY(310);
                        farmer2.setLocation(2);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                        // moveSprite(goat, wolf, farmer, plant, gc, image, image2, button_img);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        showerror();
                    }
                } else if ((x >= farmer4.getPositionX()) && (x < farmer4.getPositionX() + farmer4.getWidth())
                        && (y >= farmer4.getPositionY())
                        && (y < farmer4.getPositionY() + farmer4.getHeight() && (farmer4.getLocation() == 1))
                        && (raft.getPositionY() == 320)) {
                    controller2.setCrossersMovingUp("farmer4");
                    if (controller2.CrosserOnRift()) {
                        farmer4.setPositionX(360);
                        farmer4.setPositionY(310);
                        farmer4.setLocation(2);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);

                        // moveSprite(wolf, farmer, farmer, plant, gc, image, image2, button_img);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        showerror();
                    }

                } else if ((x >= farmer3.getPositionX()) && (x < farmer3.getPositionX() + farmer3.getWidth())
                        && (y >= farmer3.getPositionY())
                        && (y < farmer3.getPositionY() + farmer3.getHeight() && (farmer3.getLocation() == 1))
                        && (raft.getPositionY() == 320)) {
                    controller2.setCrossersMovingUp("farmer3");
                    if (controller2.CrosserOnRift()) {
                        farmer3.setPositionX(360);
                        farmer3.setPositionY(310);
                        farmer3.setLocation(2);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                        // moveSprite(plant, wolf, goat, farmer, gc, image, image2, button_img);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        System.out.println(controller2.getCrossers().size());
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                        showerror();
                    }
                } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0)
                        && (y < 0 + button_img.getHeight())) {
                    if (controller2.canMove(controller2.getCrossers(), true)) {

                        if (farmer1.getPositionX() != 50) {
                            farmer1.setPositionX(50);
                            farmer1.setPositionY(100);
                            farmer1.setLocation(4);
                            // System.out.println("the raft locatioon is "+raft.getPositionY());

                        }
                        if (farmer2.getPositionX() != 200) {
                            farmer2.setPositionX(200);
                            farmer2.setPositionY(100);
                            farmer2.setLocation(4);
                            // System.out.println("the raft locatioon is "+raft.getPositionY());

                        }
                        if (farmer4.getPositionX() != 500) {
                            farmer4.setPositionX(500);
                            farmer4.setPositionY(100);
                            farmer4.setLocation(4);
                            // System.out.println("the raft locatioon is "+raft.getPositionY());

                        }
                        if (farmer3.getPositionX() != 350) {
                            farmer3.setPositionX(350);
                            farmer3.setPositionY(100);
                            farmer3.setLocation(4);
                            // System.out.println("the raft locatioon is "+raft.getPositionY());

                        }
                        if (goat1.getPositionX() != 100) {
                            goat1.setPositionX(100);
                            goat1.setPositionY(100);
                            goat1.setLocation(4);
                            // System.out.println("the raft locatioon is "+raft.getPositionY());

                        }
                        riftLocation = true;
                        numOfSails++;
                        controller2.clearcrossers();
                        System.out.println("size of lowerbank cross " + controller2.getLowerBankCrossers().size());
                        System.out.println("size of UPPERBANK cross " + controller2.getUpperBankCrossers().size());
                        System.out.println("size of crossers cross " + controller2.getCrossers().size());
                        farmer1.setRank(numOfSails);
                        raft.setPositionX(350);
                        raft.setPositionY(260);
                        gc.drawImage(raftImage, 260, 350);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                    }
					/*
					 * if (controller2.success()) { boy.setFinish(1); boy.setRank(numOfSails);
					 *
					 * Alert successalert = new Alert(Alert.AlertType.INFORMATION);
					 * successalert.setHeaderText("Congratulations!! ");
					 *
					 * if (boy.getRank() == 7) {
					 * successalert.setContentText("Your rank is: \n ***");
					 * successalert.showAndWait();
					 *
					 * } else if ((boy.getRank() <= 11) && (boy.getRank() > 7)) {
					 * successalert.setContentText("Your rank is: \n **");
					 * successalert.showAndWait();
					 *
					 * }
					 *
					 * else { successalert.setContentText("Your rank is: \n *");
					 * successalert.showAndWait();
					 *
					 * } controller2.saveGame(boy, raft, girl, man, woman); controller2.loadGame();
					 * controller2.resetGame(); startpage.scene_build();
					 *
					 * stage.setScene(startpage.getScene()); raft.setPositionX(350);
					 * raft.setPositionY(320); boy.setPositionX(120); boy.setPositionY(410);
					 * girl.setPositionX(460); girl.setPositionY(410); woman.setPositionX(310);
					 * woman.setPositionY(410); man.setPositionX(200); man.setPositionY(410);
					 *
					 * // reset sprites's locaiton boy.setLocation(1); man.setLocation(1);
					 * woman.setLocation(1); girl.setLocation(1); // **************
					 *
					 * background.render(gc); savebtn.render(gc); raft.render(gc); boy.render(gc);
					 * girl.render(gc); woman.render(gc); loadbtn.render(gc); movebtn.render(gc);
					 * resetbtn.render(gc); man.render(gc); showbtn.render(gc);
					 *
					 * }
					 *
					 * }

					else {
						Alert error = new Alert(Alert.AlertType.INFORMATION);
						error.setHeaderText("Invalid Move");
						error.setContentText("Something will get eaten!! :)");
						error.showAndWait();
					}*/
                }
            } else if (raft.getPositionY() == 260) {
                if ((x >= farmer1.getPositionX()) && (x < farmer1.getPositionX() + farmer1.getWidth())
                        && (y >= farmer1.getPositionY()) && (y < farmer1.getPositionY() + farmer1.getHeight())
                        && (farmer1.getLocation() == 4)) {
                    controller2.setCrossersMovingDown("farmer1");
                    if (controller2.CrosserOnRift()) {
                        farmer1.setPositionX(350);
                        farmer1.setPositionY(260);
                        farmer1.setLocation(3);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                        System.out.println("size of lowerbank cross " + controller2.getLowerBankCrossers().size());
                        System.out.println("size of UPPERBANK cross " + controller2.getUpperBankCrossers().size());
                        System.out.println("size of crossers cross " + controller2.getCrossers().size());

                        // moveSprite(farmer, wolf, goat, plant, gc, image, image2, button_img);
                        // System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        showerror();
                    }

                } else if ((x >= farmer2.getPositionX()) && (x < (farmer2.getPositionX() + farmer2.getWidth()))
                        && (y >= farmer2.getPositionY()) && (y < farmer2.getPositionY() + farmer2.getHeight())
                        && (farmer2.getLocation() == 4)) {
                    controller2.setCrossersMovingDown("farmer2");
                    if (controller2.CrosserOnRift()) {
                        farmer2.setPositionX(360);
                        farmer2.setPositionY(260);
                        farmer2.setLocation(3);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                        //gc.drawImage(button_img, 500, 0);
                        // moveSprite(goat, wolf, farmer, plant, gc, image, image2, button_img);
                        // System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        showerror();
                    }
                } else if ((x >= farmer3.getPositionX()) && (x < farmer3.getPositionX() + farmer3.getWidth())
                        && (y >= farmer3.getPositionY()) && (y < farmer3.getPositionY() + farmer3.getHeight())
                        && (farmer3.getLocation() == 4)) {
                    controller2.setCrossersMovingDown("farmer3");
                    if (controller2.CrosserOnRift()) {
                        farmer3.setPositionX(360);
                        farmer3.setPositionY(260);
                        farmer3.setLocation(3);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        System.out.println(controller2.getCrossers().size());
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                        showerror();
                    }
                } else if ((x >= farmer4.getPositionX()) && (x < farmer4.getPositionX() + farmer4.getWidth())
                        && (y >= farmer4.getPositionY()) && (y < farmer4.getPositionY() + farmer4.getHeight())
                        && (farmer4.getLocation() == 4)) {
                    controller2.setCrossersMovingDown("farmer4");
                    if (controller2.CrosserOnRift()) {
                        farmer4.setPositionX(360);
                        farmer4.setPositionY(260);
                        farmer4.setLocation(3);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);

                    } else {
                        showerror();
                    }
                    // moveSprite(wolf, farmer, farmer, plant, gc, image, image2, button_img);
                    // System.out.println(controller2.canMove(controller2.getCrossers(), true));
                } else if ((x >= goat1.getPositionX()) && (x < goat1.getPositionX() + goat1.getWidth())
                        && (y >= goat1.getPositionY()) && (y < goat1.getPositionY() + goat1.getHeight())
                        && (goat1.getLocation() == 4)) {
                    controller2.setCrossersMovingDown("animal");
                    if (controller2.CrosserOnRift()) {
                        goat1.setPositionX(360);
                        goat1.setPositionY(260);
                        goat1.setLocation(3);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                    } else {
                        showerror();
                    }

                } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0)
                        && (y < 0 + button_img.getHeight())) {
                    if (controller2.canMove(controller2.getCrossers(), true)) {
                        raft.setPositionY(320);

                        if (farmer1.getPositionX() != 50) {
                            farmer1.setPositionX(50);
                            farmer1.setPositionY(410);
                            farmer1.setLocation(1);

                        }
                        if (farmer2.getPositionX() != 200) {
                            farmer2.setPositionX(200);
                            farmer2.setPositionY(410);
                            farmer2.setLocation(1);
                        }
                        if (farmer4.getPositionX() != 500) {
                            farmer4.setPositionX(500);
                            farmer4.setPositionY(410);
                            farmer4.setLocation(1);
                        }
                        if (farmer3.getPositionX() != 350) {
                            farmer3.setPositionX(350);
                            farmer3.setPositionY(410);
                            farmer3.setLocation(1);
                        }
                        if (goat1.getPositionX() != 100) {
                            goat1.setPositionX(100);
                            goat1.setPositionY(450);
                            goat1.setLocation(1);
                        }
                        System.out.println("size of lowerbank cross " + controller2.getLowerBankCrossers().size());
                        System.out.println("size of UPPERBANK cross " + controller2.getUpperBankCrossers().size());
                        System.out.println("size of crossers cross " + controller2.getCrossers().size());

                        controller2.clearcrossers();
                        numOfSails++;
                        farmer1.setRank(numOfSails);
                        riftLocation = false;
                        raft.setPositionX(350);
                        raft.setPositionY(320);
                        renderChars(gc, background, savebtn, raft, farmer1, farmer2, farmer3, farmer4, loadbtn, movebtn, resetbtn, showbtn, goat1);
                    } else {
                        Alert error = new Alert(Alert.AlertType.INFORMATION);
                        error.setHeaderText("Invalid Move");
                        error.setContentText("Something will get eaten!! :)");
                        error.showAndWait();
                    }
                }
            }
        });

    }

    private void showerror() {
        Alert error = new Alert(Alert.AlertType.INFORMATION);
        error.setHeaderText("Maximum number of rowers!");
        error.setContentText("Only 2 characters can move on the raft!!");
        error.showAndWait();
    }

    public void setController2(Controller2 controller22) {
        this.controller2 = controller22;

    }
}