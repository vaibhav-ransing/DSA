import java.util.Arrays;

public class GridUniquePathObstacle {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        int ans = recursion(0, 0, dp, obstacleGrid);
        System.out.println(ans);
        return ans;
    }

    static int[][] dir = { { 0, 1 }, { 1, 0 } }; // , { 0, -1 }, { -1, 0 }

    public static int recursion(int row, int col, int[][] dp, int[][] obstacleGrid) {
        if (row == dp.length - 1 && col == dp[0].length - 1) {
            return obstacleGrid[row][col] == 0 ? 0 : 1;
        }

        if (row < 0 || row >= dp.length || col < 0 || 
                col >= dp[0].length || obstacleGrid[row][col] == 1)
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];

        int count = 0;

        for (int d[] : dir) {
            int rr = row + d[0];
            int cc = col + d[1];
            count += recursion(rr, cc, dp, obstacleGrid);
        }
        return dp[row][col] = count;
    }

    public static void main(String[] args) {
        
    }
}