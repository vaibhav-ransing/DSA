package Day3;
import java.util.ArrayDeque;

import javax.xml.namespace.QName;

public class farFromLandLc1162 {
    

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
    public int solution(int[][] grid){
        int count = -1;
        ArrayDeque<pair> queue = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        boolean noWater = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    queue.add(new pair(i, j, 1));
                }else{
                    noWater = true;
                }
            }
        }
        if(noWater){
            return -1;
        }
        int dir[][] ={{1,0}, {0,1}, {-1,0},{0,-1}};
        while(queue.size() > 0){
            pair peek = queue.pop();
            visited[peek.i][peek.j] = true;
            for(int d=0; d<dir.length; d++){
                int ii = peek.i + dir[d][0];
                int jj = peek.j + dir[d][1];

                if(ii<0 || jj<0 || ii==n || jj==m){
                    continue;
                }
                if(grid[ii][jj]==0){
                    if(visited[ii][jj]==false){
                        count = Math.max(count, peek.count);
                    }
                    if(visited[ii][jj]==false){
                        queue.add(new pair(ii, jj, peek.count+1));
                    }
                }
            }
        }
        return count;
    }

    public int maxDistance(int[][] grid) {
        int count = -1;
        ArrayDeque<pair> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    queue.add(new pair(i,j,1));
                }
            }
        }  
        int dir[][] ={{1,0}, {0,1}, {-1,0},{0,-1}};
        while(queue.size()>0){
            pair peek = queue.pop();

            visited[peek.i][peek.j] = true;
            for(int m=0; m<dir.length; m++){
                int ii = peek.i + dir[m][0];
                int jj = peek.j + dir[m][1];
                if(ii<0 || jj<0 || ii==grid.length || jj==grid[0].length)
                    continue;
                if(grid[ii][jj]==0){
                    count = Math.max(count, peek.count);
                    if(visited[ii][jj]==false){
                        queue.add(new pair(ii, jj, peek.count+1));
                    }
                }
            }
        }
        return count;
    }




    public static void main(String[] args) {
        
    }
}
