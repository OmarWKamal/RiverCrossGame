package Level1Chars;

import java.awt.image.BufferedImage;

public class Wolf implements ICrosser{
    private static Wolf ourInstance = new Wolf();

    public static synchronized Wolf getInstance() {
        return ourInstance;
    }

    private Wolf() {
    }
    String status;

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public int getEatingRank() {
        return -2;
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
        return status;
    }

    @Override
    public void setLabelToBeShown(String label) {
        status = label;
    }
}
