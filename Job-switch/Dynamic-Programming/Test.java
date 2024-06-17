import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
    public static void deleteAndEarn(int[] nums) {
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

        // Use the helper function starting at index 0
        long result = helper(0, disc, occ, dp);
        System.out.println(result);
    }

    public static long helper(int idx, int[] disc, int[] occ, long[] dp) {
        if (idx >= disc.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Skip current element
        long skip = helper(idx + 1, disc, occ, dp);

        // Find the next non-consecutive element
        int j = idx + 1;
        while (j < disc.length && disc[j] == disc[idx] + 1) {
            j++;
        }

        // Take current element and add its value
        long take = (disc[idx] * (long) occ[idx]) + helper(j, disc, occ, dp);

        // Store the maximum result in dp array
        dp[idx] = Math.max(take, skip);
        return dp[idx];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        deleteAndEarn(arr);
    }
}
