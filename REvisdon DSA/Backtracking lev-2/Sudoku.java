import javax.print.event.PrintEvent;

public class Sudoku {
    


    public static void solveSudoku(int[][] board, int r, int c) {
        // write yopur code here
        if(r==board.length){
            System.out.println(board);
            return;
        }
        int nr = r;
        int nc = c+1;
        if(nc==board.length){
            nr = nr+1;
            nc = 0;
        }
        if(board[r][c]!=0){
            solveSudoku(board, nr, nc);
        }else{
            for(int val=1; val<10; val++){
                if(isSafe(val,r,c, board)){
                    board[r][c] = val;
                    solveSudoku(board, nr, nc);
                    board[r][c] = 0;
                }    
            }
        }
      }


      static boolean isSafe(int val, int r, int c, int[][] board){
        int n = board.length;
        for(int i=0; i<n; i++){
            if(board[r][i]==val || board[i][c]==val){
                return false;
            }
        }
        int sr = (r/3)*3;   
        int sc = (c/3)*3;
        for(int i=sr; i<sr+3; i++){
            for(int j= sc; j<sc+3; j++){
                if(board[i][j]==val)
                    return false;
            }
        }
        return true;
      }

    public static void main(String[] args) {
        
    }
}
