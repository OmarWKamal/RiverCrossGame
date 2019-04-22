package Level1Chars;

import java.awt.image.BufferedImage;

public interface ICrosser {

    // @return whether the crosser can sail the boat or not

    boolean canSail();

    //@return get the weight of the crosser

    double getWeight();

    /* @return get the eating rank of the crosser
     * this rank can be used to detect if one
     * crosser can eat/harm another crosser*/

    int getEatingRank();

    /**
     * @return images of the crosser
     * each crosser must have at least two images, each one
     * is used on one bank of the river
     */
    BufferedImage[] getImages();

    /**
     * @return exact copy of the crosser
     */
    ICrosser makeCopy();

    /**
     * @return gets label of the crosser depending on the current game
     */
    String getLabelToBeShown();

    /**
     * this field is used by the game strategy to set the label which
     * <p>
     * will be shown beside the crosser in the game view
     * to inform the user about the criteria of the current level
     * e.g. crosser eating rank
     */
    void setLabelToBeShown(String label);
}
