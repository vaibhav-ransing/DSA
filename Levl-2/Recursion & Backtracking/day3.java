public class day3 {
    
    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // write your code here
        for(int i=col; i>=0;i--){
            if(chess[row][i])
                return false;
        }
        for(int i=row; i>=0;i--){
            if(chess[i][col])
                return false;
        }
        int r= row-1;
        int c = col-1;
        while(r>=0 && c>=0){
            if(chess[r][c])
                return false;
            r--;
            c--;
        }
        r = row+1;
        c= col-1;
        while(c>=0 && r<chess.length){
            if(chess[r][c])
                return false;
                r++;
                c--;
        }
        r = row-1;
        c= col+1;
        while(c<chess.length && r>=0){
            if(chess[r][c])
                return false;
            r--;
            c++;
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static boolean IsQueenSafePermu(int[][] chess, int row, int col) {
        // write your code here
        int n= chess.length;
        for(int i=col; i>=0;i--){
            if(chess[row][i]==1)
                return false;
        }
        for(int i=col+1; i<n;i++){
            if(chess[row][i]==1)
                return false;
        }

        for(int i=row; i>=0;i--){
            if(chess[i][col]==1)
                return false;
        }
        for(int i=row+1; i<n;i++){
            if(chess[i][col]==1)
                return false;
        }

        int r= row-1;
        int c = col-1;
        while(r>=0 && c>=0){
            if(chess[r][c]==1)
                return false;
            r--;
            c--;
        }
        r = row+1;
        c = col+1;
        while(r<n && c<n){
            if(chess[r][c]==1)
                return false;
            r++;
            c++;
        }


        r = row+1;
        c= col-1;
        while(c>=0 && r<chess.length){
            if(chess[r][c]==1)
                return false;
                r++;
                c--;
        }
        r = row-1;
        c= col+1;
        while(c<chess.length && r>=0){
            if(chess[r][c]==1)
                return false;
            r--;
            c++;
        }

        return true;
    }

    public static void nqueensPermu(int qpsf, int n, int[][] chess) {

        if(qpsf==n){
            for(int i=0;i<chess.length;i++){
                for(int j=0;j<chess.length;j++){
                    if(chess[i][j]==0){
                        System.out.println("-"+"\t");
                    }else{
                        System.out.println("q"+chess[i][j]+"\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
                if(chess[i][j]==0 && IsQueenSafePermu(chess, i, j)){
                    chess[i][j] = qpsf+1;
                    nqueensPermu(qpsf+1, n, chess);
                    chess[i][j] = 0;
                }
            }
        }
    }



    public static void main(String[] args) {
        
    }
}
