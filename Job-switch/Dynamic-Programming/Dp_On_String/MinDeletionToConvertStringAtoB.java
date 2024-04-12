public class MinDeletionToConvertStringAtoB {
    

    public static int canYouMake(String s1, String s2) {
        // Write your code here.

        int lcs = longestCommonSubsequence(s1, s2);
        int s1Rem = s1.length() - lcs;
        int s2Rem = s2.length() - lcs;

        return s1Rem + s2Rem;
    }


    public static int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length() + 1;
        int m = text2.length() + 1;
        int[][] dp = new int[n][m];
        // dp[0][0] = 1;
        // adebc
        // dcadb
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
