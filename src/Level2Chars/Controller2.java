package Level2Chars;

import Level1Chars.GameStates.GameState;
import Level1Chars.ICrosser;
import Level1Chars.ICrossingStrategy;
import Level1Chars.IRiverCrossingController;
import Level1Chars.Sprite;
import Level2Chars.ICrosserCharacters.*;
import View.LEVEL_1;
import View.LEVEL_2;
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

public class Controller2 implements IRiverCrossingController, java.io.Serializable {

    //**************************************************************
     LEVEL_2 level_2;
    //**************************************************************
    Strategy2 strategy2;
    start_page start_page;
    public Sprite2 x1; //farmer1
    public Sprite2 x2; //farmer2
    public Sprite2 x3; //farmer3
    public Sprite2 x4; //farmer4
    public Sprite2 x5; //animal1
    public Sprite2 x6; //animal2
    public Sprite2 x7; //animal3
    public Sprite2 x8; //animal4
    public Sprite2 x9; //raft
    public Sprite2 x10; //star
    public Controller2() {
    }


    private ICrosser farmer1 = Farmer1.getInstance();
    private ICrosser farmer2 = Farmer2.getInstance();
    private ICrosser farmer3 = Farmer3.getInstance();
    private ICrosser farmer4 = Farmer4.getInstance();
    private ICrosser animal = Animal1.getInstance();

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

    public void checkCrosserLocation(int location, String character) {
        ICrosser crosser = null;
        if (character.equals("farmer1")) {
            crosser = farmer1;
        } else if (character.equals("farmer2")) {
            crosser = farmer2;
        } else if (character.equals("farmer3")) {
            crosser = farmer3;
        } else if (character.equals("farmer4")) {
            crosser = farmer4;
        } else if (character.equals("animal")) {
            crosser = animal;


            int loc = 0;
            if (location == 1) {
                if (UpperBankCrossers.contains(crosser))
                    UpperBankCrossers.remove(crosser);
                if (crossers.contains(crosser))
                    crossers.remove(crosser);
                if (LowerBankCrossers.contains(crosser))
                    return;
                else
                    LowerBankCrossers.add(crosser);
                loc = 1;
            } else if (location == 2) {
                if (LowerBankCrossers.contains(crosser))
                    LowerBankCrossers.remove(crosser);
                if (!UpperBankCrossers.contains(crosser))
                    UpperBankCrossers.add(crosser);
                if (!crossers.contains(crosser))
                    crossers.add(crosser);
                loc = 1;
            } else if (location == 3) {
                if (UpperBankCrossers.contains(crosser))
                    UpperBankCrossers.remove(crosser);
                if (!LowerBankCrossers.contains(crosser))
                    LowerBankCrossers.add(crosser);
                if (!crossers.contains(crosser))
                    crossers.add(crosser);
                loc = 1;
            } else if (location == 4) {
                if (LowerBankCrossers.contains(crosser))
                    LowerBankCrossers.remove(crosser);
                if (crossers.contains(crosser))
                    crossers.remove(crosser);
                if (LowerBankCrossers.contains(crosser))
                    return;
                else
                    LowerBankCrossers.add(crosser);
                loc = 1;
            }
            System.out.println("************************** location" + loc);
        }
    }

    public boolean success()
    {
        // System.out.println(UpperBankCrossers.size() + "   "  +LowerBankCrossers.size() + "   "+  crossers.size());
        if(UpperBankCrossers.size() == 4 && LowerBankCrossers.size() == 0 && crossers.size() == 0)
            return true;
        else
            return false;
    }

    //*****************************************************************************************************************
    /*public int Ranking()
    {
        int moves = level_2.getNumOfSails();
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
    }*/
    //*****************************************************************************************************************


