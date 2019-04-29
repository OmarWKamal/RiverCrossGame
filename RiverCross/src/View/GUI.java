package View;

import Level1Chars.Controller;
import Level1Chars.Strategy;
import Level2Chars.Controller2;
import Level2Chars.Strategy2;
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
        Strategy strategy1 = new Strategy();
        Strategy2 strategy2 = new Strategy2();
        LEVEL_2 level_2 = new LEVEL_2(primaryStage);
        startpage.setlevel_2(level_2);
        level_2.set_start_page(startpage);
        level_2.scene_build();
        Controller controller = new Controller(level_1, strategy1, startpage);
        Controller2 controller2 = new Controller2(level_2, strategy2, startpage);
        controller.setLowerBankCrossers();



        //startpage.scene_build();
        controller.MenuBuildScene();
        level_1.setController(controller);
        controller.Level1BuildScene();
        //level_1.scene_build();
        level_1.setStrategy(strategy1);
        startpage.setlevel_1(level_1);
        level_1.setStartPage(startpage);



        primaryStage.setScene(startpage.getScene());
        primaryStage.show();


    }
}