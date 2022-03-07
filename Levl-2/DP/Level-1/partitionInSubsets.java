import java.util.Scanner;

public class partitionInSubsets {
    
    static void dpSoln(int n, int k){
        long dp[][] = new long[k+1][n+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>i){
                    if(i==1)
                        dp[i][j] = 1;
                    else{
                        dp[i][j] = i*(dp[i][j-1]) + dp[i-1][j-1];
                    }
                }else if(i==j)
                    dp[i][j]=1;
            }
        }
        // display(dp);
        System.out.println((long) dp[dp.length-1][dp[0].length-1]);
    }   
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
    }


    public static void main(String[] args) {
        dpSoln(19, 4);
    }
}
