public class UnboundedKnapSack {

    static int knapSack(int N, int W, int val[], int wt[]) {
        int[][] dp = new int[W + 5][N + 5];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return memo(W, val, wt, 0, dp);
    }

    static int memo(int W, int val[], int wt[], int idx,int[][] dp) {

        if (W == 0 || idx == val.length)
            return 0;

        if (dp[W][idx] != -1)
            return dp[W][idx];

        int dontPick = memo(W, val, wt, idx + 1, dp);
        int pick = 0;
        if (W >= wt[idx]) {
            pick = memo(W - wt[idx], val, wt, idx, dp) + val[idx];
        }
        return dp[W][idx] = Math.max(pick, dontPick);
    }

    public static void main(String[] args) {

    }
}