    public Controller2(LEVEL_2 level_2, Strategy2 strategy2, start_page start_page) {
        this.level_2 = level_2;
        this.strategy2 = strategy2;
        this.start_page = start_page;
    }
    //*****************************************************************************************************************
    public void Level2BuildScene(){
    //    level_2.scene_build();
    }
    //*****************************************************************************************************************
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
    public void setCrossersMovingUp(String crosser) {

        if (crosser.equals("farmer1")) {
            if (!crossers.contains(farmer1)) {
                crossers.add(farmer1);
                UpperBankCrossers.add(farmer1);
                LowerBankCrossers.remove(farmer1);
            }
        } else if (crosser.equals("farmer2")) {
            if (!crossers.contains(farmer2)) {
                crossers.add(farmer2);
                LowerBankCrossers.remove(farmer2);
                UpperBankCrossers.add(farmer2);
            }
        } else if (crosser.equals("farmer3")) {
            if (!crossers.contains(farmer3)) {
                crossers.add(farmer3);
                LowerBankCrossers.remove(farmer3);
                UpperBankCrossers.add(farmer3);
            }
        } else if (crosser.equals("farmer4")) {
            //if it doesnt exist add it
            if (!crossers.contains(farmer4)) {
                crossers.add(farmer4);
                LowerBankCrossers.remove(farmer4);
                UpperBankCrossers.add(farmer4);
            }
        } else if (crosser.equals("animal")) {
            //if it doesnt exist add it
            if (!crossers.contains(animal)) {
                crossers.add(animal);
                LowerBankCrossers.remove(animal);
                UpperBankCrossers.add(animal);
            }
        }
    }
        public void setCrossersMovingDown (String crosser){

            if (crosser.equals("farmer1")) {
                if (!crossers.contains(farmer1)) {
                    crossers.add(farmer1);
                    UpperBankCrossers.remove(farmer1);
                    LowerBankCrossers.add(farmer1);
                }
            } else if (crosser.equals("farmer2")) {
                if (!crossers.contains(farmer2)) {
                    crossers.add(farmer2);
                    LowerBankCrossers.add(farmer2);
                    UpperBankCrossers.remove(farmer2);
                }
            } else if (crosser.equals("farmer3")) {
                if (!crossers.contains(farmer3)) {
                    crossers.add(farmer3);
                    LowerBankCrossers.add(farmer3);
                    UpperBankCrossers.remove(farmer3);
                }
            } else if (crosser.equals("farmer4")) {
                //if it doesnt exist add it
                if (!crossers.contains(farmer4)) {
                    crossers.add(farmer4);
                    LowerBankCrossers.add(farmer4);
                    UpperBankCrossers.remove(farmer4);
                }
            } else if (crosser.equals("animal")) {
                //if it doesnt exist add it
                if (!crossers.contains(animal)) {
                    crossers.add(animal);
                    LowerBankCrossers.add(animal);
                    UpperBankCrossers.remove(animal);
                }
            }
        }
        //*******************************************************************************************************
    public void setLowerBankCrossers () {
        if (LowerBankCrossers.size() != 0)
            LowerBankCrossers.clear();
        LowerBankCrossers.add(farmer1);
        LowerBankCrossers.add(farmer2);
        LowerBankCrossers.add(farmer3);
        LowerBankCrossers.add(farmer4);
        LowerBankCrossers.add(animal);
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

    public void initializeCrossers(){
        System.out.println("uibwnef");
        if(!this.crossers.isEmpty())
            this.crossers.clear();
        if(!UpperBankCrossers.isEmpty())
            this.UpperBankCrossers.clear();
        if(!LowerBankCrossers.isEmpty())
            this.LowerBankCrossers.clear();
        this.LowerBankCrossers.add(farmer1);
        this.LowerBankCrossers.add(farmer2);
        this.LowerBankCrossers.add(farmer3);
        this.LowerBankCrossers.add(farmer4);
        this.LowerBankCrossers.add(animal);
    }

   

    @Override
    public int getNumberOfSails() {
        return level_2.getNumOfSails();
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        boolean isvalid = strategy2.isValid(UpperBankCrossers, LowerBankCrossers, crossers);
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

  

    public void saveGame(Sprite2 farmer12, Sprite2 farmer22, Sprite2 farmer32, Sprite2 farmer42,
                         Sprite2 goat, Sprite2 raft) {
        try {
            //	FileOutputStream filestream = new FileOutputStream(new File("./save_level1.xml"));
            XMLEncoder encoder = new XMLEncoder( new BufferedOutputStream( new FileOutputStream(new File (("./save_level1.xml")))));

            encoder.writeObject(farmer12);
            encoder.writeObject(farmer22);
            encoder.writeObject(farmer32);
            encoder.writeObject(farmer42);
            encoder.writeObject(goat);
            encoder.writeObject(raft);
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
            x9= (Sprite2) decoder.readObject();

            decoder.close();

            System.out.println("farmer1 location " + x1.getLocation());
            System.out.println("farmer2 location " + x2.getLocation());
            System.out.println("farmer3 location " + x3.getLocation());
            System.out.println("farmer4 location " + x4.getLocation());
            System.out.println("animal location " + x5.getLocation());

            //setting arrays of chars
            if(x1.getLocation() == 1)
                LowerBankCrossers.add(farmer1);
            else if(x1.getLocation() == 2) {
                crossers.add(farmer1);
                UpperBankCrossers.add(farmer1);
            }
            else if(x1.getLocation() == 3) {
                crossers.add(farmer1);
                LowerBankCrossers.add(farmer1);
            }
            else
                UpperBankCrossers.add(farmer1);
            //*************************************************************************************
            if(x2.getLocation() == 1)
                LowerBankCrossers.add(farmer2);
            else if(x1.getLocation() == 2) {
                crossers.add(farmer2);
                UpperBankCrossers.add(farmer2);
            }
            else if(x1.getLocation() == 3) {
                crossers.add(farmer2);
                LowerBankCrossers.add(farmer2);
            }
            else
                UpperBankCrossers.add(farmer2);


            if(x3.getLocation() == 1)
                LowerBankCrossers.add(farmer3);
            else if(x3.getLocation() == 2) {
                crossers.add(farmer3);
                UpperBankCrossers.add(farmer3);
            }
            else if(x3.getLocation() == 3) {
                crossers.add(farmer3);
                LowerBankCrossers.add(farmer3);
            }
            else
                UpperBankCrossers.add(farmer3);

            if(x4.getLocation() == 1)
                LowerBankCrossers.add(farmer4);
            else if(x4.getLocation() == 2) {
                crossers.add(farmer4);
                UpperBankCrossers.add(farmer4);
            }
            else if(x4.getLocation() == 3) {
                crossers.add(farmer4);
                LowerBankCrossers.add(farmer4);
            }
            else
                UpperBankCrossers.add(farmer4);

            if(x5.getLocation() == 1)
                LowerBankCrossers.add(animal);
            else if(x5.getLocation() == 2) {
                crossers.add(animal);
                UpperBankCrossers.add(animal);
            }
            else if(x5.getLocation() == 3) {
                crossers.add(animal);
                LowerBankCrossers.add(animal);
            }
            else
                UpperBankCrossers.add(animal);

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
    public void saveGame(Level3.Sprite2 boy, Level3.Sprite2 raft, Level3.Sprite2 girl, Level3.Sprite2 man, Level3.Sprite2 woman, Level3.Sprite2 bag) {

    }

    @Override
    public void saveGame2(Level3.Sprite2 boy, Level3.Sprite2 raft, Level3.Sprite2 girl, Level3.Sprite2 man, Level3.Sprite2 woman, Level3.Sprite2 bag) {

    }

   

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }

    public boolean checkLoad() {
        FileInputStream file;
        try {
            file = new FileInputStream (new File("./save_level2.xml"));
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

	@Override
	public boolean isBoatOnTheLeftBank() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGame(Sprite farmer, Sprite raft, Sprite goat,
			Sprite wolf, Sprite plant) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void saveGame(Level2Chars.Sprite farmer1, Level2Chars.Sprite farmer2, Level2Chars.Sprite farmer3, Level2Chars.Sprite farmer4, Level2Chars.Sprite animal1, Level2Chars.Sprite animal2, Level2Chars.Sprite animal3, Level2Chars.Sprite animal4, Level2Chars.Sprite raft) {

    }
	@Override
	public void loadGame2() {
		// TODO Auto-generated method stub
		
	}
}