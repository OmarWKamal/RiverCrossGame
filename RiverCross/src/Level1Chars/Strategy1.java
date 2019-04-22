package Level1Chars;

import java.util.List;

public class Strategy1 implements ICrossingStrategy{
    boolean canrow = false;
    Farmer farmer = Farmer.getInstance();

    public Strategy1() {
    }

    @Override
    public boolean isValid(List<ICrosser> upperBankCrossers, List<ICrosser> lowerBankCrossers, List<ICrosser> raftRiders) {
        int lowereatingrank = 0;
        int uppereatingrank = 0;
        //checking if a rower can row

        //calculating eatingrank of lowerbank
        for(int i = 0; i < lowerBankCrossers.size(); i++)
        {
            lowereatingrank += lowerBankCrossers.get(i).getEatingRank();
        }
        //calculating eatingrank of upperbank
        for(int i = 0; i < upperBankCrossers.size(); i++)
        {
            uppereatingrank += upperBankCrossers.get(i).getEatingRank();
        }

        //one rider must row
        if(!canrow)
            return false;
        //invalid cases of eating ranks
        else if(lowereatingrank == 0 || lowereatingrank == -2)
            return false;
        else if(uppereatingrank == 0 || uppereatingrank == -2)
            return false;
        else
            return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        return null;
    }

    @Override
    public String[] getInstructions() {
        return new String[0];
    }
}
