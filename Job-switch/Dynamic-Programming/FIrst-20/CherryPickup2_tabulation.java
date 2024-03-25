import java.util.Arrays;

public class CherryPickup2_tabulation {

    public int cherryPickup(int[][] grid) {
        return 0;
    }

    public int threeDTabulation(int[][] grid) {

        int n = grid.length;  // Changed from m to n
        int m = grid[0].length;  // Changed from n to m
    
        int dp[][][] = new int[n][m][m];  // Changed from m to n and n to m
    
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                dp[n-1][j1][j2] = j1 == j2 ? grid[n-1][j1] : grid[n-1][j1] + grid[n-1][j2];
                // we don't have to do max cause j1,j will always be different matrix and there
                // will be no repetition
            }
        }
    
        for (int i = n - 2; i >= 0; i--) {  // Changed from m - 2 to n - 2
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
    
                    int max = Integer.MIN_VALUE;

                    // int berries = 0;
                    // something is wrong
                    
                    for (int di = -1; di < 2; di++) {
                        for (int dj = -1; dj < 2; dj++) {
                            int ans = (j1==j2 ? grid[i][j1] : (grid[i][j1] + grid[i][j2]));

                            int val = Integer.MIN_VALUE;
                            if (j1 + di >= 0 && j1 + di < m && j2 + dj >= 0 && j2 + dj < m)
                                val = dp[i][j1 + di][j2 + dj];
                            ans += val;
                            max = Math.max(max, ans);

                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        System.out.println(Arrays.toString(dp[0][0]));
        return dp[0][0][m - 1];  // Changed from m - 1 to n - 1
    }

    
    // public int threeDTabulation(int[][] grid) {

    //     int m = grid.length;
    //     int n = grid[0].length;

    //     int dp[][][] = new int[m][n][n];

    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             dp[m-1][i][j] = i == j ? grid[m-1][i] : grid[m-1][i] + grid[m-1][j];
    //             // we don't have to do max cause i,j will always be different matrix and there
    //             // will be no repetetion
    //         }
    //     }

    //     for (int i = m - 2; i >= 0; i--) {
    //         for (int j1 = 0; j1 < n; j1++) {
    //             for (int j2 = 0; j2 < n; j2++) {

    //                 int berries = 0;
    //                 if (j1 == j2) {
    //                     berries += grid[i][j1];
    //                 } else {
    //                     berries += (grid[i][j1] + grid[i][j2]);
    //                 }

    //                 int max = 0;
    //                 for (int p1 = -1; p1 < 2; p1++) {
    //                     for (int p2 = -1; p2 < 2; p2++) {
    //                         int val = Integer.MIN_VALUE;
    //                         if (j1 + p1 >= 0 && j1 + p1 < n && j2 + p2 >= 0 && j2 + p2 < n)
    //                             val += dp[i][j1 + p1][j2 + p2];
    //                         max = Math.max(max, val);
    //                     }
    //                 }
    //                 dp[i][j1][j2] = berries + max;
    //             }
    //         }
    //     }

    //     return dp[0][0][m - 1];
    // }

    public static void main(String[] args) {

    }
}
