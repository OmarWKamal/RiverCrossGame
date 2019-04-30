package Level3;

import Level1Chars.ICrosser;
import Level1Chars.ICrossingStrategy;

import java.util.List;

public class Strategy3 implements ICrossingStrategy {
    ICrosser man = Man.getInstance();
    ICrosser woman = Woman.getInstance();
    ICrosser boy = Boy.getInstance();
    ICrosser girl = Girl.getInstance();
    ICrosser bag = Bag.getInstance();
    private final int maxWeight = 100;

    public Strategy3() {
    }

    @Override
    public boolean isValid(List<ICrosser> upperBankCrossers, List<ICrosser> lowerBankCrossers, List<ICrosser> raftRiders) {
        boolean canrow = false;
        boolean crossersOnRaft = false;

        int totalWeight=0;


        //checking if a rower can row
        for(int i = 0; i < raftRiders.size(); i++)
        {
            if(raftRiders.get(i).canSail()){
                canrow = true;
                break;
            }
        }

        //total weight of raftRiders<100
        for(int i = 0; i < raftRiders.size(); i++)
        {
           totalWeight += raftRiders.get(i).getWeight();
           if (totalWeight>maxWeight)
               return false;
        }

        //number of crossers on raft is 1 or 2
        if(raftRiders.size() <= 2 && raftRiders.size() > 0) {
            crossersOnRaft = true;
        }

        //one rider must row
        if(!canrow) {
            return false;
        }
        else if(crossersOnRaft == false) {
            return false;
    }
        else
            return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> crossers = null;
        crossers.add(man);
        crossers.add(woman);
        crossers.add(boy);
        crossers.add(girl);
        crossers.add(bag);

        return crossers;
    }

    @Override
    public String[] getInstructions() {
        return new String[0];
    }
}
