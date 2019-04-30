package Level3;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Boy implements ICrosser {

    private static Boy boy = new Boy();

    public static synchronized Boy getInstance() {
        return boy;
    }

    private Boy() {
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
