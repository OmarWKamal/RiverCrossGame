package View;

import Level1Chars.Controller;
import Level1Chars.Strategy;
import Level2Chars.Controller2;
import Level2Chars.Strategy2;
import Level3.Controller3;
import Level3.Strategy3;
import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RIVER CROSSING");
        start_page startpage = new start_page(primaryStage);
        LEVEL_1 level_1 = new LEVEL_1(primaryStage);
        LEVEL_2 level_2 = new LEVEL_2(primaryStage);
        Strategy strategy1 = new Strategy();
        Strategy2 strategy2 = new Strategy2();
        Strategy3 strategy3 = new Strategy3();
        LEVEL_3 level_3 = new LEVEL_3(primaryStage);
        startpage.setlevel_2(level_2);
        level_3.set_start_page(startpage);
        level_2.set_start_page(startpage);
        Controller controller = new Controller(level_1, strategy1, startpage);
        Controller3 controller3 = new Controller3(level_3, strategy3, startpage);
        Controller2 controller2 = new Controller2(level_2, strategy2, startpage);
        controller.setLowerBankCrossers();
        level_2.setController2(controller2);
        level_3.setController2(controller3);



        //startpage.scene_build();
        controller.MenuBuildScene();
        level_1.setController(controller);
        controller.Level1BuildScene();
        //level_1.scene_build();
        level_1.setStrategy(strategy1);
        startpage.setlevel_1(level_1);
        startpage.setlevel_2(level_2);
        level_1.setStartPage(startpage);
        level_3.scene_build();
        level_2.scene_build();


        primaryStage.setScene(startpage.getScene());
        primaryStage.show();


    }
}