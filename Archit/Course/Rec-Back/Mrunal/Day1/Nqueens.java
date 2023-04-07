import java.util.ArrayList;
import java.util.List;

public class Nqueens {
    
    static int[] leftDiagonal;
    static int[] rightDiagonal;
    static int[] column;
    static List<List<String>> list;
    
    public static void solution(int[][] chess){
        int n = chess.length;
        leftDiagonal = new int[2*n-1];
        rightDiagonal = new int[2*n-1];
        column = new int[n];
        list = new ArrayList<>();
        BB(chess, 0);
    }

    public static List<List<String>> solveNQueens(int n) {
        int chess[][] = new int[n][n];
        solution(chess);
        return list;
    }

    public static void BB(int[][] chess, int r){
        if(r==chess.length){
            List<String> nqueenAns = new ArrayList<>(); 
            for(int i=0; i<chess.length; i++){
                StringBuilder colStr = new StringBuilder();
                for(int j=0; j<chess.length; j++){
                    if(chess[i][j]==1){
                        colStr.append("Q");
                    }else{
                        colStr.append(".");
                    }
                }
                nqueenAns.add(colStr.toString());
            }
            list.add(nqueenAns);
            return;
        }
        for(int col=0; col<chess.length; col++){
            if(column[col]==0 && leftDiagonal[r+col]==0 && rightDiagonal[(r-col)+chess.length-1]==0){
                column[col]=1;
                leftDiagonal[r+col]=1;
                rightDiagonal[(r-col)+chess.length-1]=1;
                chess[r][col] = 1;

                BB(chess, r+1);
                
                chess[r][col] = 0;
                column[col]=0;
                leftDiagonal[r+col]=0;
                rightDiagonal[(r-col)+chess.length-1]=0;
            }
        }
    }   


    public static void main(String[] args) {
        int[][] chess = new int[4][4];
        solution(chess);
    }
}
