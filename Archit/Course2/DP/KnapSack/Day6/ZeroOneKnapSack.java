public class ZeroOneKnapSack {

    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        int[][] dp = new int[W + 5][n + 5];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = memo(wt, 0, W, val, 0, dp);
        return ans;
    }

    static int memo(int[] wt, int idx, int W, int[] val, int ans, int[][] dp) {
        if (idx == wt.length || W == 0)
            return ans;
        
        if (dp[W][idx] != -1)
            return dp[W][idx];

        int dontPick = memo(wt, idx + 1, W, val, ans, dp);
        int pick = 0;
        if (W >= wt[idx]) {
            pick = memo(wt, idx + 1, W - wt[idx], val, ans + val[idx], dp);
        }
        return dp[W][idx] = Math.max(pick, dontPick);
    }

    public static void main(String[] args) {

    }
}