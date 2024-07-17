import java.util.Arrays;

public class MinDifficultOfJobSchedule {

    int dp[][];

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        dp = new int[n][d + 1];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        int[][] maxDiff = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    maxDiff[i][j] = jobDifficulty[j];
                } else {
                    maxDiff[i][j] = Math.max(jobDifficulty[j], maxDiff[i][j - 1]);
                }
            }
        }
        int ans = rec(0, d, maxDiff);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int rec(int preDone, int d, int maxDiff[][]) {
        if (d < 0) {
            return Integer.MAX_VALUE;
        }
        if (preDone == maxDiff.length) {
            return d == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (dp[preDone][d] != -1) {
            return dp[preDone][d];
        }
        int min = Integer.MAX_VALUE;

        for (int j = preDone; j < maxDiff.length; j++) {
            int nxt = rec(j + 1, d - 1, maxDiff);
            if (nxt != Integer.MAX_VALUE) {
                int dif_from_prevDone_j = maxDiff[preDone][j];
                min = Math.min(min, dif_from_prevDone_j + nxt);
            }
        }
        return dp[preDone][d] = min;
    }

}
