package CP.Dp.Day2;
// https://cses.fi/problemset/task/1725
public class DiceProb {

    public static double solution(int n, int sum, double dp[][]){
        if(n<0 || sum<0)
            return 0;
        if(sum==0 && n==0)
            return 1.0;
        double ans = 0;
        if(dp[n][sum]!=-1.0)    return dp[n][sum];

        for(int i=1; i<=6; i++){
            double prob = (1.0/6.0)*solution(n-1, sum-i, dp);
            ans+=prob;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=2, a = 9, b=10;
        double ans = 0;
        double dp[][] = new double[n+1][b+1];
        for(int i=0; i<dp.length; i++)
            for(int j=0; j<dp[0].length; j++)
                dp[i][j] = -1.0;
        for(int sum=a; sum<=b; sum++){
            ans+=solution(n, sum, dp);
        }
        System.out.println(ans);
    }
}
