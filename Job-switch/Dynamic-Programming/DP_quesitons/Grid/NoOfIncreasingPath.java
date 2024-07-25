package Grid;

public class NoOfIncreasingPath {

    public int countPaths(int[][] matrix) {

        int memo[][] = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                helepr(i, j, memo, matrix);
            }
        }
        int ans = 0;
        for (int[] arr : memo) {
            for (int val : arr) {
                ans = (ans + val) % MOD;
            }
        }
        return ans;
    }

    int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    int MOD = 1000000007;

    public int helepr(int r, int c, int[][] memo, int[][] matrix) {

        if (memo[r][c] != 0)
            return memo[r][c];

        int ans = 1;
        for (int d[] : dir) {
            int rr = r + d[0];
            int cc = c + d[1];
            // 1 -> 2 -> 3
            // 1 -> 4
            // From 1 we have " 1, 1 -> 2, 1-> 2-> 3 "  ans "1 -> 4"
            // so taotal = 4
            // so technically sum of all the max possible len from all 4 directions
            if (rr >= 0 && cc >= 0 && rr < matrix.length && cc < matrix[0].length && matrix[rr][cc] > matrix[r][c]) {
                // add all the values 
                ans += (helepr(rr, cc, memo, matrix) % MOD);
            }
        }
        return memo[r][c] = (ans % MOD);
    }
}
