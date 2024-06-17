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
        System.out.println(Arrays.toString(disc));
        System.out.println(Arrays.toString(occ));
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        helper(0, disc, occ, 0, dp);
        System.out.println(Arrays.stream(dp).max().orElse(0));
    }

    public static int helper(int idx, int[] disc, int[] occ, int sum, int[] dp) {
        if (idx >= disc.length) {
            return sum;
        }
        if (dp[idx] != -1)
            return dp[idx];
        int skip = helper(idx + 1, disc, occ, sum, dp);

        int j = idx + 1;
        while (j < disc.length && disc[j] <= disc[idx] + 1) {
            j++;
        }
        System.out.println(disc[idx] + " | idx= " + idx + " | j= " + j + " | sum= " + sum);
        int take = helper(j, disc, occ, sum + (disc[idx] * occ[idx]), dp);

        return dp[idx] = Math.max(take, skip);
    }

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = scn.nextInt();
        // }
        // deleteAndEarn(arr);
        deleteAndEarn(new int[] { 1, 2, 3 });
    }
}
