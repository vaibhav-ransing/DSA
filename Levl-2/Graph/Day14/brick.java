import java.util.HashMap;

public class brick {
    // https://leetcode.com/problems/bricks-falling-when-hit/


    public static int[] hitBricks(int[][] grid, int[][] hits) {
        int ans[] = new int[hits.length];
        visited = new int[grid.length][grid[0].length];
        map = new HashMap<>();
        for(int h[]: hits){
            map.put(h[0], h[1]);
        }
        System.out.println("//////");
        for(int val: map.keySet()){
            System.out.println(val+" "+map.get(val));
        }
        System.out.println("//////");
        for(int j=0; j<hits.length; j++){
            int hit[] = hits[j];
            int count = 0;
            for(int i=0; i<dir.length; i++){
                int r = dir[i][0]+hit[0];
                int c = dir[i][1]+hit[1];
                if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]==0){
                    continue;
                }
                visited[hit[0]][hit[1]] = 1;
                int val = dfs(grid, r, c);
                System.out.println("val "+val+" "+r+" "+c);
                if(val!=Integer.MIN_VALUE){
                    count+=val;
                }
                visited[hit[0]][hit[1]] = 0;
            }
            ans[j] = count;
        }   
        System.out.println("-----");
        System.out.println(ans[0]+" -> "+ans[1]);
        return ans;
    }
    static int[][] dir = {{0,1} ,{1,0}, {0,-1}, {-1,0}};
    static int[][] visited;
    static int hitCount=0;
    static HashMap<Integer,Integer> map;

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
                System.out.println(temp+" "+r+" "+c);
                if(temp==Integer.MIN_VALUE){
                    return temp;
                }else{
                    count+=temp;
                }
            }
        }
        boolean isHitBrick = false;
        if(map.containsKey(i)){
            if(map.get(i)==j){
                isHitBrick = true;
            }
        }
        System.out.println(isHitBrick+" "+i+" "+j);
        visited[i][j]=0;
        return isHitBrick?count:count+1;
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
