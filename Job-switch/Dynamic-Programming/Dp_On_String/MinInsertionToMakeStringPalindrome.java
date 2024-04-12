public class MinInsertionToMakeStringPalindrome {

    public static int minInsertion(String str) {

        int lps = longestPalindromeSubseq(str);
        int n = str.length();
        int rem = n - lps;
        return rem;
    }

    public static int longestPalindromeSubseq(String s) {

        String text1 = s;
        String text2 = new StringBuilder(s).reverse().toString();
        int n = text1.length() + 1;
        int m = text2.length() + 1;
        int[][] dp = new int[n][m];

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

    public static void main(String[] args) {
        System.out.println(minInsertion("abca"));
    }
}
