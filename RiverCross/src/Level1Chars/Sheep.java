package Level1Chars;

import java.awt.image.BufferedImage;

public class Sheep implements ICrosser{
    private static Sheep ourInstance = new Sheep();

    public static synchronized Sheep getInstance() {
        return ourInstance;
    }

    private Sheep() {
    }
    String sheepstatus;

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public int getEatingRank() {
        return 2;
    }

    @Override
    public BufferedImage[] getImages() {
        return new BufferedImage[0];
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public String getLabelToBeShown() {
        return this.sheepstatus;
    }

    @Override
    public void setLabelToBeShown(String label) {
        this.sheepstatus = label;
    }
}
