package Level2Chars;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Girl implements ICrosser {


    private static Girl girl = new Girl();

    public static synchronized Girl getInstance() {
        return girl;
    }

    private Girl() {
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
