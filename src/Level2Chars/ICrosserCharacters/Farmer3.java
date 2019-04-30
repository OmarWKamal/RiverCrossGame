package Level2Chars.ICrosserCharacters;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Farmer3 implements ICrosser {
    private static Farmer3 farmer3 = new Farmer3();

    public static synchronized Farmer3 getInstance() {
        return farmer3;
    }

    private Farmer3() {
    }

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public int getWeight() {
        return 60;
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
