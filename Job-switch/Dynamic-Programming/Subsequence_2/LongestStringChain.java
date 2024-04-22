package Subsequence_2;

import java.util.Arrays;

public class LongestStringChain {

    public static int longestStrChain(String[] words) {
        int dp[][] = new int[words.length][words.length + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int val = recursion(0, -1, words, dp);
        return val;
    }

    public static int recursion(int idx, int pre_idx, String[] words, int dp[][]) {
        if (idx == words.length)
            return 0;
        // "xbc","pcxbcf","xb","cxbc","pcxbc"
        if (dp[idx][pre_idx + 1] != -1)
            return dp[idx][pre_idx + 1];
        int take = 0;
        if (pre_idx == -1 || compare(words[idx], words[pre_idx])) {
            take = 1 + recursion(idx + 1, idx, words, dp);
        }
        int skip = recursion(idx + 1, pre_idx, words, dp);
        return dp[idx][pre_idx + 1] = Math.max(take, skip);
    }

    public static int tabulation(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int dp[][] = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int take = 0;
                if (j == -1 || compare(words[i], words[j])) {
                    take = 1 + dp[i + 1][i + 1];
                }
                int skip = dp[i + 1][j + 1];
                dp[i][j + 1] = Math.max(take, skip);
            }
        }
        return dp[0][0];
    }

    static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }

    public static boolean lcs(String s1, String s2) {
        if (s1.length() == s2.length())
            return false;
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return (Math.max(s1.length(), s2.length()) - dp[s1.length()][s2.length()]) == 1;
    }

    public static void main(String[] args) {
        // String[] arr = {"a","b","ba","bca","bda","bdca"};
        // String[] arr = { "dbqca", "abcd" };
        String[] arr = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
        System.out.println(longestStrChain(arr));
        System.out.println(tabulation(arr));
    }
}
