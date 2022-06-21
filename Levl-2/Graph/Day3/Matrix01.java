package Day3;
import java.util.ArrayDeque;

public class Matrix01 {
    
    static class pair{
        int i;
        int j;
        int count;
        pair(int i, int j, int count){
            this.i = i;
            this.j= j;
            this.count =count;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        ArrayDeque<pair> queue = new ArrayDeque<>();
        int[][] arr = new int[mat.length][mat[0].length];
        int[][] visited = new int[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0){
                    queue.add(new pair(i,j,0));
                }else{
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }
        } 
        int dir[][] ={{1,0}, {0,1}, {-1,0},{0,-1}};
        while(queue.size()>0){
            pair peek = queue.pop();
            
            visited[peek.i][peek.j] = 1;
            for(int m=0; m<dir.length; m++){
                int ii = peek.i + dir[m][0];
                int jj = peek.j + dir[m][1];
                if(ii<0 || jj<0 || ii==arr.length || jj==arr[0].length)
                    continue;
                if(mat[ii][jj]==1){
                    arr[ii][jj] = Math.min(arr[ii][jj], peek.count);
                    if(visited[ii][jj]==0){
                        queue.add(new pair(ii, jj, peek.count+1));
                    }
                }

            }
        }
        return arr;
    }


    public static void main(String[] args) {
        
    }
}
