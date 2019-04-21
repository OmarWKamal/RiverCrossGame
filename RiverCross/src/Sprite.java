import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    private Image image;
    private double positionX;
    private double positionY;
    private double width;
    private double height;


    public Sprite(Image imagee) {
        this.image = imagee;
        this.positionX = 0;
        this.positionY = 0;
        this.width = imagee.getWidth();
        this.height = imagee.getHeight();
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

    public boolean validmove(Sprite sprite)
    {
        return true;
    }


    public void render(GraphicsContext gc) {
        gc.drawImage(image, positionX, positionY);
    }
}
