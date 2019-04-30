package Level3;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Woman implements ICrosser {


    private static Woman woman = new Woman();

    public static synchronized Woman getInstance() {
        return woman;
    }

    private Woman() {}

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
