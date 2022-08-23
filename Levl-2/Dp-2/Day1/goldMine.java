package Day1;

import java.util.Scanner;

public class goldMine {
    
    static void soln(int arr[][], int n, int m){
        int dp[][] = new int[n][m];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = arr[i][0];
        }
        for(int j=0; j<arr[0].length; j++){
            for(int i=0; i<arr.length; i++){


                if(i==0){
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j]+arr[i][j+1]);
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+arr[i+1][j+1]);
                }else if(i==arr.length-1){
                    dp[i-1][j+1] = Math.max(dp[i-1][j+1], dp[i][j]+arr[i-1][j+1]);
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j]+arr[i][j+1]);
                }else{
                    dp[i-1][j+1] = Math.max(dp[i-1][j+1], dp[i][j]+arr[i-1][j+1]);
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j]+arr[i][j+1]);
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+arr[i+1][j+1]);
                }
            }
        }
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                arr[i][j] = sc.nextInt();
        }
        // display(arr);
        soln(arr, n, m);

    }
}
