import java.util.*;

public class Solution {
    public static int minSubsetSumDifference(int[] arr, int n) {
        n = arr.length;
        int sum = Arrays.stream(arr).sum();
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (boolean[] row : dp) {
            Arrays.fill(row, false);
        }

        dp[0][0] = true;

        return memoizationHelper(arr, n, sum, dp);
    }

    public static int memoizationHelper(int[] arr, int n, int sum, boolean[][] dp) {
        if (n == 0)
            return sum;

        if (dp[n][sum])
            return sum;

        dp[n][sum] = true;

        int take = memoizationHelper(arr, n - 1, sum - arr[n - 1], dp);
        int skip = memoizationHelper(arr, n - 1, sum, dp);

        return Math.min(take, skip);
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 5};
        int n = arr.length;
        System.out.println("Minimum subset sum difference: " + minSubsetSumDifference(arr, n));
    }
}
