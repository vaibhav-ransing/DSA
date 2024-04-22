package Subsequence_2;

import java.util.Arrays;

public class Count_LIS {

    public static int findNumberOfLIS(int[] nums) {
        // Write your code here.
        int n = nums.length;
        int dp[] = new int[n];
        int maxCountArr[] = new int[n];
        Arrays.fill(maxCountArr, -1);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            int count = 1;
            for (int j = 0; j < i; j++) {
                int pre_i = dp[i];
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] == pre_i) {
                    count++;
                } else {
                    count = 1;
                }
            }
            maxCountArr[i] = count;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(maxCountArr));
        int ans = Arrays.stream(maxCountArr).max().orElse(0);
        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = {3, 18, 14, 25, 1, 5, 17, 2};
        int[] arr = { 1, 3, 5, 4, 7 };
        // int[] arr = { 2, 2, 2, 2, 2 };
        findNumberOfLIS(arr);
    }
}