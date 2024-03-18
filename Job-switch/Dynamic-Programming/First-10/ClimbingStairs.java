public class ClimbingStairs {

    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        return dpSolution(n, dp);
    }

    public static int dpSolution(int n, int dp[]) {
        if (n == 0 || n < 0) 
            return n == 0 ? 1 : 0;

        if(dp[n] != 0) return dp[n];
        
        return dp[n] = dpSolution(n - 1, dp) + dpSolution(n - 2, dp);
    }

    public static void main(String[] args) {
        // System.out.println(dpSolution(3));
    }
}
