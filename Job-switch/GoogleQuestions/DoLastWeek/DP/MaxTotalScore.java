package DoLastWeek.DP;

import java.util.Arrays;

public class MaxTotalScore {

    // Greedy approach

    public static void soln(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        // keep the index of maximum to the right and jump to the max
        int rmaxIdx = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = arr[rmaxIdx] * (rmaxIdx - i) + dp[rmaxIdx];
            if (arr[i] > arr[rmaxIdx]) {
                rmaxIdx = i;
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    // brute force soln
    public static void brute(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i] = Math.max(dp[i], (j - i) * arr[j] + dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    // Approach 3 : Iterative version tc : O(n)
    // While going from target to source, make note of max seen so far, at each
    // iteration we want to append max to the result.
    public static int getMaxScore(int[] nums) {
        int result = 0;
        int maxSeenSoFar = Integer.MIN_VALUE;
        // First value doesn't matter hence condition > 0
        for (int i = nums.length - 1; i > 0; i--) {
            maxSeenSoFar = Math.max(maxSeenSoFar, nums[i]);
            result += maxSeenSoFar;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 12, 9, 10 };
        brute(arr);
        soln(arr);
    }
}
