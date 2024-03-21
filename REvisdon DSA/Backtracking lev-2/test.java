class test {
    public void solveSudoku(char[][] board) {
        
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
        char[][] temp = {{'\0', '3'}, {'2','1'}};
        char ch = '3';
        int v = 3;
        System.out.println((int) ((ch)-'a'));
        System.out.println((int)ch==v);
      }
}