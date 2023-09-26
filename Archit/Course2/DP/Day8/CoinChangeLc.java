package DP.Day8;

import java.util.Arrays;

public class CoinChangeLc {

    public int coinChangeTabulation(int[] coins, int amount) {
        int[] dp = new int[amount];
        Arrays.fill(dp, (int) 1e7);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for(int coin : coins){
                int idx = i - coin;
                if(idx>=0){
                    dp[i] = Math.min(dp[i], dp[idx]+1);
                }
            }
        }
        return dp[coins.length - 1] >= (int) 1e7 ? -1 : dp[coins.length - 1];
    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 5];
        Arrays.fill(dp, -1);
        int val = recursion(coins, amount, dp);
        return val == (int) 1e7 ? -1 : val;
    }

    public int recursion(int[] coins, int amount, int[] dp) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return (int) 1e7;

        if (dp[amount] != -1)
            return dp[amount];

        int ans = (int) 1e7;
        for (int coin : coins) {
            int temp = recursion(coins, amount - coin, dp);
            ans = Math.min(ans, temp + 1);
        }
        return dp[amount] = ans;
    }

    public int coinChange2(int[] coins, int amount) {
        int dp[][] = new int[amount + 5][coins.length + 5];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int val = myRecursion(coins, amount, 0, dp);
        return val == (int) 1e7 ? -1 : val;
    }

    public int myRecursion(int[] coins, int amount, int idx, int[][] dp) {

        if (idx >= coins.length || amount < 0)
            return (int) 1e7;
        if (amount == 0)
            return 0;
        if (dp[amount][idx] != -1)
            return dp[amount][idx];

        int yes = myRecursion(coins, amount - coins[idx], idx, dp) + 1;
        int no = myRecursion(coins, amount, idx + 1, dp);

        return dp[amount][idx] = Math.min(yes, no);
    }

}
