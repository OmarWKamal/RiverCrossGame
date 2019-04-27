package Level1Chars;

import java.awt.image.BufferedImage;

public class Plant implements ICrosser{
    private static Plant ourInstance = new Plant();

    public static synchronized                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   Plant getInstance() {
        return ourInstance;
    }

    private Plant() {
    }
    String plantstatus;

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
        return this.plantstatus;
    }

    @Override
    public void setLabelToBeShown(String label) {
        this.plantstatus = label;
    }
}
