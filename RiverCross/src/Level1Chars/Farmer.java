package Level1Chars;

import java.awt.image.BufferedImage;

public class Farmer implements ICrosser{
    String farmerstatus;

    private static Farmer farmer = new Farmer();

    public static synchronized Farmer getInstance() {
        return farmer;
    }

    private Farmer() {
    }

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public int getEatingRank() {
        return 10;
    }

    @Override
    public BufferedImage[] getImages() {
        //return array of the farmer moving
        return new BufferedImage[0];
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public String getLabelToBeShown() {
        return this.farmerstatus;
    }

    @Override
    public void setLabelToBeShown(String label) {
        this.farmerstatus = label;
    }
}
