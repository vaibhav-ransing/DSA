package Partition_DP;

import java.util.Arrays;

public class PartitionArrFroMaxSum {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] dp = new int[arr.length][arr.length];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return recursion(0, 0, k, Integer.MIN_VALUE, arr, dp);
    }

    public static int recursion(int preIdx, int currIdx, int k, int max, int[] arr, int[][] dp) {

        // 1,15,7,9,2,5,10
        if (currIdx == arr.length)
            return 0;
        if(dp[preIdx][currIdx] != -1)
            return dp[preIdx][currIdx];
        int dontSplit = 0;
        int currMax = Math.max(max, arr[currIdx]);

        if ((currIdx - preIdx + 1) < k) {
            dontSplit = recursion(preIdx, currIdx + 1, k, currMax, arr, dp);
        }
        int split = (currIdx - preIdx + 1) * currMax + recursion(currIdx + 1, currIdx + 1, k, Integer.MIN_VALUE, arr, dp);

        return dp[preIdx][currIdx] = Math.max(dontSplit, split);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }
}
