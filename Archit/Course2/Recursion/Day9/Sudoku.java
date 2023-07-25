package Day9;

public class Sudoku {

    public static void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public static boolean helper(char[][] board, int row, int col) {
        if(col==board.length){
            row=row+1;
            col = 0;
        }

        if (row == board.length) {
            return true;
        }
        
        
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isSafe(board, row, col, ch)) {

                board[row][col] = ch;
                
                boolean ans = helper(board, row, col + 1);
                if(ans) return true;

                board[row][col] = '.'; // backtracking
            }
        }

        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col, char c) {
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

    public static void main(String[] args) {
        char[][] sudokuBoard = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }
        };

        solveSudoku(sudokuBoard);
    }

}