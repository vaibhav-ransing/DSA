import java.util.Arrays;

public class LongestPalSubstring {

    int[][] memo;
    String str;

    public String longestPalindrome(String s) {
        int n = s.length();
        str = s;
        memo = new int[n][n];
        Arrays.stream(memo).forEach(r -> Arrays.fill(r, -1));

        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (rec(i, j)) {
                    if (ans.length() < j - i + 1) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    public boolean rec(int l, int r) {
        if (l == r)
            return true;
        if (l > r)
            return true;
        if (str.charAt(l) != str.charAt(r))
            return false;

        if (memo[l][r] != -1)
            return memo[l][r] == 1;

        boolean ans = true;
        ans = ans && rec(l + 1, r - 1);

        memo[l][r] = ans ? 1 : 0;
        return ans;
    }
}
