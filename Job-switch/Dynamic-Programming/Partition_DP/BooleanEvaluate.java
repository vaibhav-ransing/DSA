package Partition_DP;

import java.util.Arrays;

public class BooleanEvaluate {

    public static int parseBoolExpr(String expression) {
        int dp[][][] = new int[expression.length()][expression.length()][2];
        Arrays.stream(dp).forEach(row2d -> Arrays.stream(row2d).forEach(row -> Arrays.fill(row, -1)));
        return recursion(0, expression.length() - 1, 1, expression, dp);
    }

    static int mod = 1000000007;

    public static int recursion(int i, int j, int isTrue, String str, int dp[][][]) {
        // T|T & F
        // | & ^
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == 0) {
                return (str.charAt(i) == 'F') ? 1 : 0;

            } else {
                return (str.charAt(i) == 'T') ? 1 : 0;
            }
        }
        if (dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            char ch = str.charAt(k);
            int leftTrues = recursion(i, k - 1, 1, str, dp);
            int leftFalse = recursion(i, k - 1, 0, str, dp);
            int rightTrues = recursion(k + 1, j, 1, str, dp);
            int rightFalse = recursion(k + 1, j, 0, str, dp);
            if (ch == '|') {
                if (isTrue == 1) {  
                    ans += (leftFalse * rightTrues) % mod;
                    ans += (leftTrues * rightFalse) % mod;
                    ans += (leftTrues * rightTrues) % mod;
                } else {
                    ans += (leftFalse * rightFalse) % mod;
                }
            } else if (ch == '&') {
                if (isTrue == 1)
                    ans += (leftTrues * rightTrues) % mod;
                else {
                    ans += (leftFalse * rightFalse) % mod;
                    ans += (leftTrues * rightFalse) % mod;
                    ans += (leftFalse * rightTrues) % mod;
                }
            } else if (ch == '^') {
                if (isTrue == 1) {
                    ans += (leftTrues * rightFalse) % mod;
                    ans += (leftFalse * rightTrues) % mod;
                } else {
                    ans += (leftFalse * rightFalse) % mod;
                    ans += (leftTrues * rightTrues) % mod;
                }
            }
        }
        return dp[i][j][isTrue] = ans % mod;
    }

    public static boolean booleanApprach(int i, int j, String str) {
        // T|T & F
        // | & ^
        if (i == j) {
            return str.charAt(i) == 'T';
        }
        boolean ans = false;
        for (int k = i; k <= j; k++) {
            char ch = str.charAt(k);
            if (ch == '|' || ch == '&' || ch == '^') {
                boolean left = booleanApprach(i, k - 1, str);
                boolean right = booleanApprach(k + 1, j, str);
                if (ch == '|') {
                    ans = left || right; // OR operation
                } else if (ch == '&') {
                    ans = left && right; // AND operation
                } else if (ch == '^') {
                    ans = left ^ right; // XOR operation
                }
            }
        }
        System.out.println(i + " " + j + " " + ans);
        return ans;
    }

    // Striver COde
    static final int MOD = 1000000007;

    static long evaluateExpressionWays(String exp, int i, int j, int isTrue, Long[][][] dp) {
        // Base case 1: When the start index is greater than the end index, no ways to
        // evaluate.
        if (i > j) {
            return 0;
        }
        // Base case 2: When the start and end indices are the same.
        if (i == j) {
            if (isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if (dp[i][j][isTrue] != null) {
            return dp[i][j][isTrue];
        }

        long ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            long lT = evaluateExpressionWays(exp, i, ind - 1, 1, dp);
            long lF = evaluateExpressionWays(exp, i, ind - 1, 0, dp);
            long rT = evaluateExpressionWays(exp, ind + 1, j, 1, dp);
            long rF = evaluateExpressionWays(exp, ind + 1, j, 0, dp);

            char operator = exp.charAt(ind);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rF) % MOD) % MOD;
                }
            } else {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
                }
            }
        }

        dp[i][j][isTrue] = ways;
        return ways;
    }

    static int evaluateExp(String exp) {
        int n = exp.length();
        Long[][][] dp = new Long[n][n][2]; // dp[i][j][k] stores the number of ways to evaluate the subexpression from
                                           // index i to j with the result k (0 or 1).
        return (int) evaluateExpressionWays(exp, 0, n - 1, 1, dp);
    }

    public static void main(String[] args) {
        // parseBoolExpr("T&T|F");
        System.out.println(parseBoolExpr("T^T^F"));
    }
}