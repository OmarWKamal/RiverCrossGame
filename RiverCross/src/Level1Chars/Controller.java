package Level1Chars;

import Level1Chars.GameStates.GameState;
import View.LEVEL_1;
import View.start_page;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller implements IRiverCrossingController, java.io.Serializable {
    LEVEL_1 level_1;
    Strategy strategy1;
    start_page start_page;
    public Sprite2 x1; //farmer/
    public Sprite2 x2; //raft
    public Sprite2 x3; //goat
    public Sprite2 x4; //wolf
    public Sprite2 x5; //plant
    public Sprite2 x6; //star
    public Controller() {
    }


    private ICrosser farmer = Farmer.getInstance();
    private ICrosser goat = Sheep.getInstance();
    private ICrosser wolf = Wolf.getInstance();
    private ICrosser plant = Plant.getInstance();

    boolean rowers = true;

    ArrayList<ICrosser> crossers = new ArrayList<>();
    ArrayList<ICrosser> LowerBankCrossers = new ArrayList<>();
    ArrayList<ICrosser> UpperBankCrossers = new ArrayList<>();

    public void clearcrossers(){
        this.crossers.clear();
    }

    public void setCrossers(ArrayList<ICrosser> crossers) {
        this.crossers = crossers;
    }

    public void setLowerBankCrossers(ArrayList<ICrosser> lowerBankCrossers) {
        this.LowerBankCrossers = lowerBankCrossers;
    }

    public void setUpperBankCrossers(ArrayList<ICrosser> upperBankCrossers) {
        this.UpperBankCrossers = upperBankCrossers;
    }

    public ArrayList<ICrosser> getCrossers() {
        return crossers;
    }

    public ArrayList<ICrosser> getLowerBankCrossers() {
        return LowerBankCrossers;
    }

    public ArrayList<ICrosser> getUpperBankCrossers() {
        return UpperBankCrossers;
    }

    public void setCrossersInMemento(GameState gameState)
    {
        gameState.setUpperBankCrossers(UpperBankCrossers);
        gameState.setLowerBankCrossers(LowerBankCrossers);
        gameState.setCrossers(crossers);
    }


    public void checkFarmerLocation(int location){
        int loc = 0;
        if(location == 1){
            if(UpperBankCrossers.contains(farmer))
                UpperBankCrossers.remove(farmer);
            if(crossers.contains(farmer))
                crossers.remove(farmer);
            if(LowerBankCrossers.contains(farmer))
                return;
            else
                LowerBankCrossers.add(farmer);
            loc = 1;
        }
        else if(location == 2){
            if(LowerBankCrossers.contains(farmer))
                LowerBankCrossers.remove(farmer);
            if(!UpperBankCrossers.contains(farmer))
                UpperBankCrossers.add(farmer);
            if(!crossers.contains(farmer))
                crossers.add(farmer);
            loc = 1;
        }
        else if(location  == 3){
            if(UpperBankCrossers.contains(farmer))
                UpperBankCrossers.remove(farmer);
            if(!LowerBankCrossers.contains(farmer))
                LowerBankCrossers.add(farmer);
            if(!crossers.contains(farmer))
                crossers.add(farmer);
            loc = 1;
        }else if(location  == 4){
            if(LowerBankCrossers.contains(farmer))
                LowerBankCrossers.remove(farmer);
            if(crossers.contains(farmer))
                crossers.remove(farmer);
            if(LowerBankCrossers.contains(farmer))
                return;
            else
                LowerBankCrossers.add(farmer);
            loc = 1;
        }
        System.out.println("************************** location" + loc);
    }
    public void checkGoatLocation(int location ){
        if(location  == 1){
            if(UpperBankCrossers.contains(goat))
                UpperBankCrossers.remove(goat);
            if(crossers.contains(goat))
                crossers.remove(goat);
            if(LowerBankCrossers.contains(goat))
                return;
            else
                LowerBankCrossers.add(goat);
        }
        else if(location  == 2){
            if(LowerBankCrossers.contains(goat))
                LowerBankCrossers.remove(goat);
            if(!UpperBankCrossers.contains(goat))
                UpperBankCrossers.add(goat);
            if(!crossers.contains(goat))
                crossers.add(goat);
        }
        else if(location  == 3){
            if(UpperBankCrossers.contains(goat))
                UpperBankCrossers.remove(goat);
            if(!LowerBankCrossers.contains(goat))
                LowerBankCrossers.add(goat);
            if(!crossers.contains(goat))
                crossers.add(goat);
        }else if(location  == 4){
            if(LowerBankCrossers.contains(goat))
                LowerBankCrossers.remove(goat);
            if(crossers.contains(goat))
                crossers.remove(goat);
            if(LowerBankCrossers.contains(goat))
                return;
            else
                LowerBankCrossers.add(goat);
        }
        System.out.println("************************** location" + location );
    }
    public void checkWolfLocation(int location ){
        if(location  == 1){
            if(UpperBankCrossers.contains(wolf))
                UpperBankCrossers.remove(wolf);
            if(crossers.contains(wolf))
                crossers.remove(wolf);
            if(LowerBankCrossers.contains(wolf))
                return;
            else
                LowerBankCrossers.add(wolf);
        }
        else if(location  == 2){
            if(LowerBankCrossers.contains(wolf))
                LowerBankCrossers.remove(wolf);
            if(!UpperBankCrossers.contains(wolf))
                UpperBankCrossers.add(wolf);
            if(!crossers.contains(wolf))
                crossers.add(wolf);
        }
        else if(location  == 3){
            if(UpperBankCrossers.contains(wolf))
                UpperBankCrossers.remove(wolf);
            if(!LowerBankCrossers.contains(wolf))
                LowerBankCrossers.add(wolf);
            if(!crossers.contains(wolf))
                crossers.add(wolf);
        }else if(location  == 4){
            if(LowerBankCrossers.contains(wolf))
                LowerBankCrossers.remove(wolf);
            if(crossers.contains(wolf))
                crossers.remove(wolf);
            if(LowerBankCrossers.contains(wolf))
                return;
            else
                LowerBankCrossers.add(wolf);
        }
        System.out.println("************************** location" + location );

    }
    public void checkPlantLocation(int location ){
        if(location  == 1){
            if(UpperBankCrossers.contains(plant))
                UpperBankCrossers.remove(plant);
            if(crossers.contains(plant))
                crossers.remove(plant);
            if(LowerBankCrossers.contains(plant))
                return;
            else
                LowerBankCrossers.add(plant);
        }
        else if(location == 2){
            if(LowerBankCrossers.contains(plant))
                LowerBankCrossers.remove(plant);
            if(!UpperBankCrossers.contains(plant))
                UpperBankCrossers.add(plant);
            if(!crossers.contains(plant))
                crossers.add(plant);
        }
        else if(location == 3){
            if(UpperBankCrossers.contains(plant))
                UpperBankCrossers.remove(plant);
            if(!LowerBankCrossers.contains(plant))
                LowerBankCrossers.add(plant);
            if(!crossers.contains(plant))
                crossers.add(plant);
        }else if(location == 4){
            if(LowerBankCrossers.contains(plant))
                LowerBankCrossers.remove(plant);
            if(crossers.contains(plant))
                crossers.remove(plant);
            if(LowerBankCrossers.contains(plant))
                return;
            else
                LowerBankCrossers.add(plant);
        }
        System.out.println("************************** location" + location );

    }

    public boolean success()
    {
       // System.out.println(UpperBankCrossers.size() + "   "  +LowerBankCrossers.size() + "   "+  crossers.size());
        if(UpperBankCrossers.size() == 4 && LowerBankCrossers.size() == 0 && crossers.size() == 0)
            return true;
        else
            return false;
    }

    public int Ranking()
    {
        int moves = level_1.getNumOfSails();
        if(UpperBankCrossers.size() == 4 && LowerBankCrossers.size() == 0 && crossers.size() == 0)
        {
            if(moves == 7)
                return 3;
            else if(moves < 11)
                return 2;
            else
                return 1;
        }
        else
            return 0;
    }



    public Controller(LEVEL_1 level_1, Strategy strategy1, start_page start_page) {
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
    public boolean CrosserOnRift(){
        if(crossers.size() <= 2)
            return true;
        else
            return false;
    }
    //*******************************************************************************************************
    public void setCrossersMovingUp(String crosser){

        if (crosser.equals("farmer")) {
            if(!crossers.contains(farmer)){
                crossers.add(farmer);
                UpperBankCrossers.add(farmer);
                LowerBankCrossers.remove(farmer);
            }
        } else if (crosser.equals("goat")) {
            if(!crossers.contains(goat)) {
                crossers.add(goat);
                LowerBankCrossers.remove(goat);
                UpperBankCrossers.add(goat);
            }
        } else if (crosser.equals("wolf")){
            if(!crossers.contains(wolf)) {
                crossers.add(wolf);
                LowerBankCrossers.remove(wolf);
                UpperBankCrossers.add(wolf);
            }
        } else if (crosser.equals("plant")) {
            //if it doesnt exist add it
            if(!crossers.contains(plant)) {
                crossers.add(plant);
                LowerBankCrossers.remove(plant);
                UpperBankCrossers.add(plant);
            }
        }
    }
    public void setCrossersMovingDown(String crosser){

        if (crosser.equals("farmer")) {
            if(!crossers.contains(farmer)){
                crossers.add(farmer);
                UpperBankCrossers.remove(farmer);
                LowerBankCrossers.add(farmer);
            }
        } else if (crosser.equals("goat")) {
            if(!crossers.contains(goat)) {
                crossers.add(goat);
                LowerBankCrossers.add(goat);
                UpperBankCrossers.remove(goat);
            }
        } else if (crosser.equals("wolf")){
            if(!crossers.contains(wolf)) {
                crossers.add(wolf);
                LowerBankCrossers.add(wolf);
                UpperBankCrossers.remove(wolf);
            }
        } else if (crosser.equals("plant")) {
            //if it doesnt exist add it
            if(!crossers.contains(plant)) {
                crossers.add(plant);
                LowerBankCrossers.add(plant);
                UpperBankCrossers.remove(plant);
            }
        }
    }
    //*******************************************************************************************************
    public void setLowerBankCrossers() {
        if(LowerBankCrossers.size() != 0)
            LowerBankCrossers.clear();
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
    public String[] getInstructions() {
        return new String[0];
    }

    @Override
    public List<ICrosser> getCrossersOnUpperBank() {
        return UpperBankCrossers;
    }

    @Override
    public List<ICrosser> getCrossersOnLowerBank() {
        return LowerBankCrossers;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return level_1.getRiftLocation();
    }

    @Override
    public int getNumberOfSails() {
        return level_1.getNumOfSails();
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        boolean isvalid = strategy1.isValid(UpperBankCrossers, LowerBankCrossers, this.crossers);
        return isvalid;
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
    public void saveGame(Sprite2 farmer, Sprite2 raft, Sprite2 goat, Sprite2 wolf , Sprite2 plant) {
        try {
            //	FileOutputStream filestream = new FileOutputStream(new File("./save_level1.xml"));
            XMLEncoder encoder = new XMLEncoder( new BufferedOutputStream( new FileOutputStream(new File (("./save_level1.xml")))));

            encoder.writeObject(farmer);
            encoder.writeObject(raft);
            encoder.writeObject(goat);
            encoder.writeObject(wolf);
            encoder.writeObject(plant);
            System.out.println("save is done");
            encoder.close();
            //filestream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public  void  loadGame() {
        FileInputStream file;
        LowerBankCrossers.clear();
        UpperBankCrossers.clear();
        crossers.clear();
        try {
            file = new FileInputStream (new File("./save_level1.xml"));
            XMLDecoder decoder = new XMLDecoder(file);

            x1 = (Sprite2) decoder.readObject();
            x2= (Sprite2) decoder.readObject();
            x3= (Sprite2) decoder.readObject();
            x4 = (Sprite2) decoder.readObject();
            x5= (Sprite2) decoder.readObject();
            decoder.close();

            System.out.println("farmer location " + x1.getLocation());
            System.out.println("goat location " + x3.getLocation());
            System.out.println("wolf location " + x4.getLocation());
            System.out.println("plant location " + x5.getLocation());

            //setting arrays of chars
            if(x1.getLocation() == 1)
                LowerBankCrossers.add(farmer);
            else if(x1.getLocation() == 2) {
                crossers.add(farmer);
                UpperBankCrossers.add(farmer);
            }
            else if(x1.getLocation() == 3) {
                crossers.add(farmer);
                LowerBankCrossers.add(farmer);
            }
            else
                UpperBankCrossers.add(farmer);

            if(x3.getLocation() == 1)
                LowerBankCrossers.add(goat);
            else if(x3.getLocation() == 2) {
                crossers.add(goat);
                UpperBankCrossers.add(goat);
            }
            else if(x3.getLocation() == 3) {
                crossers.add(goat);
                LowerBankCrossers.add(goat);
            }
            else
                UpperBankCrossers.add(goat);

            if(x4.getLocation() == 1)
                LowerBankCrossers.add(wolf);
            else if(x4.getLocation() == 2) {
                crossers.add(wolf);
                UpperBankCrossers.add(wolf);
            }
            else if(x4.getLocation() == 3) {
                crossers.add(wolf);
                LowerBankCrossers.add(wolf);
            }
            else
                UpperBankCrossers.add(wolf);

            if(x5.getLocation() == 1)
                LowerBankCrossers.add(plant);
            else if(x5.getLocation() == 2) {
                crossers.add(plant);
                UpperBankCrossers.add(plant);
            }
            else if(x5.getLocation() == 3) {
                crossers.add(plant);
                LowerBankCrossers.add(plant);
            }
            else
                UpperBankCrossers.add(plant);
            //********************


            try {
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }

    public boolean checkLoad() {
        FileInputStream file;
        try {
            file = new FileInputStream (new File("./save_level1.xml"));
            //file = new FileInputStream (new File("save_level1.xml"));
            if(file!=null)
                return true;
            else
                return false;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}