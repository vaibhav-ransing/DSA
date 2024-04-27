package Subsequence_2;

import java.util.Arrays;

public class Count_LIS {

    public static int findNumberOfLIS(int[] nums) {
        // Write your code here.
        int n = nums.length;
        
        int dp[] = new int[n];
        int countArr[] = new int[n];

        Arrays.fill(countArr, 1);
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            // 1, 5, 4, 3, 2, 6
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + dp[j] > dp[i] ) {
                    dp[i] = 1 + dp[j];
                    countArr[i] = countArr[j];
                } else if (nums[i] > nums[j] && dp[j] + 1 == dp[i]) {
                    countArr[i] += countArr[j];
                }
            }
        }

        System.out.println("numbe= " + Arrays.toString(nums));
        System.out.println("dynam= " + Arrays.toString(dp));
        System.out.println("Count= " + Arrays.toString(countArr));
        int ans = Arrays.stream(countArr).max().orElse(0);
        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = {3, 18, 14, 25, 1, 5, 17, 2};
        int[] arr = { 1, 3, 5, 4, 7 };
        // int[] arr = { 2, 2, 2, 2, 2 };
        // int[] arr = { 1, 2, 4, 3, 5, 4, 7, 2 };
        // int[] arr = { 1, 5, 4, 3, 2, 6, 7, 10, 8, 9 };
        findNumberOfLIS(arr);
    }
}