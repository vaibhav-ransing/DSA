package Partition_DP;

import java.util.ArrayList;
import java.util.Arrays;

public class BurtstBalloongs {

    public static int maxCoins(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        Arrays.stream(nums).forEach(val -> list.add(val));
        list.add(1);
        int[][] dp = new int[list.size()][list.size()];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return recursion(1, list.size() - 2, list, dp);
    }

    public static int recursion(int i, int j, ArrayList<Integer> nums, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MIN_VALUE;
        for (int idx = i; idx <= j; idx++) {
            int cost = nums.get(i - 1) * nums.get(idx) * nums.get(j + 1) +
                    recursion(i, idx - 1, nums, dp) +
                    recursion(idx + 1, j, nums, dp);
            ans = Math.max(ans, cost);
        }
        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 5, 8 };
        // int[] arr = { 1, 5};
        System.out.println(maxCoins(arr));
    }
}
