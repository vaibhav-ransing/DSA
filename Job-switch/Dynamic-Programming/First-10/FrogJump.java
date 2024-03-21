import java.util.Arrays;

public class FrogJump {

    public static int frogJump(int n, int heights[]) {
        int dp[] = new int[heights.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        System.out.println(soln(n - 1, heights, dp));
        return 0;
    }

    public static int soln(int n, int[] heights, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != Integer.MAX_VALUE)
            return dp[n];

        int step1 = soln(n - 1, heights, dp) + Math.abs(heights[n - 1] - heights[n]);
        int step2 = n == 1 ? Integer.MAX_VALUE : soln(n - 2, heights, dp) + Math.abs(heights[n - 2] - heights[n]);

        return dp[n] = Math.min(step1, step2);

    }

    public static int IterativeSolution(int n, int[] heights) {
        int dp[] = new int[n];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            int oneStepBack = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int twoStepBack = Integer.MAX_VALUE;
            if (i > 1) {
                twoStepBack = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(oneStepBack, twoStepBack);

        }
        return dp[heights.length - 1];

    }
    public static int IterativeSoln(int n, int[] heights) {
        int pre2 = 0;  // Two step back
        int pre1 = 0;  // One step back
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int oneStepBack = pre1 + Math.abs(heights[i] - heights[i - 1]);
            int twoStepBack = Integer.MAX_VALUE;
            if (i > 1) {
                twoStepBack = pre2 + Math.abs(heights[i] - heights[i - 2]);
            }
            ans = Math.min(oneStepBack, twoStepBack);
            // Make sure you keep the sequence, dont update pre1 before pre2
            // so for i+1 ans will be pre1 
            // and pre1 will be pre2 for i+1
            pre2 = pre1;  
            pre1 = ans;
        }
        return ans;
    }

    // public static int helper(int n, int[] heights, int[] dp) {
    // if (n == heights.length - 1)
    // return 0;
    // if (dp[n] != 9999999)
    // return dp[n];
    // if (n >= heights.length)
    // return 9999999;

    // int jump1 = Math.abs(heights[n + 1] - heights[n]) + helper(n + 1, heights,
    // dp);
    // int jump2 = n == heights.length - 2 ? 9999999
    // : Math.abs(heights[n + 2] - heights[n]) + helper(n + 2, heights, dp);
    // return dp[n] = Math.min(jump1, jump2);
    // }

    // public static void solutionIterative(int[] heights) {
    // int dp[] = new int[heights.length];
    // for (int i = 0; i < dp.length; i++) {
    // int jump1 = Math.abs(heights[i + 1] - heights[i]);
    // int jump2 = i == heights.length - 2 ? 99999 : Math.abs(heights[i + 2] -
    // heights[i]);

    // }
    // }

    public static void main(String[] args) {
        // int heights[] = {10,20,30,10};
        int heights[] = { 7, 5, 5, 8, 4, 9, 1, 1, 10 };
        // frogJump(heights.length, heights);
        // IterativeSolution(heights.length, heights);
        IterativeSoln(heights.length, heights);
    }
}
