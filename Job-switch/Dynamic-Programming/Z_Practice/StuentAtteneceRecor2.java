public class StuentAtteneceRecor2 {

    class Solution {
        int MOD = 1000000007;

        public int checkRecord(int n) {
            Integer[][][] memo = new Integer[n + 1][2][3];
            return rec(n, 0, 0, memo)% MOD;
        }

        public int rec(int n, int a, int l, Integer[][][] memo) {
            if (n == 0) {
                return 1;
            }
            if (memo[n][a][l] != null) {
                return memo[n][a][l];
            }

            int count = 0;

            // Add 'A' if there is no 'A' so far
            if (a == 0) {
                count = (count + rec(n - 1, a + 1, 0, memo) % MOD) % MOD;
            }

            // Add 'L' if there are less than 2 consecutive 'L's so far
            if (l < 2) {
                count = (count + rec(n - 1, a, l + 1, memo) % MOD) % MOD;
            }

            // Add 'P'
            count = (count + rec(n - 1, a, 0, memo) % MOD) % MOD;

            memo[n][a][l] = count % MOD;
            return count % MOD;
        }
    }
}
