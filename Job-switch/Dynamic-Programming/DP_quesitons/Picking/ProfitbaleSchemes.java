package Picking;

public class ProfitbaleSchemes {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        return helper(0, minProfit, n, group, profit);
    }

    public int helper(int idx, int minProfit, int membersLeft, int[] group, int[] profit){

        if(idx == group.length)
            return minProfit <= 0 ? 1 : 0;
        
        // dont do the i-th theft
        int skip = helper(idx+1, minProfit, membersLeft, group, profit);
        int take = 0;
        // do the i-th theft only if we have enough members left
        if(membersLeft >= group[idx]){
            take = helper(idx+1, minProfit - profit[idx], membersLeft - group[idx], group, profit);
        }
        return skip + take;
    }
}
