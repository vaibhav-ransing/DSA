package Questions;
public class SurroundedRegins {

    boolean[][] visisted;
    int n;
    int m;
    int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        visisted = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visisted[i][j] && board[i][j] == 'O' && (i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
                    dfsSetVisitedTrue(board, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visisted[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfsSetVisitedTrue(char[][] board, int row, int col) {

        visisted[row][col] = true;

        for (int[] d : dir) {
            int rr = row + d[0];
            int cc = col + d[1];

            if (rr < 0 || rr >= n || cc < 0 || cc >= m)
                continue;
            if (!visisted[rr][cc] && board[rr][cc] == 'O') {
                dfsSetVisitedTrue(board, rr, cc);
            }
        }
    }
}
