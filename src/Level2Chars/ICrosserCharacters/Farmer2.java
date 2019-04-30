package Level2Chars.ICrosserCharacters;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Farmer2 implements ICrosser {
    private static Farmer2 farmer2 = new Farmer2();

    public static synchronized Farmer2 getInstance() {
        return farmer2;
    }

    private Farmer2() {
    }

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public int getWeight() {
        return 80;
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
