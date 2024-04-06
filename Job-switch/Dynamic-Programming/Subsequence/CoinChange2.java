package Subsequence;

import java.util.Arrays;

public class CoinChange2 {

    public static long countWaysToMakeChange(int coins[], int value) {
        // write your code here
        long[][] dp = new long[coins.length][value + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        long ans = recursion(coins.length - 1, coins, value, dp);
        Arrays.stream(dp).forEach(row -> System.out.println(Arrays.toString(row)));
        System.out.println(ans);
        return ans;
    }

    static long recursion(int idx, int coins[], int value, long[][] dp) {

        if (idx < 0 || value <= 0)
            return value == 0 ? 1 : 0;
        if (dp[idx][value] != -1)
            return dp[idx][value];
        long take = recursion(idx, coins, value - coins[idx], dp);
        long skip = recursion(idx - 1, coins, value, dp);

        return dp[idx][value] = take + skip;
    }

    static long tabulation(int[] coins, int value) {
        int n = coins.length;
        long[][] dp = new long[n + 1][value + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    long skip = dp[i - 1][j];
                    long take = 0;
                    if (j - coins[i - 1] >= 0) {
                        take = dp[i][j - coins[i - 1]];
                    }
                    dp[i][j] = skip + take;
                }
            }
        }
        // Arrays.stream(dp).forEach(row -> System.out.println(Arrays.toString(row)));
        return dp[n][value];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int value = 3;
        // int arr[] = {5,3,2};
        // int value = 3;
        tabulation(arr, value);
        System.out.println("**************************\n");
        countWaysToMakeChange(arr, value);
    }

}
