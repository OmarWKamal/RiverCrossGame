package Level2Chars.ICrosserCharacters;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Farmer4 implements ICrosser {
    private static Farmer4 farmer4 = new Farmer4();

    public static synchronized Farmer4 getInstance() {
        return farmer4;
    }

    private Farmer4() {
    }

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public int getWeight() {
        return 40;
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
