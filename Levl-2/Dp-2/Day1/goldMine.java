package Day1;

import java.util.Scanner;

public class goldMine {

     static void Solution(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];
        for(int j=0; j<arr[0].length-1; j++){
            for(int i=0;i<dp.length;i++){
                if(j==0){
                    dp[i][j] = arr[i][j];
                }
                if(i==0){
                    dp[i][j+1] = Math.max(arr[i][j+1]+dp[i][j], dp[i][j+1]);
                    dp[i+1][j+1] = Math.max(arr[i+1][j+1]+dp[i][j], dp[i+1][j+1]);

                }else if(i==dp.length-1){
                    dp[i][j+1] = Math.max(arr[i][j+1]+dp[i][j], dp[i][j+1]);
                    dp[i-1][j+1] = Math.max(arr[i-1][j+1]+dp[i][j], dp[i-1][j+1]);
                }else{
                    dp[i-1][j+1] = Math.max(arr[i-1][j+1]+dp[i][j], dp[i-1][j+1]);
                    dp[i][j+1] = Math.max(arr[i][j+1]+dp[i][j], dp[i][j+1]);
                    dp[i+1][j+1] = Math.max(arr[i+1][j+1]+dp[i][j], dp[i+1][j+1]);
                }
            }
        }
        for(int a[]: dp){
            for(int val: a){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                arr[i][j] = sc.nextInt();
        }
        // display(arr);
        Solution(arr);

    }

}