package Level1Chars;

import java.util.List;

public class Strategy implements ICrossingStrategy {
    ICrosser farmer = Farmer.getInstance();
    ICrosser goat = Sheep.getInstance();
    ICrosser wolf = Wolf.getInstance();
    ICrosser plant = Plant.getInstance();

    public Strategy() {
    }

    @Override
    public boolean isValid(List<ICrosser> upperBankCrossers, List<ICrosser> lowerBankCrossers, List<ICrosser> raftRiders) {
        boolean canrow = false;
        boolean crossersOnRaft = false;
        int lowereatingrank = 0;
        int uppereatingrank = 0;
        //checking if a rower can row
        for(int i = 0; i < raftRiders.size(); i++)
        {
            if(raftRiders.get(i).canSail()){
                canrow = true;
                break;
            }
        }

        //number of crossers on raft is 1 or 2
        if(raftRiders.size() <= 2 && raftRiders.size() > 0) {
            crossersOnRaft = true;
        }

        //calculating eatingrank of lowerbank
        for(int i = 0; i < lowerBankCrossers.size(); i++)
        {
            lowereatingrank += lowerBankCrossers.get(i).getEatingRank();
          //  System.out.println("lowereating rank is " + lowereatingrank);
        }
        //calculating eatingrank of upperbank
        for(int i = 0; i < upperBankCrossers.size(); i++)
        {
            uppereatingrank += upperBankCrossers.get(i).getEatingRank();
            //System.out.println("uppereating rank is " + uppereatingrank);
        }

        //one rider must row
        if(!canrow) {
            System.out.println("error in canrow");
            return false;
        }
        //invalid cases of eating ranks
        else if((lowereatingrank == 0 && lowerBankCrossers.size() > 1) || (lowereatingrank == -2 && lowerBankCrossers.size() > 1)){
          //  System.out.println("error in lower eating rank    " + lowerBankCrossers.size() + " size ");
            return false;
        }
        else if((uppereatingrank == 0 && upperBankCrossers.size() > 1) || (uppereatingrank == -2 && upperBankCrossers.size() > 1)){
        //    System.out.println("error in upper eating rank ");
            return false;
        }
        else if(crossersOnRaft == false) {
           // System.out.println("error in number of rowers");
            return false;
        }
        else
            return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> crossers = null;
        crossers.add(farmer);
        crossers.add(goat);
        crossers.add(wolf);
        crossers.add(plant);
        return crossers;
    }

    @Override
    public String[] getInstructions() {
        return new String[0];
    }
}