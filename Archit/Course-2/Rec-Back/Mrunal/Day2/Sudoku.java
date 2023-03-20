public class Sudoku {
    
    public static void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    public static void helper(char[][] board, int row, int col) {
        if(row==board.length){
            System.out.println(board);
            return;
        }
        if(col==board.length){
            row=row+1;
            col = 0;
        }
        for(char i='1'; i<='9'; i++){
            if(board[row][col]=='.' && isValid(board, row, col, i)){
                board[row][col]=i;
                helper(board, row, col+1);
                board[row][col]='.';
            }
        }
    }

    public static boolean isValid(char[][] board, int row, int col, char ch){
        for(int i=0; i<board.length; i++){
            if(board[i][col]==ch || board[row][i]==ch){
                return false;
            }
        }
        int rowTop = (row/3)*3;
        int colTop = (col/3)*3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int rr = rowTop+i;
                int cc = colTop+j;
                if(board[rr][cc]==ch){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        
    }
}
