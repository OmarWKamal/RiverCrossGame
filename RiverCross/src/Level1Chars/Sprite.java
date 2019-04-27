package Level1Chars;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.Serializable;

public class Sprite implements Serializable {
    private Image image;
    private double positionX;
    private double positionY;
    private double width;
    private double height;
    private int weight;
    private int location;
    private int rank;

    public void setLocation(int location) {
        this.location = location;
    }



    public Sprite() {
	}

	public Sprite(Image imagee) {
        this.image = imagee;
        this.positionX = 0;
        this.positionY = 0;
        this.width = imagee.getWidth();
        this.height = imagee.getHeight();
        this.location = 1;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean validmove(Sprite sprite) {
        return true;
    }


    public void render(GraphicsContext gc) {
        gc.drawImage(image, positionX, positionY);
    }


    public int getLocation() {
        return location;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

}

