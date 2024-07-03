package Random;

public class MinInsertionToMakeStringPal {

    public int minInsertions(String s) {
        return helper(s, 0, s.length()-1);
    }

    public int helper(String str, int i, int j) {
        if (i >= j)
            return 0;

        int ans = Integer.MAX_VALUE;
        if (str.charAt(i) == str.charAt(j)) {
            ans = helper(str, i + 1, j - 1);
        } else {
            int jskip = 1 + helper(str, i + 1, j);
            int iskip = 1 + helper(str, i, j - 1);
            ans = Math.min(jskip, iskip);
        }
        return ans;
    }
}
