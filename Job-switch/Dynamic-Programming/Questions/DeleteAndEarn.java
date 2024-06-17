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
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, disc, occ, 0, dp);
    }

    public int helper(int idx, int[] disc, int[] occ, int sum, int[] dp) {
        if (idx >= disc.length) {
            return sum;
        }
        if (dp[idx] != -1)
            return dp[idx];
        int skip = helper(idx + 1, disc, occ, sum, dp);
        int j = idx + 1;
        while (j < disc.length && (disc[j] <= disc[idx] + 1)) {
            j++;
        }
        int take = helper(j, disc, occ, sum + (disc[idx] * occ[idx]), dp);
        return dp[idx] = Math.max(take, skip);
    }
}