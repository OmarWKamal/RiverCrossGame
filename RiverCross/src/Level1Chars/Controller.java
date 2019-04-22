package Level1Chars;

import View.LEVEL_1;
import View.start_page;

import java.util.ArrayList;
import java.util.List;

public class Controller implements IRiverCrossingController, ICrossingStrategy{
    LEVEL_1 level_1;
    Strategy1 strategy1;
    start_page start_page;

    private ICrosser farmer = Farmer.getInstance();
    ICrosser goat = new Sheep();
    ICrosser wolf = new Wolf();
    ICrosser plant = new Plant();

    boolean rowers = true;

    List<ICrosser> crossers = new ArrayList<>();
    List<ICrosser> LowerBankCrossers = new ArrayList<>();
    List<ICrosser> UpperBankCrossers = new ArrayList<>();

    public Controller(LEVEL_1 level_1, Strategy1 strategy1, start_page start_page) {
        this.level_1 = level_1;
        this.strategy1 = strategy1;
        this.start_page = start_page;
    }
    public void Level1BuildScene(){
        level_1.scene_build();
    }
    public void MenuBuildScene(){
        start_page.scene_build();
    }
    public void setCrossers(String crosser){
        if(strategy1.isValid(LowerBankCrossers, UpperBankCrossers, crossers)) {
            //PRINTING
            for(int i = 0; i < crossers.size(); i++){
                System.out.println(crossers.get(i));
            }
            for(int i = 0; i < crossers.size(); i++){
                System.out.println(LowerBankCrossers.get(i));
            }
            for(int i = 0; i < crossers.size(); i++){
                System.out.println(UpperBankCrossers.get(i));
            }

            if (crosser.equals("farmer")) {
                crossers.add(farmer);
                LowerBankCrossers.remove(farmer);
            } else if (crosser.equals("sheep")) {
                crossers.add(goat);
                LowerBankCrossers.remove(goat);
            } else if (crosser.equals("wolf")){
                crossers.add(wolf);
                LowerBankCrossers.remove(wolf);
            } else if (crosser.equals("plant")) {
                crossers.add(plant);
                LowerBankCrossers.remove(plant);
            }
        }
    }

    //update upperbank chars on pressing row key
    public void UpdateUpperBankRowers(){
        for(int i = 0; i < crossers.size(); i++){
            UpperBankCrossers.add(crossers.get(i));
        }
    }
    public boolean isValid(){
        System.out.println("rowers " + crossers.size());
        System.out.println("lowerbank crosser " + LowerBankCrossers.size());
        return strategy1.isValid(UpperBankCrossers, LowerBankCrossers, crossers);
    }

    public void setLowerBankCrossers() {
        LowerBankCrossers.add(farmer);
        LowerBankCrossers.add(goat);
        LowerBankCrossers.add(plant);
        LowerBankCrossers.add(wolf);

    }

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        setLowerBankCrossers();
        UpperBankCrossers.clear();
        crossers.clear();
    }

    @Override
    public void resetGame() {
        setLowerBankCrossers();
        UpperBankCrossers.clear();
        crossers.clear();
    }

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
                                return false;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        return null;
    }

    @Override
    public String[] getInstructions() {
        return new String[0];
    }

    @Override
    public List<ICrosser> getCrossersOnUpperBank() {
        return null;
    }

    @Override
    public List<ICrosser> getCrossersOnLowerBank() {
        return null;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return false;
    }

    @Override
    public int getNumberOfSails() {
        return 0;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        boolean sail = false;
        for(int i = 0; i < crossers.size(); i++)
        {
            if(crossers.get(i).canSail()){
                sail = true;
                break;
            }
        }
        if(sail == true)
        {
            if(crossers.size() > 2)
                return false;
            else {
                //remove chars from lower bank
                for(int i = 0 ; i < LowerBankCrossers.size(); i++)
                {
                    for(int j = 0; j < crossers.size(); j++)
                    {
                        if(LowerBankCrossers.get(i).equals(crossers.get(j)))
                            LowerBankCrossers.remove(i);
                    }
                }
                //add them to the upper bank
                for(int i = 0 ; i < crossers.size(); i++)
                {
                    UpperBankCrossers.add(crossers.get(i));
                }
                return true;
            }
        }
        else
            return sail;
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLowerToUpperBank) {

    }

    @Override
    public boolean canUndo() {
        return false;
    }

    @Override
    public boolean canRedo() {
        return false;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }
}
