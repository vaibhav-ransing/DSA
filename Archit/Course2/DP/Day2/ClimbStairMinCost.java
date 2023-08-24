package DP.Day2;

import java.util.Arrays;

public class ClimbStairMinCost {
    
    // Recursion
    public int minCostClimbingStairsRec(int[] cost) {
        return Math.min(rec(0, cost.length, cost), rec(1, cost.length, cost));
    }

    public int rec(int src, int dest, int[] cost){
        if(src == dest) return 0;
        if(src > dest) return (int)1e7;

        int x = rec(src+1, dest, cost);
        int y = rec(src+2, dest, cost);

        return Math.min(x , y) + cost[src];
    }


    // DP

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+5];
        Arrays.fill(dp, -1);
        int x = DpMemo(0, cost.length, cost, dp);
        int y = DpMemo(1, cost.length, cost, dp);
        return Math.min(x, y);
    }

    public int DpMemo(int src, int dest, int[] cost, int[] dp){
        if(src == dest) return 0;
        if(src > dest) return (int)1e7;
        
        if(dp[src] != -1) return dp[src];

        int x = DpMemo(src+1, dest, cost, dp);
        int y = DpMemo(src+2, dest, cost, dp);

        return dp[src] =  Math.min(x , y) + cost[src];
    }

    public static void main(String[] args) {
        
    }
}
