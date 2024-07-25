package Random;

import java.util.Arrays;

public class TallestBilloard {

    public static int tallestBillboard(int[] rods) {
        int sum = Arrays.stream(rods).sum();
        int dp[][][] = new int[sum + 1][sum + 1][rods.length];
        for (int[][] matrix : dp) {
            for (int[] array : matrix) {
                Arrays.fill(array, -1);
            }
        }
        int max = helper(rods, 0, 0, 0, dp);
        return max;
    }

    static int helper(int[] rods, int i, int sum1, int sum2, int dp[][][]) {

        if (i == rods.length) {
            if (sum1 == sum2) {
                return sum1;
            }
            return 0;
        }

        if (dp[sum1][sum2][i] != -1) {
            return dp[sum1][sum2][i];
        }

        int max = 0;
        int val = rods[i];

        // skip
        max = Math.max(max, helper(rods, i + 1, sum1, sum2, dp));
        // add in sum1
        max = Math.max(max, helper(rods, i + 1, sum1 + val, sum2, dp));

        // add in sum2
        max = Math.max(max, helper(rods, i + 1, sum1, sum2 + val, dp));

        return dp[sum1][sum2][i] = max;
    }
}
