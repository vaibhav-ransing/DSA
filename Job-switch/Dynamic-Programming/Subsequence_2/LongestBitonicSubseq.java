package Subsequence_2;

import java.util.Arrays;
import java.util.Collections;

public class LongestBitonicSubseq {

    public static int bitonicBakchodSoln(int[] arr, int n) {
        // Write your code here.
        boolean increaseing = true;
        boolean toggle = false;
        int len = 1;
        // [1, 2, 1, 2, 1]
        for (int i = 1; i < arr.length; i++) {
            if (increaseing) {
                if (arr[i - 1] > arr[i]) {
                    if (toggle == false) {
                        toggle = true;
                        increaseing = false;
                    } else
                        return len;
                }
            } else {
                if (arr[i] > arr[i - 1])
                    return len;
            }
            len++;
        }
        return len;
    }

    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.
        int dpIncreasing[] = LIS_DP(arr);
        int dpDeacreasing[] = LIS_Reverse(arr);

        int max = 0;
        for (int i = 0; i < dpDeacreasing.length; i++) {
            max = Math.max(max, (dpDeacreasing[i] + dpIncreasing[i] - 1));
        }
        return max;
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

    public static void main(String[] args) {
        // int array[] = { 1, 2, 3, 4, 7, 2, 1 };
        int array[] = { 20, 11, 8, 17, 38, 25, 41, 22, 32, 46, 34 };
        System.out.println(longestBitonicSequence(array, array.length));
        LIS_Reverse(array);
    }
}