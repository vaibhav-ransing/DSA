package Subsequence;

import java.util.Arrays;

public class SubsetSumEqualToK {

    public static boolean subsetSumToK(int n, int target, int arr[]) {
        // Write your code here.
        int dp[][] = new int[n][target + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return recursion(n - 1, target, arr, dp);
    }

    public static boolean recursion(int idx, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;
        if (idx == 0)
            return arr[0] == target;

        if (target < 0 || idx < 0)
            return false;

        if (dp[idx][target] != -1)
            return dp[idx][target] == 1;

        boolean take = recursion(idx - 1, (target - arr[idx]), arr, dp);
        boolean dont = recursion(idx - 1, target, arr, dp);
        dp[idx][target] = (take || dont) ? 1 : 0;
        return dp[idx][target] == 1;
    }

    public static boolean tabulation(int target, int[] arr) {
        boolean dp[][] = new boolean[arr.length + 1][target + 1];
        int m = dp.length;
        int n = dp[0].length;

        dp[0][0] = true;

        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int arrVal = arr[row - 1];
                boolean dontTake = dp[row - 1][col];
                boolean take = false;
                if (col - arrVal >= 0) {
                    take = dp[row - 1][col - arrVal];
                }
                dp[row][col] = take || dontTake;

            }
        }

        for (boolean d[] : dp) {
            System.out.println(Arrays.toString(d));
        }

        // 0 1 2 3 4 5 6 7 8
        // ___________________
        // 0 -1|- - - - - - - - -|
        // 4 0|- - - - - - - - -|
        // 3 1|- - - - - - - - -|
        // 2 2|- - - - - - - - -|
        // 1 3|- - - - - - - - -|

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5 };
        int arr[] = { 4, 3, 2, 1 };
        int k = 5;
        // tabulation(k, arr);
        subsetSumToK(arr.length, k, arr);
    }

}
