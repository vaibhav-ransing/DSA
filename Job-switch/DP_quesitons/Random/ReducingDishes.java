package Random;

import java.util.Arrays;

public class ReducingDishes {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length][satisfaction.length + 1];
        int val = rec(0, 1, satisfaction, dp);
        return val;
    }

    public int rec(int idx, int time, int[] satisfaction, int[][] dp) {
        if (idx == satisfaction.length)
            return 0;
        if (dp[idx][time] != 0)
            return dp[idx][time];
        int skip = rec(idx + 1, time, satisfaction, dp);
        int take = time * satisfaction[idx] + rec(idx + 1, time + 1, satisfaction, dp);

        return dp[idx][time] = Math.max(skip, take);
    }
}
