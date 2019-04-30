package Level2Chars.ICrosserCharacters;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Farmer1 implements ICrosser {
    private static Farmer1 farmer1 = new Farmer1();

    public static synchronized Farmer1 getInstance() {
        return farmer1;
    }

    private Farmer1() {
    }

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public int getWeight() {
        return 90;
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
