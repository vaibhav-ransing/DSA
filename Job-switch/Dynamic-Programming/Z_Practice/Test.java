import java.util.Arrays;

public class Test {

    public int minDays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = helper(n, dp);
        return ans;
    }

    public int helper(int n, int[] dp) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int min = Integer.MAX_VALUE;

        min = Math.min(n % 2 + helper(n / 2, dp), n % 3 + helper(n / 3, dp));
        return dp[n] = min;
    }
}