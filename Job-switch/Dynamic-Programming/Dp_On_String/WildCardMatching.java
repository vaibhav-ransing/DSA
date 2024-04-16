import java.util.Arrays;

public class WildCardMatching {

    public static boolean isMatch(String parent, String child) {

        if (parent.length() == 0) {
            for (int i = 0; i < child.length(); i++) {
                if (child.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        int dp[][] = new int[parent.length() + 1][child.length() + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        // return recursion(parent, child, 0, 0, dp);
        return end_recursion(parent, child, parent.length() - 1, child.length() - 1, dp);
    }

    public static boolean recursion(String parent, String child, int pi, int ci, int dp[][]) {

        if (pi == parent.length()) {
            for (int i = ci; i < child.length(); i++) {
                if (child.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if (pi == parent.length() || ci == child.length())
            return false;

        if (dp[pi][ci] != -1)
            return dp[pi][ci] == 1;

        boolean ans = false;
        if (child.charAt(ci) == '*') {
            for (int i = pi; i <= parent.length(); i++) {
                ans |= recursion(parent, child, i, ci + 1, dp);
            }
        } else if (child.charAt(ci) == '?' || child.charAt(ci) == parent.charAt(pi)) {
            ans |= recursion(parent, child, pi + 1, ci + 1, dp);
        } else {
            return false;
        }
        dp[pi][ci] = ans ? 1 : 0;
        return ans;
    }

    public static boolean end_recursion(String parent, String child, int pi, int ci, int dp[][]) {

        if (pi < 0 && ci < 0)
            return true;
        if (pi < 0) {
            for (int i = ci; i >= 0; i--) {
                if (child.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        if (pi > 0 && ci < 0)
            return false;

        if (ci < 0)
            return false;

        if (dp[pi][ci] != -1)
            return dp[pi][ci] == 1;

        boolean ans = false;
        if (child.charAt(ci) == '?' || child.charAt(ci) == parent.charAt(pi)) {
            ans |= end_recursion(parent, child, pi - 1, ci - 1, dp);
        } else if (child.charAt(ci) == '*') {
            boolean val = end_recursion(parent, child, pi - 1, ci, dp) || end_recursion(parent, child, pi, ci - 1, dp);
            ans |= val;
        } else {
            return false;
        }
        return (dp[pi][ci] = ans ? 1 : 0) == 1;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("?ay", "ray"));
    }
}