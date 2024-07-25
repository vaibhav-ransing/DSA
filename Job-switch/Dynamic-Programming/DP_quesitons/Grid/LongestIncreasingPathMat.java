package Grid;

public class LongestIncreasingPathMat {

    public int longestIncreasingPath(int[][] matrix) {
        int memo[][] = new int[matrix.length][matrix[0].length];

        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = helepr(i, j, memo, matrix);
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }

    int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int helepr(int r, int c, int[][] memo, int[][] matrix) {

        if (memo[r][c] != 0)
            return memo[r][c];

        int ans = 1;
        for (int d[] : dir) {
            int rr = r + d[0];
            int cc = c + d[1];
            if (rr >= 0 && cc >= 0 && rr < matrix.length && cc < matrix[0].length && matrix[rr][cc] > matrix[r][c]) {
                int len = 1 + helepr(rr, cc, memo, matrix);
                ans = Math.max(ans, len);
            }
        }
        return memo[r][c] = ans;
    }
}
