public class numberOfIsland {
    


    // public int numIslands(char[][] grid) {
    //     boolean visited[][] = new boolean[grid.length][grid[0].length];
    //     int count=0;
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
    // static void helper(char[][] grid, boolean visited[][], int i, int j){
    //     if(i<0 || j<0 || i==grid.length || j==grid[0].length)  return;
    //     if(visited[i][j] || grid[i][j]=='0')   return;
    //     visited[i][j]=true;

    //     helper(grid, visited, i-1, j);
    //     helper(grid, visited, i+1, j);
    //     helper(grid, visited, i, j-1);
    //     helper(grid, visited, i, j+1);
    // }
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }
    static void helper(char[][] grid, int i, int j){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length)  return;
        if(grid[i][j]=='0')   return;
        grid[i][j]='0';
        helper(grid, i+1, j);
        helper(grid, i, j+1);
        helper(grid, i-1, j);
        helper(grid, i, j-1);
    }



    public static void main(String[] args) {
        
    }
}
