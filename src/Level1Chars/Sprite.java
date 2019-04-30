package Level1Chars;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite implements java.io.Serializable {
    private Image image;
    private double positionX;
    private double positionY;
    private double width;
    private double height;
    private int weight;
    private int location;
    private int  rank;
    private int finish;
    
    // if location = 1 this means on the lower bank
    // if location = 2  this means on the raftlower
    // if location = 3 this means on raft upper
    // if location = 4 this means on the upperbank
    


	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

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
        this.rank=0;
        this.finish=0;
    }

    /**
	 * @return the finish
	 */
	public int getFinish() {
		return finish;
	}

	/**
	 * @param finish the finish to set
	 */
	public void setFinish(int finish) {
		this.finish = finish;
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
}
