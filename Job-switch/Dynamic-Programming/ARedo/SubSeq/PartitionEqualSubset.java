import java.util.Arrays;

public class PartitionEqualSubset {
    
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1)
            return false;
        int[][] dp = new int[nums.length][sum / 2 + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return rec(0, sum / 2, nums, dp);
    }

    public boolean rec(int idx, int sum, int[] nums, int[][] dp) {
        if (idx == nums.length && sum == 0) {
            return true;
        }
        if (idx == nums.length || sum < 0)
            return false;
        if (dp[idx][sum] != -1)
            return dp[idx][sum] == 1;
        boolean ans = rec(idx + 1, sum - nums[idx], nums, dp) || rec(idx + 1, sum, nums, dp);
        dp[idx][sum] = ans ? 1 : 0;
        return ans;
    }

    public boolean ineffRec(int idx, int s1, int s2, int[] nums, int[][] dp) {
        if (idx == nums.length) {
            return s1 == s2;
        }
        if (dp[s1][s2] == -1)
            return dp[s1][s2] == 1;

        boolean pick1 = ineffRec(idx + 1, s1 + nums[idx], s2, nums, dp);
        boolean pick2 = ineffRec(idx + 1, s1, s2 + nums[idx], nums, dp);

        dp[s1][s2] = (pick1 || pick2) ? 1 : 0;

        return pick1 || pick2;
    }

    public class Solution {
        public static boolean canPartition(int[] arr, int n) {

            int sum = Arrays.stream(arr).sum();
            if (sum % 2 == 1)
                return false;
            sum /= 2;
            return tabulation(sum, arr);
        }

        public static boolean tabulation(int target, int[] arr) {
            boolean dp[][] = new boolean[arr.length + 1][target + 1];
            int m = dp.length;
            int n = dp[0].length;

            dp[0][0] = true;

            for (int row = 1; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    int arrVal = arr[row - 1];
                    boolean dontTake = dp[row - 1][col];
                    boolean take = false;
                    if (col - arrVal >= 0) {
                        take = dp[row - 1][col - arrVal];
                    }
                    dp[row][col] = take || dontTake;
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}