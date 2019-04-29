package Level2Chars;

import Level1Chars.ICrosser;
import Level1Chars.ICrossingStrategy;
import Level1Chars.IRiverCrossingController;
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
    LEVEL_2 level_2;
    Strategy2 strategy2;
    start_page start_page;
    public Sprite2 x1; //farmer/
    public Sprite2 x2; //raft
    public Sprite2 x3; //goat
    public Sprite2 x4; //wolf
    public Sprite2 x5; //plant
    public Sprite2 x6; //star
    public Controller2() {
    }


    private ICrosser boy = Boy.getInstance();
    private ICrosser girl = Girl.getInstance();
    private ICrosser woman = Woman.getInstance();
    private ICrosser man = Man.getInstance();
    private ICrosser bag = Bag.getInstance();

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


    public boolean check_load2 () {
        FileInputStream file;
        try {
            file = new FileInputStream (new File("./save_level2.xml"));
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

  /*  public void setCrossersInMemento(GameState gameState)
    {
        gameState.setUpperBankCrossers(UpperBankCrossers);
        gameState.setLowerBankCrossers(LowerBankCrossers);
        gameState.setCrossers(crossers);
    }*/


    public void checkBoyLocation(int location){
        int loc = 0;
        if(location == 1){
            if(UpperBankCrossers.contains(boy))
                UpperBankCrossers.remove(boy);
            if(crossers.contains(boy))
                crossers.remove(boy);
            if(LowerBankCrossers.contains(boy))
                return;
            else
                LowerBankCrossers.add(boy);
            loc = 1;
        }
        else if(location == 2){
            if(LowerBankCrossers.contains(boy))
                LowerBankCrossers.remove(boy);
            if(!UpperBankCrossers.contains(boy))
                UpperBankCrossers.add(boy);
            if(!crossers.contains(boy))
                crossers.add(boy);
            loc = 1;
        }
        else if(location  == 3){
            if(UpperBankCrossers.contains(boy))
                UpperBankCrossers.remove(boy);
            if(!LowerBankCrossers.contains(boy))
                LowerBankCrossers.add(boy);
            if(!crossers.contains(boy))
                crossers.add(boy);
            loc = 1;
        }else if(location  == 4){
            if(LowerBankCrossers.contains(boy))
                LowerBankCrossers.remove(boy);
            if(crossers.contains(boy))
                crossers.remove(boy);
            if(LowerBankCrossers.contains(boy))
                return;
            else
                LowerBankCrossers.add(boy);
            loc = 1;
        }
        System.out.println("************************** location" + loc);
    }
    public void checkGirlLocation(int location ){
        if(location  == 1){
            if(UpperBankCrossers.contains(girl))
                UpperBankCrossers.remove(girl);
            if(crossers.contains(girl))
                crossers.remove(girl);
            if(LowerBankCrossers.contains(girl))
                return;
            else
                LowerBankCrossers.add(girl);
        }
        else if(location  == 2){
            if(LowerBankCrossers.contains(girl))
                LowerBankCrossers.remove(girl);
            if(!UpperBankCrossers.contains(girl))
                UpperBankCrossers.add(girl);
            if(!crossers.contains(girl))
                crossers.add(girl);
        }
        else if(location  == 3){
            if(UpperBankCrossers.contains(girl))
                UpperBankCrossers.remove(girl);
            if(!LowerBankCrossers.contains(girl))
                LowerBankCrossers.add(girl);
            if(!crossers.contains(girl))
                crossers.add(girl);
        }else if(location  == 4){
            if(LowerBankCrossers.contains(girl))
                LowerBankCrossers.remove(girl);
            if(crossers.contains(girl))
                crossers.remove(girl);
            if(LowerBankCrossers.contains(girl))
                return;
            else
                LowerBankCrossers.add(girl);
        }
        System.out.println("************************** location" + location );
    }
    public void checkWomanLocation(int location ){
        if(location  == 1){
            if(UpperBankCrossers.contains(woman))
                UpperBankCrossers.remove(woman);
            if(crossers.contains(woman))
                crossers.remove(woman);
            if(LowerBankCrossers.contains(woman))
                return;
            else
                LowerBankCrossers.add(woman);
        }
        else if(location  == 2){
            if(LowerBankCrossers.contains(woman))
                LowerBankCrossers.remove(woman);
            if(!UpperBankCrossers.contains(woman))
                UpperBankCrossers.add(woman);
            if(!crossers.contains(woman))
                crossers.add(woman);
        }
        else if(location  == 3){
            if(UpperBankCrossers.contains(woman))
                UpperBankCrossers.remove(woman);
            if(!LowerBankCrossers.contains(woman))
                LowerBankCrossers.add(woman);
            if(!crossers.contains(woman))
                crossers.add(woman);
        }else if(location  == 4){
            if(LowerBankCrossers.contains(woman))
                LowerBankCrossers.remove(woman);
            if(crossers.contains(woman))
                crossers.remove(woman);
            if(LowerBankCrossers.contains(woman))
                return;
            else
                LowerBankCrossers.add(woman);
        }
        System.out.println("************************** location" + location );

    }
    public void checkManLocation(int location ){
        if(location  == 1){
            if(UpperBankCrossers.contains(man))
                UpperBankCrossers.remove(man);
            if(crossers.contains(man))
                crossers.remove(man);
            if(LowerBankCrossers.contains(man))
                return;
            else
                LowerBankCrossers.add(man);
        }
        else if(location == 2){
            if(LowerBankCrossers.contains(man))
                LowerBankCrossers.remove(man);
            if(!UpperBankCrossers.contains(man))
                UpperBankCrossers.add(man);
            if(!crossers.contains(man))
                crossers.add(man);
        }
        else if(location == 3){
            if(UpperBankCrossers.contains(man))
                UpperBankCrossers.remove(man);
            if(!LowerBankCrossers.contains(man))
                LowerBankCrossers.add(man);
            if(!crossers.contains(man))
                crossers.add(man);
        }else if(location == 4){
            if(LowerBankCrossers.contains(man))
                LowerBankCrossers.remove(man);
            if(crossers.contains(man))
                crossers.remove(man);
            if(LowerBankCrossers.contains(man))
                return;
            else
                LowerBankCrossers.add(man);
        }
        System.out.println("************************** location" + location );

    }

    public void checkBagLocation(int location ){
        if(location  == 1){
            if(UpperBankCrossers.contains(bag))
                UpperBankCrossers.remove(bag);
            if(crossers.contains(bag))
                crossers.remove(bag);
            if(LowerBankCrossers.contains(bag))
                return;
            else
                LowerBankCrossers.add(bag);
        }
        else if(location == 2){
            if(LowerBankCrossers.contains(bag))
                LowerBankCrossers.remove(bag);
            if(!UpperBankCrossers.contains(bag))
                UpperBankCrossers.add(bag);
            if(!crossers.contains(bag))
                crossers.add(bag);
        }
        else if(location == 3){
            if(UpperBankCrossers.contains(bag))
                UpperBankCrossers.remove(bag);
            if(!LowerBankCrossers.contains(bag))
                LowerBankCrossers.add(bag);
            if(!crossers.contains(bag))
                crossers.add(bag);
        }else if(location == 4){
            if(LowerBankCrossers.contains(bag))
                LowerBankCrossers.remove(bag);
            if(crossers.contains(bag))
                crossers.remove(bag);
            if(LowerBankCrossers.contains(bag))
                return;
            else
                LowerBankCrossers.add(bag);
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
    }



    public Controller2(LEVEL_2 level_2, Strategy2 strategy2, start_page start_page) {
        this.level_2 = level_2;
        this.strategy2 = strategy2;
        this.start_page = start_page;
    }
    public void Level2BuildScene(){
        level_2.scene_build();
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

        if (crosser.equals("boy")) {
            if(!crossers.contains(boy)){
                crossers.add(boy);
                UpperBankCrossers.add(boy);
                LowerBankCrossers.remove(boy);
            }
        } else if (crosser.equals("girl")) {
            if(!crossers.contains(girl)) {
                crossers.add(girl);
                LowerBankCrossers.remove(girl);
                UpperBankCrossers.add(girl);
            }
        } else if (crosser.equals("woman")){
            if(!crossers.contains(woman)) {
                crossers.add(woman);
                LowerBankCrossers.remove(woman);
                UpperBankCrossers.add(woman);
            }
        } else if (crosser.equals("man")) {
            //if it doesnt exist add it
            if(!crossers.contains(man)) {
                crossers.add(man);
                LowerBankCrossers.remove(man);
                UpperBankCrossers.add(man);
            }
        } else if (crosser.equals("bag")) {
            //if it doesnt exist add it
            if(!crossers.contains(bag)) {
                crossers.add(bag);
                LowerBankCrossers.remove(bag);
                UpperBankCrossers.add(bag);
            }
        }
    }
    public void setCrossersMovingDown(String crosser){

        if (crosser.equals("boy")) {
            if(!crossers.contains(boy)){
                crossers.add(boy);
                UpperBankCrossers.remove(boy);
                LowerBankCrossers.add(boy);
            }
        } else if (crosser.equals("girl")) {
            if(!crossers.contains(girl)) {
                crossers.add(girl);
                LowerBankCrossers.add(girl);
                UpperBankCrossers.remove(girl);
            }
        } else if (crosser.equals("woman")){
            if(!crossers.contains(woman)) {
                crossers.add(woman);
                LowerBankCrossers.add(woman);
                UpperBankCrossers.remove(woman);
            }
        } else if (crosser.equals("man")) {
            //if it doesnt exist add it
            if(!crossers.contains(man)) {
                crossers.add(man);
                LowerBankCrossers.add(man);
                UpperBankCrossers.remove(man);
            }
        } else if (crosser.equals("bag")) {
            //if it doesnt exist add it
            if(!crossers.contains(bag)) {
                crossers.add(bag);
                LowerBankCrossers.add(bag);
                UpperBankCrossers.remove(bag);
            }
        }
    }
    //*******************************************************************************************************
    public void setLowerBankCrossers() {
        if(LowerBankCrossers.size() != 0)
            LowerBankCrossers.clear();
        LowerBankCrossers.add(boy);
        LowerBankCrossers.add(girl);
        LowerBankCrossers.add(woman);
        LowerBankCrossers.add(man);
        LowerBankCrossers.add(bag);
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
        return true;
    }

    @Override
    public int getNumberOfSails() {
        return level_2.getNumOfSails();
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        boolean isvalid = strategy2.isValid(UpperBankCrossers, LowerBankCrossers, this.crossers);
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
    public void saveGame(Level1Chars.Sprite2 farmer, Level1Chars.Sprite2 raft, Level1Chars.Sprite2 goat, Level1Chars.Sprite2 wolf, Level1Chars.Sprite2 plant) {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public void saveGame(Sprite2 boy, Sprite2 raft, Sprite2 girl, Sprite2 man, Sprite2 woman, Sprite2 bag) {

    }

    @Override
    public void saveGame2(Sprite2 boy, Sprite2 raft, Sprite2 girl, Sprite2 man, Sprite2 woman, Sprite2 bag) {
        try {
            //	FileOutputStream filestream = new FileOutputStream(new File("./save_level2.xml"));
            XMLEncoder encoder = new XMLEncoder( new BufferedOutputStream( new FileOutputStream(new File (("./save_level2.xml")))));

            encoder.writeObject(boy);
            encoder.writeObject(raft);
            encoder.writeObject(girl);
            encoder.writeObject(man);
            encoder.writeObject(woman);
            encoder.writeObject(bag);
            System.out.println("save is done");
            encoder.close();
            //filestream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("hi");
        }

    }

    @Override
    public  void   loadGame2() {
        FileInputStream file;
        LowerBankCrossers.clear();
        UpperBankCrossers.clear();
        crossers.clear();
        try {
            System.out.println("**********************************");
            file = new FileInputStream (new File("./save_level2.xml"));
            XMLDecoder decoder = new XMLDecoder(file);


            x1 = (Sprite2) decoder.readObject();
            x2= (Sprite2) decoder.readObject();
            x3= (Sprite2) decoder.readObject();
            x4 = (Sprite2) decoder.readObject();
            x5= (Sprite2) decoder.readObject();
            x6= (Sprite2) decoder.readObject();
            decoder.close();



            //setting arrays of chars
            if(x1.getLocation() == 1)
                LowerBankCrossers.add(boy);
            else if(x1.getLocation() == 2) {
                crossers.add(boy);
                UpperBankCrossers.add(boy);
            }
            else if(x1.getLocation() == 3) {
                crossers.add(boy);
                LowerBankCrossers.add(boy);
            }
            else
                UpperBankCrossers.add(boy);

            if(x3.getLocation() == 1)
                LowerBankCrossers.add(girl);
            else if(x3.getLocation() == 2) {
                crossers.add(girl);
                UpperBankCrossers.add(girl);
            }
            else if(x3.getLocation() == 3) {
                crossers.add(girl);
                LowerBankCrossers.add(girl);
            }
            else
                UpperBankCrossers.add(girl);

            if(x4.getLocation() == 1)
                LowerBankCrossers.add(man);
            else if(x4.getLocation() == 2) {
                crossers.add(man);
                UpperBankCrossers.add(man);
            }
            else if(x4.getLocation() == 3) {
                crossers.add(man);
                LowerBankCrossers.add(man);
            }
            else
                UpperBankCrossers.add(man);

            if(x5.getLocation() == 1)
                LowerBankCrossers.add(woman);
            else if(x5.getLocation() == 2) {
                crossers.add(woman);
                UpperBankCrossers.add(woman);
            }
            else if(x5.getLocation() == 3) {
                crossers.add(woman);
                LowerBankCrossers.add(woman);
            }
            else
                UpperBankCrossers.add(woman);


            if(x6.getLocation() == 1)
                LowerBankCrossers.add(bag);
            else if(x6.getLocation() == 2) {
                crossers.add(bag);
                UpperBankCrossers.add(bag);
            }
            else if(x6.getLocation() == 3) {
                crossers.add(bag);
                LowerBankCrossers.add(bag);
            }
            else
                UpperBankCrossers.add(bag);


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


}