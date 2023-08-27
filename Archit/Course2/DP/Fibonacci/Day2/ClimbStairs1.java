package DP.Day2;

public class ClimbStairs1 {
    
    //  Recurions
    public int climbStairs(int n) {
        return rec(n);
    }

    public int rec(int n){
        if (n == 0) return 1;
        if (n < 0) return 0;

        return rec(n-1) + rec(n-2);
    }

    
    // Dp solution memo
    public int climbStairsDp(int n) {
        int[] dp = new int[n+1];
        return dpSoln(n, dp);
        
    }
    public int dpSoln(int n, int[] dp){
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n] != 0) return dp[n];
        return dp[n] = dpSoln(n-1, dp) + dpSoln(n-2, dp);
    }


    // Tabulation
    public int climbStairsDpTabulation(int dest) {
        int[] dp = new int[dest+2];
        return dpSolnTabulation(dest, dp);
    }

    public int dpSolnTabulation(int dest, int[] dp){
        dp[dest] = 1;
        for(int src = dest - 1; src >=0; src--){
            dp[src] = dp[src+1] + dp[src+2];
        }
        return dp[0];
    }

    public static void main(String[] args) {
    }
}
