package Questions;
import java.util.ArrayDeque;

public class distanceOfNearseCellHaving1 {
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ansMat = new int[n][m];

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    queue.add(new int[] {i, j, 1});  // row, col, time
                }
            }
        }

        while (queue.size() > 0) {
            
        }
    }

    public void fillQueue(int[][] mat){
        
    }
}
