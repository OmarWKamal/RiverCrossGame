package Level1Chars;


import java.util.List;

public interface IRiverCrossingController  {

    /**
     * this method initialize the controller with game strategy according
     * to the level
     * @param gameStrategy
     */
    public void newGame(ICrossingStrategy gameStrategy);
    /**
     * resets the game without changing the strategy
     */
    public void resetGame();
    /**
     * @return the current strategy instructions if the user want to see
    them
     */
    public String[] getInstructions();
    /**
     * @return list of crossers on the right bank of the river
     */
    public List<ICrosser> getCrossersOnUpperBank();
    /**
     * @return list of crossers on the left bank of the river
     */
    public List<ICrosser> getCrossersOnLowerBank();
    /**
     * @return determines whether the boat is on the left or on the right

*/

    public boolean isBoatOnTheLeftBank();
    /**
     * @return returns the number of sails that the user have done so far
     */
    public int getNumberOfSails();
    /**
     * @param crossers which the user selected to move
     * @param fromLeftToRightBank boolean to inform the controller
     * with the direction of the current game
     * @return boolean if it is a valid move or not
     */
    public boolean canMove(List<ICrosser> crossers, boolean
            fromLeftToRightBank);
    /**
     * this method ysed to perform the move if it is valid
     * @param crossers
     * @param fromLeftToRightBank
     */
    public void doMove(List<ICrosser> crossers, boolean
            fromLeftToRightBank);
    /**
     * @return boolean providing that the undo action can be done or not
     */
    public boolean canUndo();
    /**
     * @return boolean providing that the redo action can be done or not
     */
    public boolean canRedo();


    /**
     * undo to the last game state
     */
    public void undo();
    /**
     * redo the undo actions
     */
    public void redo();
    /**
     * saves the game state
     * (left bank crossers, right bank crossers, number of done sails,
     position of the boat)
     */
  
    public void saveGame();

    void saveGame(Sprite farmer, Sprite raft, Sprite goat, Sprite wolf, Sprite plant);

    void saveGame(Level2Chars.Sprite farmer1, Level2Chars.Sprite farmer2, Level2Chars.Sprite farmer3, Level2Chars.Sprite farmer4,
                  Level2Chars.Sprite animal1, Level2Chars.Sprite animal2, Level2Chars.Sprite animal3, Level2Chars.Sprite animal4,
                  Level2Chars.Sprite raft);

    /**
     * load the saved game state
     */
    public void loadGame();

    void saveGame(Level3.Sprite2 boy, Level3.Sprite2 raft, Level3.Sprite2 girl, Level3.Sprite2 man, Level3.Sprite2 woman, Level3.Sprite2 bag);

    void saveGame2(Level3.Sprite2 boy, Level3.Sprite2 raft, Level3.Sprite2 girl, Level3.Sprite2 man, Level3.Sprite2 woman, Level3.Sprite2 bag);

    void   loadGame2();

    /**
     * this function is bonus
     * it returns the boat riders starting from the beginning of the game
     * until the final solution to show the user the solution
     */
    public List<List<ICrosser>> solveGame();

}