public class sudoku {
    



    public static void solveSudoku(int[][] board, int i, int j, int count) {
        // write yopur code here
        if(count==board.length){
            display(board);
            return;
        }

        while(i<board.length){
            for(int row=i; row<board.length; row++){
                for(int col=j; col<board.length; col++){
                    for(int k=1; k<10;k++){
                        if(isSafeSudoku(board, row, col, k)){
                            board[row][col] = k;
                            solveSudoku(board, row, col+1, count+1);
                            board[row][col] = 0;
                        }
                    }
                }
            }
            j=0;
            i++;
        }
        

    }

    static boolean isSafeSudoku(int arr[][] , int row, int col, int val){
        for(int i=0;i<arr.length; i++){
            if(arr[row][i]==val)
                return false;
            if(arr[i][col]==val)
                return false;
        }
        int startRow = 3*(row/3);
        int startCol = 3*(col/3);
        for(int i= startRow; i<startRow+3; i++){
            for(int j= startCol; j<startCol+3; j++){
                if(arr[i][j]==val)
                    return false;
            }
        }
        return true;
    }   
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
          }
          System.out.println();
        }
    }


    public static void main(String[] args) {
        
    }
}
