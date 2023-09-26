package DP.Day8;

import java.util.Arrays;

public class CoinChangePermuation {
    
    
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+5];
        Arrays.fill(dp, -1);
        return recPermutation(target, nums, dp);
    }

    public int recPermutation(int amount, int[] coins, int[] dp){
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(dp[amount] != -1) return dp[amount];
        int ans = 0;
        for(int coin : coins){
            if(coin > amount) continue;
            ans += recPermutation(amount - coin, coins, dp);
        }
        return dp[amount] = ans;
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
}  
