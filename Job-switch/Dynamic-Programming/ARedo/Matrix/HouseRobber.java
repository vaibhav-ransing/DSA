
public class HouseRobber {
    public int rob(int[] arr) {
        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i - 1][1] + arr[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            max = Math.max(dp[i][0], max);
            max = Math.max(dp[i][1], max);
        }
        return max;
    }
}
