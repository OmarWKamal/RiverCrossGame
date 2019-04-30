package Level2Chars;

import Level1Chars.Farmer;
import Level1Chars.ICrosser;
import Level1Chars.ICrossingStrategy;
import Level2Chars.ICrosserCharacters.*;

import java.util.List;

public class Strategy2 implements ICrossingStrategy {
    ICrosser farmer1 = Farmer1.getInstance();
    ICrosser farmer2 = Farmer2.getInstance();
    ICrosser farmer3 = Farmer3.getInstance();
    ICrosser farmer4 = Farmer4.getInstance();
    ICrosser animal = Animal1.getInstance();


    public Strategy2() {
    }

    @Override
    public boolean isValid(List<ICrosser> upperBankCrossers, List<ICrosser> lowerBankCrossers, List<ICrosser> raftRiders) {
        //Validation here for canrow, weight only and only 2 crossers
        boolean canrow = false;
        boolean crossersOnRaft = false;
        boolean totalweight = false;
        int totalWeight = 0;
        //checking if a rower can row
        for(int i = 0; i < raftRiders.size(); i++)
        {
            if(raftRiders.get(i).canSail()){
                canrow = true;
                break;
            }
        }

        //getting the weight of chars on raft
        for(int i = 0; i < raftRiders.size(); i++)
        {
            totalWeight += raftRiders.get(i).getWeight();
            System.out.println(totalWeight + "total weight is");
        }
        if(totalWeight <= 100){
            totalweight = true;
        }
        //number of crossers on raft is 1 or 2
        if(raftRiders.size() <= 2 && raftRiders.size() > 0) {
            crossersOnRaft = true;
        }
        //one rider must row
        if(!canrow) { // if canrow is false return false
            System.out.println("error in canrow");
            return false;
        } else if(!totalweight){ //if total weight is > 100kg return false
            System.out.println("error in weight of rowers on raft");
            return false;
        }
        else if(crossersOnRaft == false) {
            System.out.println("error in number of rowers");
            return false;
        }
        else
            return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> crossers = null;
        crossers.add(farmer1);
        crossers.add(farmer2);
        crossers.add(farmer3);
        crossers.add(farmer4);
        crossers.add(animal);
        return crossers;
    }

    @Override
    public String[] getInstructions() {
        return new String[0];
    }
}