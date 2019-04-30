package View;

import Level1Chars.Controller;
import Level1Chars.Sprite;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class start_page {
    Stage stage;
    Scene scene;
    LEVEL_1 level_1;
    LEVEL_3 level_3;
    LEVEL_2 level_2;
    
    Controller controller;
    GraphicsContext gc;
    Image starimg = new Image ("Assets/star.png");
    Sprite star = new Sprite(starimg);
    Image image1 = new Image("Assets/leve1 btn.png");
    Sprite level1 = new Sprite(image1);
    Image imagelvl2 = new Image("Assets/LEVEL2.png");
    Sprite lvl2 = new Sprite(imagelvl2);
    public start_page(Stage stage) {
        this.stage = stage;
    }

    public void scene_build() {
    	 Pane root = new Pane();
         Canvas canvas = new Canvas(600, 600);
         root.getChildren().add(canvas);
          gc = canvas.getGraphicsContext2D();

        Image image = new Image("Assets/background.png");
        Sprite background = new Sprite(image);
        background.setPositionX(0);
        background.setPositionY(0);
        background.render(gc);
           
        level1.setPositionX(30);
        level1.setPositionY(50);
        level1.render(gc);
        lvl2.setPositionX(50+level1.getWidth());
        lvl2.setPositionY(50);
lvl2.render(gc);
System.out.println("width is  "+level1.getWidth()+  "  height is  "+level1.getHeight());
        scene = new Scene (root,600,600);
        set_star();

        //////            stage.setScene(level_1.getScene());
       scene.setOnMouseClicked((MouseEvent) ->{
        	
            double x = MouseEvent.getSceneX();
            double y = MouseEvent.getSceneY();
        	if ((x >= level1.getPositionX()) && (x < level1.getPositionX() + level1.getWidth())
                    && (y >= level1.getPositionY()) && (y < level1.getPositionY() + level1.getHeight())) {
        		stage.setScene(level_1.getScene());
        		System.out.println("a7a");
        	}

        	else  if ((x >= lvl2.getPositionX()) && (x < lvl2.getPositionX() + lvl2.getWidth())
                    && (y >= lvl2.getPositionY()) && (y < lvl2.getPositionY() + lvl2.getHeight())) {
        		stage.setScene(level_2.getScene());
        		System.out.println("a7ten");
        		
        	}
        	
    }
                );
        
   
               

    }

    public Scene getScene() {
        return this.scene;
    }

    public void setlevel_1(LEVEL_1 level_1) {
        this.level_1 = level_1;
    }
    public void setlevel_2(LEVEL_2 level_2) {
        this.level_2 = level_2;
    }
    public void set_star() {
    	controller = new Controller();
    	controller.loadGame();
        star.setFinish(controller.x1.getFinish());
        star.setRank(controller.x1.getRank());

 System.out.println("***********************\n");
 System.out.println(star.getRank());
        if(star.getFinish()==1) {
            star.setRank(controller.x1.getRank());
            star.setFinish(controller.x1.getFinish());
        	if(star.getRank()==7) {
        		star.setPositionX(50);
        	star.setPositionY(60+level1.getHeight());
        		star.render(gc);
        	star.setPositionX(100);
        		star.setPositionY(60+level1.getHeight());
        		star.render(gc);
        		star.setPositionX(150);
        		star.setPositionY(60+level1.getHeight());
        		star.render(gc);
        	}
        	else if(star.getRank()<=11) {
        		star.setPositionX(50);
            	star.setPositionY(60+level1.getHeight());
            		star.render(gc);
            	star.setPositionX(100);
            		star.setPositionY(60+level1.getHeight());
            		star.render(gc);
        	}
        	else
        	{
        		star.setPositionX(50);
            	star.setPositionY(60+level1.getHeight());
            		star.render(gc);
        	}
        }
    }


}
