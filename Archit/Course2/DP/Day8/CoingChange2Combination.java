package DP.Day8;

import java.util.Arrays;

public class CoingChange2Combination {

    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+5][amount+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        return memo(amount, coins, 0, dp);
    }

    public int memo(int amount, int[] coins, int idx, int[][] dp) {
        if (amount == 0)
            return 1;
        if (amount < 0 || idx == coins.length)
            return 0;
        if(dp[idx][amount] != -1) return dp[idx][amount];

        int dontTake = memo(amount, coins, idx + 1, dp);
        int take = amount >= coins[idx] ? memo(amount - coins[idx], coins, idx, dp) : 0;

        return dp[idx][amount] = dontTake + take;
    }

    public int recCombination(int amount, int idx, int[] coins){
        if(amount == 0) return 1;
        if(amount < 0 || idx == coins.length) return 0;

        int ans = 0;
        for(int i=idx; i<coins.length; i++){
            ans += recCombination(amount-coins[idx], i, coins);
        }
        return ans;
    }

    public int rec(int amount, int[] coins, int idx) {
        if (amount == 0)
            return 1;
        if (amount < 0 || idx == coins.length)
            return 0;

        int dontTake = rec(amount, coins, idx + 1);
        int take = amount >= coins[idx] ? rec(amount - coins[idx], coins, idx) : 0;

        return dontTake + take;
    }

}
