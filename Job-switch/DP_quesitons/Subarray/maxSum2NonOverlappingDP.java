package Subarray;

import java.util.Arrays;
import java.util.Collections;

public class maxSum2NonOverlappingDP {

    public static int maxSumTwoNoOverlap(int[] nums, int x, int y) {
        int xfirst = helper(nums, x, y);  // taking first x elements and then y elements
        int yfirst = helper(nums, y, x);  // taking first y elemetns and then x elements

        return Math.max(xfirst, yfirst);
    }

    public static int helper(int[] nums, int x, int y) {

        int n = nums.length;

        int dp1[] = new int[n];
        int dp2[] = new int[n];

        // Dp1 = max subarray sum of size x till index i from 0 to i
        fillDp(nums, x, dp1);

        reverse(nums);
        // This give max sunarray sum of size y till index i from n-1 to i (only in reverse order)
        fillDp(nums, y, dp2);
        reverse(dp2);  // reversing it for traversal

        reverse(nums);

        int max = 0;
        for (int i = 0; i < n - (Math.max(x, y)); i++) {
            max = Math.max(max, dp1[i] + dp2[i + 1]);
        }
        return max;
    }

    static void reverse(int a[]) {
        int n = a.length;
        int i, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    public static void fillDp(int nums[], int x, int dp[]) {

        int prefix[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = x; i <= nums.length; i++) {
            int curr_prefix = prefix[i] - prefix[i - x];
            dp[i - 1] = Math.max(i - 2 >= 0 ? dp[i - 2] : 0, curr_prefix);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 8, 1, 3, 2, 1, 8, 9, 0 }; // 10
        maxSumTwoNoOverlap(arr, 2, 3);
        // int arr[] = { 0, 6, 5, 2, 2, 5, 1, 9, 4 }; // 10
        // maxSumTwoNoOverlap(arr, 1, 2);
    }
}
