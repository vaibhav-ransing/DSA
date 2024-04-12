import java.util.Arrays;

public class LCS {

    public static void printAllSubsequences(String s, int idx, String ans) {
        if (idx == s.length()) {
            System.out.println(ans);
            return;
        }

        printAllSubsequences(s, idx + 1, ans + s.charAt(idx));
        printAllSubsequences(s, idx + 1, ans);
    }

    public static int lcs(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int dp[][] = new int[sLen][tLen];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        int val = recursion(s, t, sLen - 1, tLen - 1, dp);
        return val;
    }

    // TC (recuursive): 2^N * 2^M
    // TC (tabulation): M * N SC: N*M + N+M i.e. dp space + stack space
    public static int recursion(String s1, String t2, int idx1, int idx2, int dp[][]) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }
        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];
        int val = 0;
        if (s1.charAt(idx1) == t2.charAt(idx2)) {
            val += recursion(s1, t2, idx1 - 1, idx2 - 1, dp) + 1;
        } else {
            int s1Take = recursion(s1, t2, idx1, idx2 - 1, dp);
            int s2Take = recursion(s1, t2, idx1 - 1, idx2, dp);

            val = Math.max(s1Take, s2Take);
        }

        return dp[idx1][idx2] = val;
    }

    // Tabulation
    public int longestCommonSubsequence(String text1, String text2) {

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

    public static String printLcs(String text1, String text2) {

        int n = text1.length() + 1;
        int m = text2.length() + 1;
        String[][] dp = new String[n][m];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, ""));
        // dp[0][0] = 1;
        // adebc
        // dcadb
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + text1.charAt(i - 1));
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        Arrays.stream(dp).forEach(row -> System.out.println(Arrays.toString(row)));
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        String s = "adebc";
        String t = "dcadb";

        // lcs(s, t);
        printLcs(s, t);
    }
}
