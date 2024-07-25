package Z_DailyLC;
import java.util.Arrays;

public class validSubseq2 {

    public int maximumLength(int[] nums, int k) {

        int n = nums.length;
        int[][][] dp = new int[n][n + 1][k + 1]; // idx, prevIdx, rem
        Arrays.stream(dp).forEach(dp2D -> Arrays.stream(dp2D).forEach(d -> Arrays.fill(d, -1)));

        return helper(0, -1, 0, nums, dp, k);
    }

    public int helper(int idx, int prevIdx, int rem, int[] arr, int[][][] dp, int k) {
        if (idx == arr.length)
            return 0;

        if (dp[idx][prevIdx + 1][rem] != -1)
            return dp[idx][prevIdx + 1][rem];
        int skip = helper(idx + 1, prevIdx, rem, arr, dp, k);
        int take = 0;
        if (prevIdx == -1 || (arr[idx] + arr[prevIdx]) % k == rem) {
            if (prevIdx == -1) {
                for (int i = 1; i <= k; i++) {
                    take = Math.max(take, 1 + helper(idx + 1, idx, i, arr, dp, k));
                }
            } else {
                take = 1 + helper(idx + 1, idx, (arr[idx] + arr[prevIdx]) % k, arr, dp, k);
            }
        }
        return dp[idx][prevIdx + 1][rem] = Math.max(skip, take);
    }
}
