public class numberOfEnclaves {
    
    // public boolean reduced = false;
    // public int count=0;
    // public int numIslands(int[][] grid) {
    //     boolean visited[][] = new boolean[grid.length][grid[0].length];
    //     count = 0;
    //     reduced = false;
    //     for(int i=0; i<grid.length; i++){
    //         for(int j=0; j<grid[0].length; j++){
    //             if(visited[i][j]==false && grid[i][j]=='1'){
    //                 count++;
    //                 helper(grid, visited, i, j);
    //             }
    //         }
    //     }
    //     return count;
    // }
    // public void helper(int[][] grid, boolean visited[][], int i, int j){
    //     if(i<0 || j<0 || i==grid.length || j==grid[0].length)  return;
    //     if(visited[i][j] || grid[i][j]==0)   return;
    //     visited[i][j]=true;
    //     if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
    //         if(reduced==false){
    //             count--;
    //             reduced = true;
    //         }
    //     }
    //     helper(grid, visited, i-1, j);
    //     helper(grid, visited, i+1, j);
    //     helper(grid, visited, i, j-1);
    //     helper(grid, visited, i, j+1);
    // }

    public int numEnclaves(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count=0;
        
        for(int i=0; i<grid.length; i++){
            helper(grid, visited, i, 0);
            helper(grid, visited, i, grid[0].length-1);
        }
        for(int j=0; j<grid[0].length-1; j++){
            helper(grid, visited, 0, j);
            helper(grid, visited, grid.length-1, j);
        }

        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                if(visited[i][j]==false && grid[i][j]==1){
                    count+=helper(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    static int helper(char[][] grid, boolean visited[][], int i, int j){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length)  return 0;
        if(visited[i][j] || grid[i][j]==0)   return 0;
        visited[i][j]=true;

        int l1= helper(grid, visited, i-1, j);
        int l2= helper(grid, visited, i+1, j);
        int l3= helper(grid, visited, i, j-1);
        int l4= helper(grid, visited, i, j+1);
        return 1+l1+l2+l3+l4;
    }




    public static void main(String[] args) {
        
    }
}
