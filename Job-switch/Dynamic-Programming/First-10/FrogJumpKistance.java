public class FrogJumpKistance {


    public static int soln(int n, int[] heights, int[] dp, int k) {
        if (n == 0) 
            return 0;

        if (dp[n] != Integer.MAX_VALUE)
            return dp[n];
            
        int minJump = Integer.MAX_VALUE;
        for(int j = 1; j<=k; j++){
            int jump = Integer.MAX_VALUE;
            if(n-j >=0)
                jump = soln(n-j, heights, dp, k) + Math.abs(heights[n-j] - heights[j]);
            minJump = Math.min(jump, minJump);
        }
        return minJump;
    }


    public static int IterativeSolution(int n, int[] heights, int k) {
        int dp[] = new int[n];
        dp[0] = 0;
        // this is to tell that I hav

        for (int i = 1; i < dp.length; i++) {
            int oneStepBack = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int twoStepBack = Integer.MAX_VALUE;
            if (i > 1) {
                twoStepBack = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(oneStepBack, twoStepBack);

        }
        return dp[heights.length - 1];

    }


    public static void main(String[] args) {
        
    }
}
