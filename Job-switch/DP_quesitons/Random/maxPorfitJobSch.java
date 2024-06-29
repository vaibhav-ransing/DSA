package Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class maxPorfitJobSch {
    public static class pair implements Comparable<pair> {
        int startTime;
        int endTime;
        int profit;

        pair(int np, int sp, int profit) {
            this.startTime = np;
            this.endTime = sp;
            this.profit = profit;
        }

        public int compareTo(pair o) {
            return this.startTime - o.startTime;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<pair> list = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            pair p = new pair(startTime[i], endTime[i], profit[i]);
            list.add(p);
        }
        Collections.sort(list);
        int sum = Arrays.stream(profit).sum();
        int dp[][] = new int[startTime.length][sum + 1];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d, -1));
        return helper(0, 0, list, dp);
    }

    public int helper(int idx, int prePickedEndTime, ArrayList<pair> list, int dp[][]) {
        if (idx == list.size())
            return 0;
        if (dp[idx][prePickedEndTime] != -1)
            return dp[idx][prePickedEndTime];
        int skip = 0, take = 0;

        skip = helper(idx + 1, prePickedEndTime, list, dp);

        if (prePickedEndTime <= list.get(idx).startTime) {
            take = list.get(idx).profit + helper(idx + 1, list.get(idx).endTime, list, dp);
        }

        return dp[idx][prePickedEndTime] = Math.max(skip, take);
    }

}
