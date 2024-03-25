import java.util.Arrays;

public class FibonacciNo {


    public static int soln(int n, int dp[]){
        if(n==1 || n==2){
            return 1;
        }
        if(dp[n] != 0)
            return dp[n];

        if(n==0)
            return 0;
        return dp[n] = soln(n-1, dp) + soln(n-2, dp);
    }

    public static void main(String[] args) {
        int n = 5 ;
        int dp[] = new int[n+1];
        System.out.println(soln(n, dp));
        System.out.println(Arrays.toString(dp));
    }

}