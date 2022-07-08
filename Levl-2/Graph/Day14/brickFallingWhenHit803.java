import java.util.HashMap;
import java.util.HashSet;

public class brickFallingWhenHit803 {
    // https://leetcode.com/problems/bricks-falling-when-hit/


    public static int[] hitBricks(int[][] grid, int[][] hits) {
        int ans[] = new int[hits.length];
        visited = new int[grid.length][grid[0].length];
        
        for(int j=0; j<hits.length; j++){
            int hit[] = hits[j];
            int count = 0;
            grid[hit[0]][hit[1]]=0;
            for(int i=0; i<dir.length; i++){
                int r = dir[i][0]+hit[0];
                int c = dir[i][1]+hit[1];
                
                if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]==0){
                    continue;
                }
                int val = dfs(grid, r, c);
                if(val!=Integer.MIN_VALUE){
                    count+=val;
                }
            }
            ans[j] = count;
        }   
        return ans;
    }
    static int[][] dir = {{0,1} ,{1,0}, {0,-1}, {-1,0}};
    static int[][] visited;

    static int dfs(int[][] grid, int i, int j){
        if(i==0){
            return Integer.MIN_VALUE;
        }
        if(visited[i][j]==1){
            return 0;
        }

        visited[i][j]=1;
        int count=0;
        for(int[] d: dir){
            int r = d[0]+i;
            int c = d[1]+j;
            if(r<0 || c<0 || r==grid.length || c==grid[0].length){
                continue;
            }
            if(visited[r][c]==0 && grid[r][c]==1){
                int temp = dfs(grid, r, c);
                if(temp==Integer.MIN_VALUE){
                    return temp;
                }else{
                    count+=temp;
                }
            }
        }
        visited[i][j]=0;
        return count+1;
    }

    public static void main(String[] args) {
        // [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
        // int [][] grid = {{1,0,0,0},
        //                  {1,1,1,0}};
        // int hits[][] = {{1,0}};
        int [][] grid = {{1,0,0,0},
                         {1,1,0,0}};
        int hits[][] = {{1,0},{1,1}};
        hitBricks(grid, hits);
    }

}
