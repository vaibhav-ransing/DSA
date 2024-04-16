import java.util.Arrays;

public class EditDistance {

    public static int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()][word2.length()];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        int ans = helper(word1.length() - 1, word2.length() - 1, word1, word2, dp);
        return ans;
    }

    public static int helper(int pidx, int cidx, String parent, String child, int[][] dp) {

        if (cidx < 0)
            return pidx + 1;
        if (pidx < 0)
            return cidx + 1;
        if (dp[pidx][cidx] != -1)
            return dp[pidx][cidx];
        int val = Integer.MAX_VALUE;

        if (parent.charAt(pidx) == child.charAt(cidx)) {
            val = helper(pidx - 1, cidx - 1, parent, child, dp);
        } else {
            int insert = helper(pidx, cidx - 1, parent, child, dp) + 1;
            int delete = helper(pidx - 1, cidx, parent, child, dp) + 1;
            int replace = helper(pidx - 1, cidx - 1, parent, child, dp) + 1;

            val = Math.min(val, Math.min(insert, Math.min(delete, replace)));
        }
        return dp[pidx][cidx] = val;
    }

    public static int tabulation(String word1, String word2) {

        // "", "a"

        int n = word1.length();
        int m = word2.length();

        if (n == 0)
            return m;

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i; // this can be handled in main loop
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));

                }
            }
        }
        return dp[n][m];
    }

    public static int tabulationLittleBettter(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        if (n == 0)
            return m;
        int prev[] = new int[m + 1];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            int curr[] = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j < m + 1; j++) {
                curr[j] = j;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int insert = curr[j - 1] + 1;
                    int delete = prev[j] + 1;
                    int replace = prev[j - 1] + 1;

                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }
        return prev[m];
    }


    public static void main(String[] args) {
        System.out.println(minDistance("pi", "ci"));
    }
}

// inten
// execu