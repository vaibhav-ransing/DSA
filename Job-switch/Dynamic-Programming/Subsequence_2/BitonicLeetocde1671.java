package Subsequence_2;

import java.util.Arrays;

public class BitonicLeetocde1671 {

    public int minimumMountainRemovalsCopiedSoln(int[] nums) {

        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];

        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        // calculate the longest increase subsequence (LIS) for every index i
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && LIS[j] + 1 > LIS[i])
                    LIS[i] = LIS[j] + 1;
            }
        }
        // calculate the longest decreasing subsequence(LDS) for every index i and keep
        // track of the maximum of LIS+LDS
        int max = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && LDS[j] + 1 > LDS[i])
                    LDS[i] = LDS[j] + 1;
            }

            if (LIS[i] > 1 && LDS[i] > 1)
                max = Math.max(LIS[i] + LDS[i] - 1, max);
        }
        return n - max;
    }

    public int minimumMountainRemovals(int[] arr) {

        int dpIncreasing[] = LIS_DP(arr);
        int dpDeacreasing[] = LIS_Reverse(arr);

        int max = 0;
        for (int i = 0; i < dpDeacreasing.length; i++) {
            max = Math.max(max, (dpDeacreasing[i] + dpIncreasing[i] - 1));
        }
        return arr.length - max;
    }

    public static int[] LIS_DP(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp;
    }

    public static int[] LIS_Reverse(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp;
    }
}
