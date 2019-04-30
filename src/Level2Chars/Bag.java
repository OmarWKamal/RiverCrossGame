package Level2Chars;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Bag implements ICrosser {

    private static Bag bag = new Bag();

    public static synchronized Bag getInstance() {
        return bag;
    }

    private Bag() {
    }

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public int getWeight() {
        return 20;
    }

    @Override
    public int getEatingRank() {
        return 0;
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
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {

    }
}
