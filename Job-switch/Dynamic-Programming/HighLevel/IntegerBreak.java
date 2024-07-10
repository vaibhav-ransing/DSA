import java.util.Arrays;

public class IntegerBreak {

    class Solution {
        public int integerBreak(int n) {
            if (n == 2)
                return 1;
            if (n == 3)
                return 2;
            int product = 1;
            while (n > 4) {
                product *= 3;
                n -= 3;
            }
            product *= n;
            return product;
        }
    }

    int[][] memo;

    public int integerBreak(int n) {
        memo = new int[n + n][n + 1]; // cn, k
        Arrays.stream(memo).forEach(d -> Arrays.fill(d, -1));
        int ans = 0;
        for (int k = 2; k <= n; k++) {
            ans = Math.max(ans, helper(0, k, n));
        }
        return ans;
    }

    public int helper(int cn, int k, int n) {
        if (k == 0) {
            return cn == n ? 1 : 0;
        }
        if (cn > n)
            return 0;
        if (memo[cn][k] != -1)
            return memo[cn][k];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, i * helper(cn + i, k - 1, n));
        }
        return memo[cn][k] = max;
    }

}
