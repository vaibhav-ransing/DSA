package Day4;
import java.util.ArrayDeque;

public class shortestBride934 {
    

    public static int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        boolean marked = false;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    BFS(grid, visited, i, j);
                    marked = true;
                    break;
                }
            }
            if(marked){break;}
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
        int ans = Integer.MAX_VALUE;
        ArrayDeque<pair2> queue = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    queue.add( new pair2(i, j, 1));
                }
            }
        }
        BFS_heler(grid, visited, queue);

        return ans;
    }

    static class pair2{
        int i;
        int j;
        int count;
        pair2(int i, int j, int count){
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }
    static int BFS_heler(int[][] grid,boolean[][] visited,ArrayDeque<pair2> queue){
        
        int dir[][] ={{1,0}, {0,1}, {-1,0},{0,-1}};
        while(queue.size()>0){
            pair2 peek = queue.pop();
            if(visited[peek.i][peek.j]) continue;
            visited[peek.i][peek.j] = true;
            for(int d=0; d<dir.length; d++){
                int ii = peek.i + dir[d][0];
                int jj = peek.j + dir[d][1];
                if(ii<0 || jj<0 || ii==grid.length || jj==grid[0].length)
                    continue;
                
                System.out.println(" -> "+grid[ii][jj]+" "+visited[ii][jj]+" -> "+ii+" "+jj);
                if(grid[ii][jj]==1 && visited[ii][jj]==false){
                    return peek.count;
                }
            }
        }
        return 0;
    }


    static int DFS(int[][] grid,boolean[][] visited, int row, int col ){
        if(row<0 || col<0 || row==grid.length || col==grid[0].length){
            return Integer.MAX_VALUE;
        }
        System.out.println(row+" "+col+" "+grid[row][col]+" "+visited[row][col]);
        if(visited[row][col]){
            if(grid[row][col]==1){
                System.out.println(row+" "+col);
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        visited[row][col] = true;
        int dir[][] ={{1,0}, {0,1}, {-1,0},{0,-1}};
        int val = Integer.MAX_VALUE;
        for(int d=0; d<dir.length; d++){
            int ii = row + dir[d][0];
            int jj = col + dir[d][1];
            // System.out.println("ij "+ii+" "+jj);
            int temp = DFS(grid, visited, ii, jj);
            val = Math.min(val, temp);
            
        }
        visited[row][col] = false;
        if(val!=Integer.MAX_VALUE){
            val+=1;
        }
        return val;

    }
    static class pair{
        int i;
        int j;
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static void BFS(int[][] grid,boolean[][] visited, int row, int col ){
        int n = grid.length;
        int m = grid[0].length;
        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(new pair(row, col));

        int dir[][] ={{1,0}, {0,1}, {-1,0},{0,-1}};
        while(queue.size()>0){
            pair peek = queue.pop();
            
            visited[peek.i][peek.j] = true;
            for(int d=0; d<dir.length; d++){
                int ii = peek.i + dir[d][0];
                int jj = peek.j + dir[d][1];
                if(ii<0 || jj<0 || ii==grid.length || jj==grid[0].length)
                    continue;
                if(grid[ii][jj]==1 && visited[ii][jj]==false){
                    queue.add(new pair(ii, jj));
                }
            }
        }
    }


    public static void main(String[] args) {
        // int grid[][] = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        // int grid[][] = {{0,0,0}, {1,0,0},{0,0,1}};
        int grid[][] = {{1,0},{0,1}};


        System.out.println(shortestBridge(grid));
    }
}
