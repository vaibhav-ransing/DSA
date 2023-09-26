public class ZeroOneKnapSack {

    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        int[][] dp = new int[W + 5][n + 5];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = memo(wt, 0, W, val, dp);
        return ans;
    }

    static int memo(int[] wt, int idx, int W, int[] val,int[][] dp) {
        if (idx == wt.length || W == 0)
            return 0;
        
        if (dp[W][idx] != -1)
            return dp[W][idx];

        int dontPick = memo(wt, idx + 1, W, val, dp);
        int pick = 0;
        if (W >= wt[idx]) {
            pick = memo(wt, idx + 1, W - wt[idx], val, dp) + val[idx];
        }
        return dp[W][idx] = Math.max(pick, dontPick);
    }

    static int tabulation(int W, int wt[], int val[], int n){


        return 0;
    }


    

    public static void main(String[] args) {

    }
}