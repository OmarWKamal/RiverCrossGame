package View;

import Level3.Controller3;
import Level3.Sprite2;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LEVEL_3 {
    Stage stage;
    Scene scene;
    start_page startpage;
    Controller3 controller2;
    int numOfSails = 0;

    public LEVEL_3(Stage stage) {
        this.stage = stage;
    }

    public int getNumOfSails() {
        return numOfSails;
    }

    public void setNumOfSails(int numOfSails) {
        this.numOfSails = numOfSails;
    }

    private void showerror(String errormessage) {
        Alert error = new Alert(Alert.AlertType.INFORMATION);
        error.setHeaderText("Something went wrong!! :( ");
        error.setContentText(errormessage);
        error.showAndWait();
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

    public void scene_build() {
        Pane root = new Pane();
        Canvas canvas = new Canvas(600, 600);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        scene = new Scene(root, 600, 600);
        Image bckgrndImage = new Image("Assets/background.png");
        Sprite2 background = new Sprite2(bckgrndImage);
        background.setPositionX(0);
        background.setPositionY(0);
        background.render(gc);

        Image saveimg = new Image("Assets/save button.png");
        Sprite2 savebtn = new Sprite2(saveimg);
        savebtn.setPositionX(150);
        savebtn.setPositionY(0);
        savebtn.render(gc);
        Image loadimg = new Image("Assets/loadbtn.png");
        Sprite2 loadbtn = new Sprite2(loadimg);
        loadbtn.setPositionX(250);
        loadbtn.setPositionY(0);
        loadbtn.render(gc);
        Image showimg = new Image("Assets/show.png");
        Sprite2 showbtn = new Sprite2(showimg);
        showbtn.setPositionX(400);
        showbtn.setPositionY(0);
        showbtn.render(gc);


        Image boyImage = new Image("Assets/el wad bdahro so8yr.png");
        Sprite2 boy = new Sprite2(boyImage);
        boy.setPositionX(120);
        boy.setPositionY(410);
        boy.render(gc);

        Image girlImage = new Image("Assets/elbet bdhra.png");
        Sprite2 girl = new Sprite2(girlImage);
        girl.setPositionX(200);
        girl.setPositionY(410);
        girl.render(gc);

        Image womanImage1 = new Image("Assets/elset bdhraa.png");
        Sprite2 woman = new Sprite2(womanImage1);
        woman.setPositionX(460);
        woman.setPositionY(410);
        woman.render(gc);

        Image raftImage = new Image("Assets/raft.png");
        Sprite2 raft = new Sprite2(raftImage);
        raft.setPositionX(350);
        raft.setPositionY(320);
        raft.render(gc);

        Image manImage = new Image("Assets/elragel bdhro.png");
        Sprite2 man = new Sprite2(manImage);
        man.setPositionX(310);
        man.setPositionY(410);
        man.render(gc);

        Image bagImage = new Image("Assets/bag.png");
        Sprite2 bag = new Sprite2(bagImage);
        bag.setPositionX(50);
        bag.setPositionY(450);
        bag.render(gc);

        Image button_img = new Image("Assets/button.png");
        Sprite2 movebtn = new Sprite2(button_img);
        movebtn.setPositionX(500);
        movebtn.setPositionY(0);
        movebtn.render(gc);


        Image resetimg = new Image("Assets/reset-button.png");
        Sprite2 resetbtn = new Sprite2(resetimg);
        resetbtn.setPositionX(0);
        resetbtn.setPositionY(0);
        resetbtn.render(gc);

        scene.setOnMouseClicked((MouseEvent) -> {
            double x = MouseEvent.getSceneX();
            double y = MouseEvent.getSceneY();

            if ((x >= showbtn.getPositionX()) && (x < showbtn.getPositionX() + showbtn.getWidth())
                    && (y >= showbtn.getPositionY()) && (y < showbtn.getPositionY() + showbtn.getHeight())) {
                Alert rulealert = new Alert(Alert.AlertType.INFORMATION);
                rulealert.setHeaderText("RULE ");
                rulealert.setContentText(
                        " 1- max wieght is 100 kg\n "
                                + "2- all can row except the bag \n"
                                + " 3- the raft can left only two crossers");
                rulealert.showAndWait();
            }

            if ((x >= resetbtn.getPositionX()) && (x < resetbtn.getPositionX() + resetbtn.getWidth())
                    && (y >= resetbtn.getPositionY()) && (y < resetbtn.getPositionY() + resetbtn.getHeight())) {
                gc.clearRect(0, 0, 600, 600);
                raft.setPositionX(350);
                raft.setPositionY(320);
                boy.setPositionX(120);
                boy.setPositionY(410);
                //boy.setRank(0);
                girl.setPositionX(460);
                girl.setPositionY(410);
                woman.setPositionX(310);
                woman.setPositionY(410);
                man.setPositionX(200);
                man.setPositionY(410);
                //boy.setRank(0);
                bag.setPositionX(50);
                bag.setPositionY(450);
                // reset sprites's locaiton
                boy.setLocation(1);
                man.setLocation(1);
                woman.setLocation(1);
                girl.setLocation(1);
                bag.setLocation(1);
                // **************

                background.render(gc);
                savebtn.render(gc);
                raft.render(gc);
                boy.render(gc);
                girl.render(gc);
                woman.render(gc);
                loadbtn.render(gc);
                movebtn.render(gc);
                resetbtn.render(gc);
                man.render(gc);
                showbtn.render(gc);
                bag.render(gc);
                controller2.resetGame();
            }
            boolean riftLocation;
            if ((x >= loadbtn.getPositionX()) && (x < loadbtn.getPositionX() + loadbtn.getWidth())
                    && (y >= loadbtn.getPositionY()) && (y < loadbtn.getPositionY() + loadbtn.getHeight())) {

                if (controller2.check_load2()) {
                    controller2.loadGame2();
                    boy.setPositionX(controller2.x1.getPositionX());
                    boy.setPositionY(controller2.x1.getPositionY());
                    raft.setPositionX(controller2.x2.getPositionX());
                    raft.setPositionY(controller2.x2.getPositionY());
                    girl.setPositionX(controller2.x3.getPositionX());
                    girl.setPositionY(controller2.x3.getPositionY());
                    man.setPositionX(controller2.x4.getPositionX());
                    man.setPositionY(controller2.x4.getPositionY());
                    woman.setPositionX(controller2.x5.getPositionX());
                    woman.setPositionY(controller2.x5.getPositionY());
                    bag.setPositionX(controller2.x6.getPositionX());
                    bag.setPositionY(controller2.x6.getPositionY());
                    boy.setRank(controller2.x1.getRank());
                    numOfSails = boy.getRank();
                    boy.setLocation(controller2.x1.getLocation());
                    raft.setLocation(controller2.x2.getLocation());
                    girl.setLocation(controller2.x3.getLocation());
                    man.setLocation(controller2.x4.getLocation());
                    woman.setLocation(controller2.x5.getLocation());

                    gc.clearRect(0, 0, 600, 600);
                    background.render(gc);
                    savebtn.render(gc);
                    raft.render(gc);
                    boy.render(gc);
                    girl.render(gc);
                    woman.render(gc);
                    loadbtn.render(gc);
                    man.render(gc);
                    movebtn.render(gc);
                    resetbtn.render(gc);
                    showbtn.render(gc);
                    bag.render(gc);
                } else {
                    Alert nosavealert = new Alert(Alert.AlertType.INFORMATION);
                    nosavealert.setHeaderText("ATTENtion");
                    nosavealert.setContentText("no previous saved games");
                    nosavealert.showAndWait();

                }

            }
            if ((x >= savebtn.getPositionX()) && (x < savebtn.getPositionX() + savebtn.getWidth())
                    && (y >= savebtn.getPositionY()) && (y < savebtn.getPositionY() + savebtn.getHeight())) {
                //controller2.saveGame2(boy, raft, girl, man, woman,bag);
                controller2.saveGame2(boy, raft, girl, man, woman, bag);
            }
            if (raft.getPositionY() == 320) {
                System.out.println("the raft locatioon is " + raft.getPositionY() + "da5lllll");
                if ((x >= boy.getPositionX()) && (x < boy.getPositionX() + boy.getWidth())
                        && (y >= boy.getPositionY()) && (y < boy.getPositionY() + boy.getHeight() && (boy.getLocation() == 1))
                        && (raft.getPositionY() == 320)) {
                    controller2.setCrossersMovingUp("boy");
                    if (controller2.CrosserOnRift()) {
                        boy.setPositionX(380);
                        boy.setPositionY(310);
                        raft.render(gc);

                        boy.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        gc.drawImage(raftImage, 350, 320);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        bag.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        System.out.println("the raft locatioon is " + raft.getPositionY());
                        showbtn.render(gc);

                        savebtn.render(gc);
                        movebtn.render(gc);
                        //moveSprite(farmer, wolf, goat, plant, gc, image, image2, button_img);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        showerror("hehehhe");
                    }

                } else if ((x >= bag.getPositionX()) && (x < (bag.getPositionX() + bag.getWidth()))
                        && (y >= bag.getPositionY()) && (y < bag.getPositionY() + bag.getHeight() && (girl.getLocation() == 1))
                        && (raft.getPositionY() == 320)) {

                    bag.setPositionX(360);
                    bag.setPositionY(310);
                    bag.setLocation(2);

                    gc.clearRect(0, 0, 600, 600);

                    background.render(gc);
                    raft.render(gc);
                    boy.render(gc);
                    girl.render(gc);
                    woman.render(gc);
                    man.render(gc);
                    savebtn.render(gc);
                    resetbtn.render(gc);
                    loadbtn.render(gc);
                    movebtn.render(gc);
                    showbtn.render(gc);
                    bag.render(gc);
                } else if ((x >= girl.getPositionX()) && (x < (girl.getPositionX() + girl.getWidth()))
                        && (y >= girl.getPositionY()) && (y < girl.getPositionY() + girl.getHeight() && (girl.getLocation() == 1))
                        && (raft.getPositionY() == 320)) {
                    controller2.setCrossersMovingUp("girl");
                    if (controller2.CrosserOnRift()) {
                        girl.setPositionX(370);
                        girl.setPositionY(310);
                        girl.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        movebtn.render(gc);
                        showbtn.render(gc);
                        bag.render(gc);
                        System.out.println("the raft locatioon is " + raft.getPositionY());

                        // moveSprite(goat, wolf, farmer, plant, gc, image, image2, button_img);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        showerror("lelellelele");
                    }
                } else if ((x >= man.getPositionX()) && (x < man.getPositionX() + man.getWidth())
                        && (y >= man.getPositionY()) && (y < man.getPositionY() + man.getHeight() && (man.getLocation() == 1))
                        && (raft.getPositionY() == 320)) {
                    controller2.setCrossersMovingUp("man");
                    if (controller2.CrosserOnRift()) {
                        man.setPositionX(360);
                        man.setPositionY(310);
                        man.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);

                        bag.render(gc);
                        System.out.println("the raft locatioon is " + raft.getPositionY());

                        movebtn.render(gc);
                        // moveSprite(wolf, farmer, farmer, plant, gc, image, image2, button_img);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        showerror("hahahhahahaa");
                    }

                } else if ((x >= woman.getPositionX()) && (x < woman.getPositionX() + woman.getWidth())
                        && (y >= woman.getPositionY()) && (y < woman.getPositionY() + woman.getHeight() && (woman.getLocation() == 1))
                        && (raft.getPositionY() == 320)) {
                    controller2.setCrossersMovingUp("woman");
                    if (controller2.CrosserOnRift()) {
                        woman.setPositionX(360);
                        woman.setPositionY(310);
                        woman.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("the raft locatioon is " + raft.getPositionY());
                        bag.render(gc);
                        movebtn.render(gc);
                        // moveSprite(plant, wolf, goat, farmer, gc, image, image2, button_img);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        System.out.println(controller2.getCrossers().size());
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                        showerror("kekeowfwefw");
                    }
                } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0)
                        && (y < 0 + button_img.getHeight())) {
                    if (controller2.canMove(controller2.getCrossers(), true)) {

                        if (boy.getPositionX() != 120) {
                            boy.setPositionX(50);
                            boy.setPositionY(100);
                            boy.setLocation(4);
                            System.out.println("the raft locatioon is " + raft.getPositionY());

                        }
                        if (girl.getPositionX() != 200) {

                            girl.setPositionX(150);
                            girl.setPositionY(100);
                            girl.setLocation(4);
                            System.out.println("the raft locatioon is " + raft.getPositionY());

                        }
                        if (man.getPositionX() != 310) {
                            man.setPositionX(250);
                            man.setPositionY(100);
                            man.setLocation(4);
                            System.out.println("the raft locatioon is " + raft.getPositionY());

                        }
                        if (woman.getPositionX() != 460) {
                            woman.setPositionX(350);
                            woman.setPositionY(100);
                            woman.setLocation(4);
                            System.out.println("the raft locatioon is " + raft.getPositionY());

                        }
                        if (bag.getPositionX() != 50) {
                            bag.setPositionX(450);
                            bag.setPositionY(100);
                            bag.setLocation(4);
                            System.out.println("the raft locatioon is " + raft.getPositionY());

                        }
                        riftLocation = true;
                        numOfSails++;
                        boy.setRank(numOfSails);
                        controller2.clearcrossers();

                        background.render(gc);
                        raft.setPositionX(350);
                        raft.setPositionY(260);
                        raft.render(gc);
                        boy.render(gc);
                        System.out.println("dakhalt gowa elrender 3ady");
                        girl.render(gc);
                        woman.render(gc);
                        bag.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        man.render(gc);
                        movebtn.render(gc);
                        System.out.println("raft location is " + raft.getPositionY());
                      /*  if (controller2.success()) {
                            boy.setFinish(1);
                            boy.setRank(numOfSails);

                            Alert successalert = new Alert(Alert.AlertType.INFORMATION);
                            successalert.setHeaderText("Congratulations!! ");

                            if (boy.getRank() == 7) {
                                successalert.setContentText("Your rank is: \n ***");
                                successalert.showAndWait();

                            } else if ((boy.getRank() <= 11) && (boy.getRank() > 7)) {
                                successalert.setContentText("Your rank is: \n **");
                                successalert.showAndWait();

                            }

                            else {
                                successalert.setContentText("Your rank is: \n *");
                                successalert.showAndWait();

                            }
                            controller2.saveGame(boy, raft, girl, man, woman);
                            controller2.loadGame();
                            controller2.resetGame();
                            startpage.scene_build();

                            stage.setScene(startpage.getScene());
                            raft.setPositionX(350);
                            raft.setPositionY(320);
                            boy.setPositionX(120);
                            boy.setPositionY(410);
                            girl.setPositionX(460);
                            girl.setPositionY(410);
                            woman.setPositionX(310);
                            woman.setPositionY(410);
                            man.setPositionX(200);
                            man.setPositionY(410);

                            // reset sprites's locaiton
                            boy.setLocation(1);
                            man.setLocation(1);
                            woman.setLocation(1);
                            girl.setLocation(1);
                            // **************

                            background.render(gc);
                            savebtn.render(gc);
                            raft.render(gc);
                            boy.render(gc);
                            girl.render(gc);
                            woman.render(gc);
                            loadbtn.render(gc);
                            movebtn.render(gc);
                            resetbtn.render(gc);
                            man.render(gc);
                            showbtn.render(gc);

                        }

                    }*/
                    /*else {
                        Alert error = new Alert(Alert.AlertType.INFORMATION);
                        error.setHeaderText("Invalid Move");
                        error.setContentText("Something will get eaten!! :)");
                        error.showAndWait();
                    }*/
                    } else {
                        showerror("la yastaaaaaaaaah can't move");
                    }
                } else if (raft.getPositionY() == 260) {
                    System.out.println("the raft location is " + raft.getPositionY() + " da5l el 260");
                    if ((x >= boy.getPositionX()) && (x < boy.getPositionX() + boy.getWidth())
                            && (y >= boy.getPositionY()) && (y < boy.getPositionY() + boy.getHeight()) && (boy.getLocation() == 4)) {
                        controller2.setCrossersMovingDown("farmer");
                        if (controller2.CrosserOnRift()) {
                            boy.setPositionX(350);
                            boy.setPositionY(260);
                            boy.setLocation(3);
                            gc.clearRect(0, 0, 600, 600);
                            background.render(gc);
                            raft.render(gc);
                            boy.render(gc);
                            girl.render(gc);
                            woman.render(gc);
                            savebtn.render(gc);
                            resetbtn.render(gc);
                            loadbtn.render(gc);
                            showbtn.render(gc);
                            bag.render(gc);
                            System.out.println("raft location is " + raft.getPositionY());

                            man.render(gc);
                            movebtn.render(gc);
                            // moveSprite(farmer, wolf, goat, plant, gc, image, image2, button_img);
                            System.out.println(controller2.canMove(controller2.getCrossers(), true));
                        } else {
                            showerror("sdnof");
                        }
                    }

                } else if ((x >= girl.getPositionX()) && (x < (girl.getPositionX() + girl.getWidth()))
                        && (y >= girl.getPositionY()) && (y < girl.getPositionY() + girl.getHeight()) && (girl.getLocation() == 4)) {
                    controller2.setCrossersMovingDown("girl");
                    if (controller2.CrosserOnRift()) {
                        girl.setPositionX(360);
                        girl.setPositionY(260);
                        girl.setLocation(3);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        // gc.drawImage(image2, 350, 320);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        bag.render(gc);
                        System.out.println("raft location is " + raft.getPositionY());

                        gc.drawImage(button_img, 500, 0);
                        // moveSprite(goat, wolf, farmer, plant, gc, image, image2, button_img);
                        System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    } else {
                        showerror("kwnef");
                    }
                } else if ((x >= man.getPositionX()) && (x < man.getPositionX() + man.getWidth())
                        && (y >= man.getPositionY()) && (y < man.getPositionY() + man.getHeight()) && (man.getLocation() == 4)) {
                    controller2.setCrossersMovingDown("man");
                    if (controller2.CrosserOnRift()) {
                        man.setPositionX(360);
                        man.setPositionY(260);
                        man.setLocation(3);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("raft location is " + raft.getPositionY());
                        raft.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        movebtn.render(gc);
                    }
                    // moveSprite(wolf, farmer, farmer, plant, gc, image, image2, button_img);
                    System.out.println(controller2.canMove(controller2.getCrossers(), true));
                } else {
                    showerror("sudbf");
                }
            } else if ((x >= bag.getPositionX()) && (x < bag.getPositionX() + bag.getWidth())
                    && (y >= bag.getPositionY()) && (y < bag.getPositionY() + bag.getHeight()) && (bag.getLocation() == 4)) {
                controller2.setCrossersMovingDown("bag");
                if (controller2.CrosserOnRift()) {
                    bag.setPositionX(360);
                    bag.setPositionY(260);
                    bag.setLocation(3);
                    gc.clearRect(0, 0, 600, 600);
                    background.render(gc);
                    raft.render(gc);
                    boy.render(gc);
                    girl.render(gc);
                    savebtn.render(gc);
                    resetbtn.render(gc);
                    loadbtn.render(gc);
                    showbtn.render(gc);
                    raft.render(gc);

                    System.out.println("raft location is " + raft.getPositionY());
                    bag.render(gc);
                    woman.render(gc);
                    man.render(gc);
                    movebtn.render(gc);
                    // moveSprite(wolf, farmer, farmer, plant, gc, image, image2, button_img);
                    System.out.println(controller2.canMove(controller2.getCrossers(), true));
                } else {
                    showerror("ubsdf");
                }


            } else if ((x >= woman.getPositionX()) && (x < woman.getPositionX() + woman.getWidth())
                    && (y >= woman.getPositionY()) && (y < woman.getPositionY() + woman.getHeight()) && (woman.getLocation() == 4)) {
                controller2.setCrossersMovingDown("woman");
                if (controller2.CrosserOnRift()) {
                    woman.setPositionX(360);
                    woman.setPositionY(260);
                    woman.setLocation(3);
                    gc.clearRect(0, 0, 600, 600);
                    background.render(gc);
                    raft.render(gc);
                    boy.render(gc);
                    girl.render(gc);
                    woman.render(gc);
                    savebtn.render(gc);
                    resetbtn.render(gc);
                    loadbtn.render(gc);
                    showbtn.render(gc);
                    System.out.println("raft location is " + raft.getPositionY());
                    raft.render(gc);

                    man.render(gc);
                    movebtn.render(gc);
                    // moveSprite(plant, wolf, goat, farmer, gc, image, image2, button_img);
                    System.out.println(controller2.canMove(controller2.getCrossers(), true));
                } else {
                    System.out.println(controller2.getCrossers().size());
                    System.out.println(controller2.canMove(controller2.getCrossers(), true));
                    showerror("sdkj");
                }
            } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0)
                    && (y < 0 + button_img.getHeight())) {
                if (controller2.canMove(controller2.getCrossers(), true)) {
                    raft.setPositionY(320);

                    if (boy.getPositionX() != 50) {
                        boy.setPositionX(120);
                        boy.setPositionY(410);
                        boy.setLocation(1);

                    }
                    if (girl.getPositionX() != 150) {
                        girl.setPositionX(200);
                        girl.setPositionY(410);
                        girl.setLocation(1);
                    }
                    if (man.getPositionX() != 250) {
                        man.setPositionX(310);
                        man.setPositionY(410);
                        man.setLocation(1);
                    }
                    if (woman.getPositionX() != 350) {
                        woman.setPositionX(460);
                        woman.setPositionY(410);
                        woman.setLocation(1);
                    }
                    if (bag.getPositionX() != 450) {
                        bag.setPositionX(50);
                        bag.setPositionY(450);
                        bag.setLocation(1);
                    }
                    controller2.clearcrossers();
                    numOfSails++;
                    boy.setRank(numOfSails);
                    riftLocation = false;
                    background.render(gc);
                    raft.setPositionX(350);
                    raft.setPositionY(320);
                    raft.render(gc);
                    boy.render(gc);
                    girl.render(gc);
                    bag.render(gc);
                    savebtn.render(gc);
                    resetbtn.render(gc);
                    loadbtn.render(gc);
                    showbtn.render(gc);

                    System.out.println("raft location is " + raft.getPositionY());

                    woman.render(gc);
                    man.render(gc);
                    movebtn.render(gc);
                } else {
                    Alert error = new Alert(Alert.AlertType.INFORMATION);
                    error.setHeaderText("Invalid Move");
                    error.setContentText("Something will get eaten!! :)");
                    error.showAndWait();
                }
            }
        });
    }

    public void setController2(Controller3 controller2) {
        this.controller2 = controller2;
    }
}