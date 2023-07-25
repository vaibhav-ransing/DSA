package Day9;

public class WordSearch {

    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                boolean ans = helper(board, word, 0, i, j);
                if(ans) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int idx, int row, int col) {
        if (idx == word.length())
            return true;

        if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(idx) || board[row][col] == '#')
            return false;
        
        for (int[] d : dir) {
            board[row][col] = '#';
            int rr = d[0] + row;
            int cc = d[1] + col;
            boolean flag = helper(board, word, idx + 1, rr, cc);
            if (flag)
                return true;
            board[row][col] = word.charAt(idx);
        }
        return false;

    }
}
