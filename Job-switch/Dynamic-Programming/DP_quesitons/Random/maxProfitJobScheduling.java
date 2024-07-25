package Random;

import java.util.Arrays;

public class maxProfitJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int sum = Arrays.stream(profit).sum();
        int dp[][] = new int[startTime.length][sum + 1];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d, -1));
        int ans = helper(0, 0, startTime, endTime, profit, dp);
        return ans;
    }

    public int helper(int idx, int prePickedEndTime, int[] startTime, int[] endTime, int[] profit, int dp[][]) {
        if (idx == startTime.length)
            return 0;
        if (dp[idx][prePickedEndTime] != -1)
            return dp[idx][prePickedEndTime];
        int skip = 0, take = 0;

        skip = helper(idx + 1, prePickedEndTime, startTime, endTime, profit, dp);

        if (prePickedEndTime <= startTime[idx]) {
            take = profit[idx] + helper(idx + 1, endTime[idx], startTime, endTime, profit, dp);
        }

        return dp[idx][prePickedEndTime] = Math.max(skip, take);
    }
}
