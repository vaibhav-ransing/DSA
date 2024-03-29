package Subsequence;

import java.util.Arrays;

public class MinimumCoinsToMakeTarget {

    public static int minimumElements(int num[], int x) {
        int[][] dp = new int[num.length][x + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int ans = recursion(num.length - 1, num, x, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans - 1;
    }

    public static int tabulation(int[] num, int x){
        return 0;
    }

    public static int recursion(int idx, int nums[], int x, int[][] dp) {
        if (idx < 0)
            return x == 0 ? 1 : Integer.MAX_VALUE;

        if (dp[idx][x] != -1)
            return dp[idx][x];
        int take = Integer.MAX_VALUE;
        if (x - nums[idx] >= 0)
            take = recursion(idx, nums, x - nums[idx], dp);
        take += take == Integer.MAX_VALUE ? 0 : 1;
        int skip = recursion(idx - 1, nums, x, dp);

        return dp[idx][x] = Math.min(take, skip);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int x = 7;
        System.out.println(minimumElements(nums, x));
    }
}