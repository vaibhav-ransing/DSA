
public class MaxAreaIsland {

    boolean visited[][];

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j] ){
                    int cc = BFS(grid, i, j, 0);
                    count = Math.max(count, cc);
                }
            }
        }
        return count;
    }

    public int BFS(int[][] grid, int r, int c, int count) {
        if ( r < 0 || c < 0 || r >= grid.length || c >= grid[0].length 
                   || visited[r][c] || grid[r][c] == 0 ) {
            return 0;
        }
        visited[r][c] = true;

        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        
        for (int[] d : dir) {
            int rr = r + d[0];
            int cc = c + d[1];
            count += BFS(grid, rr, cc, count);
        }
        return count+1;
    }
}
