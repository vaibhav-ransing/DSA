package QuestionsCSWMIK;

public class MinDaysToDisconnectIsland {

    public int minDays(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int flag = 0;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    if (flag == 1)
                        return 0;
                    flag++;
                    count = dfs(i, j, grid, vis);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int rem = Integer.MAX_VALUE;
                if (grid[i][j] == 1) {
                    rem = 0;
                    for(int[] d : dir){
                        int ii = i + d[0];
                        int jj = j + d[1];
                        if (ii < 0 || ii >= grid.length || jj < 0 || jj >= grid[0].length || grid[ii][jj] == 0){
                            continue;
                        }else{
                            rem++;
                        }
                    }
                }
                if(rem == 1 && count == 2) return 2;
                ans = Math.min(rem, ans);
            }
        }
        return ans;
    }

    int dir[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public int dfs(int i, int j, int[][] grid, boolean[][] vis) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        if (vis[i][j])
            return 0;
        vis[i][j] = true;
        int count = 0;
        for (int[] d : dir) {
            count += dfs(i + d[0], j + d[1], grid, vis);
        }
        return count;
    }

}