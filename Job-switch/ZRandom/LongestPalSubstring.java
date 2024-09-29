package ZRandom;

import java.util.Arrays;

public class LongestPalSubstring {

    public String longestPalindrome(String s) {
        String ans = "";
        int memo[][] = new int[s.length()][s.length()];
        Arrays.stream(memo).forEach(r -> Arrays.fill(r, -1));

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                boolean rec = rec(i, j, s, memo);
                if (rec && (j - i + 1) > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    } 

    boolean rec(int i, int j, String s, int[][] memo) {
        if (s.charAt(i) != s.charAt(j))
            return false;
        if (i >= j)
            return true;
        if (memo[i][j] != -1)
            return memo[i][j] == 1;

        memo[i][j] = (rec(i + 1, j - 1, s, memo) ? 1 : 0);

        return memo[i][j] == 1;
    }
}
