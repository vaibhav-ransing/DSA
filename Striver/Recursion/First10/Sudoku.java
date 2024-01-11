package First10;

import java.util.Arrays;

public class Sudoku {

    public static void solveSudoku(char[][] board) {
        System.out.println(Arrays.deepToString(board));
        dfs(board, 0, 0);
    }

    public static boolean dfs(char[][] board, int row, int col) {
        if (row == board.length - 1 && col == board.length) {
            System.out.println(Arrays.deepToString(board));
            return true;
        }
        if (col == board.length) {
            col = 0;
            row = row + 1;
        }
        if (board[row][col] == '.') {
            for (char k = '1'; k <= '9'; k++) {
                if (isValid(board, row, col, k)) {
                    board[row][col] = k;
                    boolean isSolved = dfs(board, row, col + 1);
                    if(isSolved){
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        } else {
            return dfs(board, row, col + 1);
        }
        return false;
    }

    public static void helper(char[][] board, int row, int col) {
        if (row == board.length && col == board[0].length) {
            System.out.println(Arrays.deepToString(board));
            return;
        }
        for (int i = row; i < board.length; i++) {
            for (int j = col; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            helper(board,
                                    j == board.length - 1 ? i + 1 : i,
                                    j == board.length - 1 ? 0 : j + 1);

                            board[i][j] = '.';
                        }
                    }
                } else {
                    helper(board,
                            j == board.length - 1 ? i + 1 : i,
                            j == board.length - 1 ? 0 : j + 1);
                }
            }
        }
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;

            if (board[row][i] == c)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    public static boolean isSafe(char[][] board, int row, int col, int val) {

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == val || board[i][col] == val) {
                return false;
            }
        }
        int cr = (row / 3) * 3;
        int cc = (col / 3) * 3;
        for (int i = cr; i < cr + 3; i++) {
            for (int j = cc; j < cc + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solveSudoku(board);
    }

}
