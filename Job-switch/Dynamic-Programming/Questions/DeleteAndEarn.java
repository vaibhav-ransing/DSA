package Questions;

import java.util.Arrays;
import java.util.TreeMap;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int n = map.size();
        int disc[] = new int[n];
        int occ[] = new int[n];

        int idx = 0;
        for (int val : map.keySet()) {
            disc[idx] = val;
            occ[idx++] = map.get(val);
        }
        long dp[] = new long[n];
        Arrays.fill(dp, -1);
        helper(0, disc, occ, dp);

        return (int) Arrays.stream(dp).max().orElse(0);
    }

    public long helper(int idx, int[] disc, int[] occ, long[] dp) {
        if (idx >= disc.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        // Skip current element
        long skip = helper(idx + 1, disc, occ, dp);

        // Find the next non-consecutive element
        int j = idx + 1;
        while (j < disc.length && disc[j] == disc[idx] + 1) {
            j++;
        }
        // Take current element and add its value
        long take = (disc[idx] * (long) occ[idx]) + helper(j, disc, occ, dp);

        return dp[idx] = Math.max(take, skip);
    }
}