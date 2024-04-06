package Subsequence;

import java.util.Arrays;

public class TargetSum {

    public static int findTargetSumWays(int[] arr, int diff) {
        int totalArrSum = Arrays.stream(arr).sum();
        int dp[][] = new int[arr.length][totalArrSum + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        int ans = recursion(arr.length - 1, 0, totalArrSum, arr, diff, dp);
        return ans;
    }

    public static int recursion(int idx, int v1, int totalArrSum, int[] arr, int diff, int[][] dp) {

        if (idx < 0) {
            int v2 = totalArrSum - v1;
            return v1 - v2 == diff ? 1 : 0;
        }
        if (dp[idx][v1] != -1)
            return dp[idx][v1];

        int take = recursion(idx - 1, v1 + arr[idx], totalArrSum, arr, diff, dp);
        int skip = recursion(idx - 1, v1, totalArrSum, arr, diff, dp);

        return dp[idx][v1] = take + skip;
    }

    public static void targetSum(int target, int arr[]) {
        int dp[][] = new int[arr.length][target + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        targetSumSubsetRecusion(arr.length - 1, target, arr, dp);
    }

    public static int targetSumSubsetRecusion(int idx, int target, int[] arr, int dp[][]) {

        if (target == 0 || idx < 0) {
            return target == 0 ? 1 : 0;
        }
        if (target < 0)
            return 0;
        if (dp[idx][target] != -1)
            return dp[idx][target];
        int take = targetSumSubsetRecusion(idx - 1, target - arr[idx], arr, dp);
        int skip = targetSumSubsetRecusion(idx - 1, target, arr, dp);

        return dp[idx][target] = take + skip;
    }

    public static int targetSumTabulation(int arr[], int target) {
        int dp[][] = new int[arr.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int skip = dp[i - 1][j];
                int take = 0;
                if (j - arr[i - 1] >= 0) {
                    take = dp[i - 1][j - arr[i - 1]];
                }
                dp[i][j] = skip + take;
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static int targetSum(int n, int diff, int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        int target = (diff + totalSum) / 2;
        return targetSumTabulation(arr, target);
    }

    // 1 2 3 1
    // 3

    // -1 + 1 + 1 + 1 + 1 = 3
    // +1 - 1 + 1 + 1 + 1 = 3
    // +1 + 1 - 1 + 1 + 1 = 3
    // +1 + 1 + 1 - 1 + 1 = 3
    // +1 + 1 + 1 + 1 - 1 = 3

    /* Working code */

    public static int countPartitions2(int n, int diff, int[] arr) {
        int ts = Arrays.stream(arr).sum();
        if (ts - diff < 0 || (ts - diff) % 2 == 1)
            return 0;
        int s2 = (ts - diff) / 2;
        return findWays(arr, s2);
    }

    public static int util(int[] arr, int i, int sum, int[][] dp) {
        if (i < 0) {
            return (sum == 0) ? 1 : 0;
        }
        if (sum < 0) {
            return 0;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int choose = util(arr, i - 1, sum - arr[i], dp);
        int skip = util(arr, i - 1, sum, dp);
        return dp[i][sum] = (choose + skip);
    }

    public static int findWays(int[] arr, int k) {
        int[][] dp = new int[arr.length][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = util(arr, arr.length - 1, k, dp);
        return ans;
    }

    public static void main(String[] args) {

    }
}
