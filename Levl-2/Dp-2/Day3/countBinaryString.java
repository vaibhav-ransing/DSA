package Day3;

import java.util.Scanner;

public class countBinaryString {
    
    static void solution(int n){
        int dp[][] = new int[2][n+1];
        dp[0][1]=1;
        dp[1][1]=1;
        for(int i=2; i<=n; i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[0][i-1] + dp[1][i-1];
        }
        int ans = dp[0][n]+dp[1][n];
        System.out.println(ans);
    }



    public static void main(String[] args) {
        // Scanner snc = new Scanner(System.in);
        // int n  = snc.nextInt();
        // solution(n);
        solution(6);
    }
}
