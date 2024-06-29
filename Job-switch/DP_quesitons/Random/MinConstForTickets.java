package Random;

import java.util.Arrays;

public class MinConstForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int[][] dp = new int[days.length][366 + 100];
        int ans = helper(0, 0, days, costs, dp);

        return ans;
    }

    public int helper(int idx, int daysDone, int[] days, int[] costs, int[][] dp) {
        if (idx == days.length)
            return 0;
        int min = Integer.MAX_VALUE;

        if(dp[idx][daysDone] != 0)  
            return dp[idx][daysDone];
        if (days[idx] <= daysDone) {
            return  helper(idx + 1, daysDone, days, costs, dp);
        } else {
            min = Math.min(min, costs[0] + helper(idx + 1, days[idx] + 0, days, costs, dp));
            min = Math.min(min, costs[1] + helper(idx + 1, days[idx] + 6, days, costs, dp));
            min = Math.min(min, costs[2] + helper(idx + 1, days[idx] + 29, days, costs, dp));
        }
        return dp[idx][daysDone] = min;
    }
}
