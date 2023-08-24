package DP.Day5;

public class MinCostPaintHouse {
    
    public static int minCost(int[][] cost) {
        // 14 2 11 
        // 11 14 5
        // 14 3 10
        // x  y  z
        int row = cost.length, col = cost[0].length;
        int[][] dp = new int[row+1][col+1];
        for(int i=row-1; i>=0; i--){
            dp[i][0] = cost[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

    public static void main(String[] args) {
        
    }
}
