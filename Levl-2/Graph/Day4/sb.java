package Day4;

import java.util.ArrayDeque;

public class sb {
    
    public static int shortestBridge(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];

        ArrayDeque<pair> queue = new ArrayDeque<>();
        boolean marked = false;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    queue.add(new pair(i, j));
                    BSF_Helper(grid, visited, queue);
                    marked = true;
                    break;
                }
            }
            if(marked){break;}
        }

        queue = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    queue.add(new pair(i, j));
                }
            }
        }
        int ans =  BFS(grid, visited, queue);
        return ans-1;
    }

    static int BFS(int[][] grid, int[][] visited, ArrayDeque<pair> queue){
        int ans = 0;
        int dir[][] ={{1,0}, {0,1}, {-1,0},{0,-1}};
        while(queue.size()>0){
            pair peek = queue.pop();
            if(visited[peek.i][peek.j]==1){
                ans = peek.count;
                break;
            }
            if(visited[peek.i][peek.j]==2){
                continue;
            } 
            visited[peek.i][peek.j] = 2;
            for(int d=0; d<dir.length; d++){
                int ii = peek.i + dir[d][0];
                int jj = peek.j + dir[d][1];
                if(ii<0 || jj<0 || ii==grid.length || jj==grid[0].length)
                    continue;
                pair temp = new pair(ii, jj);
                temp.count = peek.count+1;
                queue.add(temp);
            }
        }
        return ans;
    }
    static class pair{
        int i;
        int j;
        int count;
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static void BSF_Helper(int[][] grid, int[][] visited, ArrayDeque<pair> queue){
        int dir[][] ={{1,0}, {0,1}, {-1,0},{0,-1}};
        while(queue.size()>0){
            pair peek = queue.pop();
            if(visited[peek.i][peek.j]==1) continue;
            visited[peek.i][peek.j] = 1;
            for(int d=0; d<dir.length; d++){
                int ii = peek.i + dir[d][0];
                int jj = peek.j + dir[d][1];
                if(ii<0 || jj<0 || ii==grid.length || jj==grid[0].length)
                    continue;
                if(grid[ii][jj]==1 && visited[ii][jj]==0){
                    queue.add(new pair(ii, jj));
                }
            }
        }
    }
    


    public static void main(String[] args) {
        int grid[][] = {{1,0},{0,1}};
        shortestBridge(grid);
    }   
}
