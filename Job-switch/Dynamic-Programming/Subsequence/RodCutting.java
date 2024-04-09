package Subsequence;

import java.util.Arrays;

public class RodCutting {

    // public static int minCost(int n, int[] cuts) {
    //     // n = 7
    //     // [1,3,4,5]
    //     return recursion(n, cuts);
    // }

    public static int cutRod(int price[], int n) {
        // Write your code here.
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return recursion(n, price, dp);
    }

    public static int recursion(int woodLen, int[] cuts, int dp[]) {
        if (woodLen == 0)
            return 0;
        if (woodLen < 0)
            return Integer.MIN_VALUE;

        if (dp[woodLen] != -1)
            return dp[woodLen];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cuts.length; i++) {
            int val = recursion(woodLen - (i + 1), cuts, dp) + cuts[i];
            max = Math.max(max, val);
        }
        return dp[woodLen] = max;
    }

    public static int tabulation(int price[], int n) {
        int dp[] = new int[n + 1];
        dp[1] = price[0];

        for (int woodLen = 2; woodLen < dp.length; woodLen++) {
            for (int i = 0; i < woodLen; i++) {
                int val = dp[woodLen - (i + 1)] + price[i];
                dp[woodLen] = Math.max(dp[woodLen], val);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 8, 9, 10, 17, 17, 20 };
        int n = 8;
        // int arr[] = {2,5,7,8,10};
        // int n = 5;

        // System.out.println(minCost(n, arr));
        System.out.println(tabulation(arr, n));

    }
}
