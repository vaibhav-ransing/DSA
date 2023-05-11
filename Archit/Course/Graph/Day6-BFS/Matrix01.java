
// https://leetcode.com/problems/01-matrix/description/

import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix01 {
    
    int[][] dir = {{0,1},{0,-1}, {1,0}, {-1,0}};
    boolean[][] visited;
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        visited = new boolean[n][m];
        int[][] ans = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = (mat[i][j] == 0);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    ans[i][j] =  BFS(ans, mat, i, j);
                }
            }
        }
        return ans;
    }

    class Pair{
        int row; int col; int wt;

        Pair(int row, int col, int wt){
            this.row = row;
            this.col = col;
            this.wt = wt;
        }
    }

    public int BFS(int[][] ans, int[][] mat, int i, int j){

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(i, j, 0));

        while(queue.size() > 0){
            Pair peek = queue.remove();
            
            if(mat[peek.row][peek.col] == 0){
                System.out.println("Zero Found "+ peek.row +" "+ peek.col);
                return peek.wt;
            } 
            if(ans[i][j] != 0) {
                System.out.println("Visited "+ i +" "+ j+" -- "+ peek.wt +" " + ans[i][j]);
                return peek.wt + ans[i][j];
            }

            visited[peek.row][peek.col] = true;

            for(int[] d : dir){
                int ii = peek.row + d[0];
                int jj = peek.col + d[1];
                if(ii < 0 || jj < 0 || ii == mat.length || jj == mat[0].length) continue;
                queue.add(new Pair(ii, jj, peek.wt + 1));
            }
        }

        return -1;
    }
    
    


    public static void main(String[] args) {
        
    }
}
