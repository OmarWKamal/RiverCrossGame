package Level1Chars.GameStates;

import Level1Chars.ICrosser;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    SpriteGameState farmerState;
    SpriteGameState raftState;
    SpriteGameState goatState;
    SpriteGameState wolfState;
    SpriteGameState plantState;
    ArrayList<ICrosser> crossers = new ArrayList<>();
    ArrayList<ICrosser> LowerBankCrossers = new ArrayList<>();
    ArrayList<ICrosser> UpperBankCrossers = new ArrayList<>();

    public SpriteGameState getFarmerState() {
        return farmerState;
    }

    public void setFarmerState(SpriteGameState farmerState) {
        this.farmerState = farmerState;
    }

    public SpriteGameState getRaftState() {
        return raftState;
    }

    public void setRaftState(SpriteGameState raftState) {
        this.raftState = raftState;
    }

    public SpriteGameState getGoatState() {
        return goatState;
    }

    public void setGoatState(SpriteGameState goatState) {
        this.goatState = goatState;
    }

    public SpriteGameState getWolfState() {
        return wolfState;
    }

    public void setWolfState(SpriteGameState wolfState) {
        this.wolfState = wolfState;
    }

    public SpriteGameState getPlantState() {
        return plantState;
    }

    public void setPlantState(SpriteGameState plantState) {
        this.plantState = plantState;
    }


    public ArrayList<ICrosser> getCrossers() {
        return crossers;
    }

    public void setCrossers(ArrayList<ICrosser> crossers) {
        this.crossers = crossers;
    }

    public ArrayList<ICrosser> getLowerBankCrossers() {
        return LowerBankCrossers;
    }

    public void setLowerBankCrossers(ArrayList<ICrosser> lowerBankCrossers) {
        LowerBankCrossers = lowerBankCrossers;
    }

    public ArrayList<ICrosser> getUpperBankCrossers() {
        return UpperBankCrossers;
    }

    public void setUpperBankCrossers(ArrayList<ICrosser> upperBankCrossers) {
        UpperBankCrossers = upperBankCrossers;
    }


    public GameState() {

    }
}
