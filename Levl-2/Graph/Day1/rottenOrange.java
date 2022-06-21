import java.util.ArrayDeque;
import java.util.Queue;

public class rottenOrange {
    
    public static int orangesRotting2(int[][] grid) {
        int count=0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(visited[i][j]==false && grid[i][j]==2){
                    count = Math.max(count, helper(grid, visited, i, j));
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.println(grid[i][j]+" "+visited[i][j]);
                if(visited[i][j]==false && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return count==0?0:count-1;
    }
    static int helper(int [][] grid, boolean visited[][], int i, int j){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length)  return 0;
        if(visited[i][j] || grid[i][j]==0  )   return 0;
        visited[i][j]=true;
        int l1= helper(grid, visited, i-1, j);
        int l2= helper(grid, visited, i+1, j);
        int l3= helper(grid, visited, i, j-1);
        int l4= helper(grid, visited, i, j+1);
        return 1+ Math.max(Math.max(l1, l2), Math.max(l3, l4));
    }

    class Solution {
        class Pair{
            int i,j,t;
            Pair(int i,int j,int t){
                this.i = i; this.j = j; this.t = t;
            }
        }
        public int orangesRotting(int[][] grid) {
            Queue<Pair> que = new ArrayDeque();
            int n = grid.length , m = grid[0].length;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(grid[i][j]==2){
                        que.add(new Pair(i,j,0));
                        grid[i][j] = 0;
                    }
                }
            }
            int ans = 0;
            int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
            while(que.size()>0){
                Pair pair = que.remove();
                ans = pair.t;
                for(int i=0;i<dir.length;i++){
                    int ii = pair.i + dir[i][0];
                    int jj = pair.j + dir[i][1];
                    if(ii<0 || jj<0 || ii>=n || jj>=m || grid[ii][jj]==0){
                        continue;
                    }
                    
                    grid[ii][jj] = 0;
                    que.add(new Pair(ii,jj,pair.t+1));
                }
            }
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(grid[i][j]==1){
                        return -1;
                    }
                }
            }
            return ans;
        }
    }


    class pair{
        int i;
        int j;
        int t;
        pair(int i, int j, int t){
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid){
        ArrayDeque<pair> queue = new ArrayDeque<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new pair(i, j, 0));
                }
            }
        }
        int t = 0;
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while(queue.size()>0){
            
            pair peek = queue.pop();
            t = Math.max(t, peek.t);
            for(int i=0; i<dir.length; i++){
                int ii = peek.i+dir[i][0];
                int jj = peek.j+dir[i][1];
                if(ii<0 || jj<0 || ii==grid.length || jj==grid[0].length)
                    continue;
                if(grid[ii][jj]==1){
                    grid[ii][jj]=0;
                    queue.add( new pair(ii, jj, peek.t+1));
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return t;
    }   



    public static void main(String[] args) {
        // int arr[][] = {{2,1,1},{0,1,1},{1,0,1}};
        // [[2,1,1],[1,1,1],[0,1,2]]
        int arr[][] = {{0}};
        // System.out.println(orangesRotting(arr));
    }
}
