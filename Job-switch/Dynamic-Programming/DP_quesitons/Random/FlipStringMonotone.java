package Random;

import java.util.Arrays;

public class FlipStringMonotone {

    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int[][] dp = new int[arr.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, arr, dp, '0');
    }

    public int helper(int idx, char[] arr, int[][] dp, char prev) {
        if (idx == arr.length) {
            return 0;
        }

        int prevState = prev == '1' ? 1 : 0;

        if (dp[idx][prevState] != -1) {
            return dp[idx][prevState];
        }

        int min = Integer.MAX_VALUE;
        char ch = arr[idx];

        if (ch == '0') {
            // Option 1: Keep it as '0'
            if (prev == '0') {
                min = Math.min(min, helper(idx + 1, arr, dp, '0'));
            }
            // Option 2: Flip it to '1'
            min = Math.min(min, 1 + helper(idx + 1, arr, dp, '1'));
        } else { // ch == '1'
            // Option 1: Keep it as '1'
            min = Math.min(min, helper(idx + 1, arr, dp, '1'));
            // Option 2: Flip it to '0'
            if (prev == '0') {
                min = Math.min(min, 1 + helper(idx + 1, arr, dp, '0'));
            }
        }

        dp[idx][prevState] = min;
        return min;
    }

    class MyRec {

        public int minFlipsMonoIncr(String s) {
            char[] arr = s.toCharArray();
            int dp[][] = new int[arr.length][2];
            Arrays.stream(dp).forEach(d -> Arrays.fill(d, -1));
            return helper(0, arr, dp);
        }

        public int helper(int idx, char[] arr, int[][] dp) {

            if (idx == arr.length)
                return 0;

            if (dp[idx][arr[idx] == '1' ? 1 : 0] != -1) {
                return dp[idx][arr[idx] == '1' ? 1 : 0];
            }

            int min = Integer.MAX_VALUE;

            char ch = arr[idx];
            // 0 1 0 1 1 0
            if (ch == '0') {
                if (idx == 0 || arr[idx - 1] == '0') {
                    min = Math.min(min, helper(idx + 1, arr, dp));
                }
                arr[idx] = '1';
                min = Math.min(min, 1 + helper(idx + 1, arr, dp));
                arr[idx] = '0';

            } else { // ch == '1'
                min = Math.min(min, helper(idx + 1, arr, dp));

                if (idx == 0 || arr[idx - 1] == '0') {
                    arr[idx] = '0';
                    min = Math.min(min, 1 + helper(idx + 1, arr, dp));
                    arr[idx] = '1';
                }
            }
            return dp[idx][arr[idx] == '1' ? 1 : 0] = min;
        }
    }
}
