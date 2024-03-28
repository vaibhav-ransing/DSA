package Subsequence;

import java.util.Arrays;

public class PartitionSubsetMinAbsoluteDiff {

    public static int minSubsetSumDifference(int[] arr, int n) {
        // Write your code here.
        n = arr.length;
        int sum = Arrays.stream(arr).sum();
        boolean dp[][] = new boolean[n + 1][sum + 1];

        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else {
                    boolean skip = dp[i - 1][j];
                    boolean take = false;
                    if (j - arr[i - 1] >= 0)
                        take = dp[i - 1][j - arr[i - 1]];
                    dp[i][j] = skip || take;
                }
            }
        }
        int min = sum;
        for (int i = 0; i < dp[0].length / 2; i++) {
            if (dp[dp.length - 1][i]) {
                int rem = sum - i;
                min = Math.min(min, Math.abs(rem - i));
            }
        }
        // [8,6,5] = 19
        // true false false false false true true false true false false true false true
        // true false false false false true
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
        System.out.println(min);
        return min;
    }

    public static int minSUbSetDiffRecu(int[] arr) {
        int ts = Arrays.stream(arr).sum();
        int idx = arr.length - 1;
        return recursive(idx, 0, ts, arr);
    }
    static int min = Integer.MAX_VALUE;
    public static int recursive(int idx, int currSum, int ts, int[] arr) {
        if (idx < 0) {
            return currSum;
        }
        int take = recursive(idx - 1, currSum + arr[idx], ts, arr); // 19
        int dont = recursive(idx - 1, currSum, ts, arr); // 14

        int takeRem = Math.abs(ts - take); // 0
        int dontRem = Math.abs(ts - dont); // 5

        int v1 = Math.abs(take - takeRem); // 19
        int v2 = Math.abs(dont - dontRem); // 9
        // 5, 6, 8 
        System.out.println(take + " " + takeRem + " " + v1);
        System.out.println(dont + " " + dontRem + " " + v2);
        System.out.println("----");
        min = Math.min(min, Math.min(v1, v2));
        return Math.min(v1, v2);

    }

    public static int tabulation(int[] arr) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        boolean dp[][] = new boolean[n + 1][sum + 1];

        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else {
                    boolean skip = dp[i - 1][j];
                    boolean take = false;
                    if (j - arr[i - 1] >= 0)
                        take = dp[i - 1][j - arr[i - 1]];
                    dp[i][j] = skip || take;
                }
            }
        }
        int min = sum;
        for (int i = 0; i < dp[0].length / 2; i++) {
            if (dp[dp.length - 1][i]) {
                int rem = sum - i;
                min = Math.min(min, Math.abs(rem - i));
            }
        }
        // [8,6,5]

        // true false false false false true true false true false false true false true
        // true false false false false true
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
        // true false true false false false false true false true
        // 0 1 2 3 4 5 6 7 8 9

        return min;
        // take = idx - 1,
    }

    // sum = 19 = 10
    // 3 1 5 2 8
    public static int recursion2(int idx, int sum, int[] arr) {
        if (idx < 0) {
            return Math.abs(sum);
        }

        int take = recursion2(idx - 1, sum - arr[idx], arr);
        int dont = recursion2(idx - 1, sum, arr);

        return Math.min(take, dont);
    }

    public static int minSubsetSumDifference2(int[] arr, int n) {
        // int sum = Arrays.stream(arr).sum();
        int sum = Arrays.stream(arr)
                .map(Math::abs) // Convert negative values to positive
                .sum(); // Sum up the elements

        int[][][] dp = new int[arr.length][sum + 1][sum + 1];

        for (int[][] odp : dp) {
            for (int[] d : odp) {
                Arrays.fill(d, -1);
            }
        }
        return recursion(arr, n - 1, 0, 0, dp);
    }

    public static int recursion(int[] arr, int idx, int v1, int v2, int[][][] dp) {

        if (idx < 0) {
            return Math.abs((v1 - v2));
        }

        if (dp[idx][v1][v2] != -1)
            return dp[idx][v1][v2];

        int t1 = recursion(arr, idx - 1, Math.abs(v1 + arr[idx]), v2, dp);
        int t2 = recursion(arr, idx - 1, v1, Math.abs(v2 + arr[idx]), dp);

        int diff = Math.min(t1, t2);
        return dp[idx][v1][v2] = diff;
    }

    public static void main(String[] args) {
        // int[] arr = { 36, -36 };
        // int n = arr.length;
        // System.out.println(minSubsetSumDifference(arr, n));

        // int arr[] = { 3, 1, 5, 2, 8 };
        // System.out.println(minSubsetSumDifference(arr, arr.length));

        int arr[] = { 5, 6, 8 };
        // minSubsetSumDifference(arr, 3);
        // tabulation(arr);

        System.out.println(minSUbSetDiffRecu(arr));
        System.out.println(min);
    }
}
