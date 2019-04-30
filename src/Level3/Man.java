package Level3;

import Level1Chars.ICrosser;

import java.awt.image.BufferedImage;

public class Man implements ICrosser {
    private static Man man = new Man();

    public static synchronized Man getInstance() {
        return man;
    }

    private Man() {
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
