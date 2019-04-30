package Level2Chars.ICrosserCharacters;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Animal1 implements ICrosser {

    private static Animal1 animal1 = new Animal1();

    public static synchronized Animal1 getInstance() {
        return animal1;
    }

    private Animal1() {
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
