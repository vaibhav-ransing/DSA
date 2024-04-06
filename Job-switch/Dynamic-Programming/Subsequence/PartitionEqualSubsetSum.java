package Subsequence;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] arr, int n) {

        int sum = Arrays.stream(arr).sum();
        if(sum%2 == 1)  // very important
            return false;
        sum /= 2;
        return tabulation(sum, arr);
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
        return dp[m - 1][n - 1];
    }

    public static int tabulation1(int target, int[] arr) {
        int dp[][] = new int[arr.length + 1][target + 1];
        int m = dp.length;
        int n = dp[0].length;

        dp[0][0] = 1;

        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int arrVal = arr[row - 1];
                int dontTake = dp[row - 1][col];
                int take = 0;
                if (col - arrVal >= 0) {
                    take = dp[row - 1][col - arrVal];
                }
                dp[row][col] = take + dontTake;
            }
        }
        return dp[m - 1][n - 1];
    }

    

    // public static boolean recursion(int[] arr, int idx, int v1, int v2) {

    //     if (idx < 0){
    //         if(v1 == v2)
    //             System.out.println(v1);
    //         return v1 == v2;
    //     }

    //     boolean t1 = recursion(arr, idx - 1, v1 + arr[idx], v2);
    //     boolean t2 = recursion(arr, idx - 1, v1, v2 + arr[idx]);

    //     return t1 || t2;

    // }

    public static void main(String[] args) {
        int arr[] = {3,1,1,2,2,1};
        int n = arr.length;
        canPartition(arr, n);
    }
}
