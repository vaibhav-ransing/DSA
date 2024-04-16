import java.util.Arrays;

public class DistinctSubsequences {

    public static int distinctSubsequences(String parent, String child) {

        // int ans = recursion(parent.length() - 1, "", parent, new
        // StringBuilder(child).reverse().toString());
        int pidx = parent.length();
        int cidx = child.length();
        int dp[][] = new int[pidx][cidx];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        int ans = recursion2(pidx - 1, cidx - 1, parent, child, dp);
        return ans;
    }

    public static int recursion2(int pidx, int cidx, String parent, String child, int[][] dp) {
        if (cidx < 0)
            return 1;

        if (pidx < 0)
            return 0;
        if (dp[pidx][cidx] != -1)
            return dp[pidx][cidx];

        int skip = recursion2(pidx - 1, cidx, parent, child, dp);
        int take = 0;

        if (parent.charAt(pidx) == child.charAt(cidx)) {
            take = recursion2(pidx - 1, cidx - 1, parent, child, dp);
        }

        return dp[pidx][cidx] = take + skip;
    }

    public static int tabulation(String parent, String child) {
        int pidx = parent.length();
        int cidx = child.length();
        int dp[][] = new int[pidx + 1][cidx + 1];
        // when the child is empty then there is always one way to take
        // So dp[1,2,3....n][0] = 1

        int prev[] = new int[cidx + 1];
        prev[0] = 1;
        Arrays.stream(dp).forEach(row -> row[0] = 1);
        for (int pi = 1; pi < dp.length; pi++) {
            for (int cj = 1; cj < dp[0].length; cj++) {
                int skip = dp[pi - 1][cj];
                int take = 0;
                if (parent.charAt(pi - 1) == child.charAt(cj - 1)) {
                    take = dp[pi - 1][cj - 1];
                }
                dp[pi][cj] = skip + take;
            }
        }

        Arrays.stream(dp).forEach(row -> System.out.println(Arrays.toString(row)));
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static int tabulationSpacOp(String parent, String child) {

        int cidx = child.length();
        int prev[] = new int[cidx + 1];
        prev[0] = 1;

        for (int pi = 1; pi <= parent.length(); pi++) {

            int curr[] = new int[cidx + 1];
            curr[0] = 1;
            for (int cj = 1; cj <= child.length(); cj++) {
                int skip = prev[cj];
                int take = 0;
                if (parent.charAt(pi - 1) == child.charAt(cj - 1)) {
                    take = prev[cj - 1];
                }
                curr[cj] = (skip + take) % 1000000007;
            }
            prev = curr;
        }

        return prev[prev.length - 1];
    }

    public static int tabulation1D(String parent, String child) {
        int cidx = child.length();
        int prev[] = new int[cidx + 1];
        prev[0] = 1;

        for (int pi = 1; pi <= parent.length(); pi++) {

            for (int cj = child.length(); cj >= 1; cj--) {
                int skip = prev[cj];
                int take = 0;
                if (parent.charAt(pi - 1) == child.charAt(cj - 1)) {
                    take = prev[cj - 1];
                }
                prev[cj] = (skip + take) % 1000000007;
            }
        }

        return prev[prev.length - 1];
    }

    public static int recursion(int idx, String ans, String parent, String child) {

        if (idx < 0 || ans.length() >= child.length())
            return ans.equals(child) ? 1 : 0;

        int take = recursion(idx - 1, ans + parent.charAt(idx), parent, child);
        int skip = recursion(idx - 1, ans, parent, child);

        return take + skip;
    }

    public static void main(String[] args) {
        String parent = "babgbag";
        String child = "bag";
        // String parent = "brootgroot";
        // String child = "brt";
        // System.out.println(distinctSubsequences(parent, child));
        tabulation(parent, child);
    }
}