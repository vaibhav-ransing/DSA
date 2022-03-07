public class minCostMaze {
    
    static void minDP(int arr[][], int n, int m){
        int dp[][] = new int[n][m];
        dp[n-1][m-1]=arr[n-1][m-1];

        for(int i=n-1; i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1)
                    dp[i][j] = arr[i][j];
                else if(i==n-1)
                    dp[i][j]=dp[i][j+1]+arr[i][j];
                else if(j==m-1)
                    dp[i][j]=dp[i+1][j]+arr[i][j];
                else{
                    dp[i][j]= Math.min(dp[i+1][j], dp[i][j+1]) +arr[i][j];
                }
                
            }
        }
         
        System.out.println(dp[0][0]);
    }

    static void minCostMazeSoln(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = arr[n-1][m-1];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1; j>=0;j--){
                if(i==n-1 && j==m-1){
                    dp[i][j] = arr[i][j];
                }
                else if(i==n-1){
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                }
                else if(j==m-1){
                    dp[i][j] = dp[i+1][j] + arr[i][j];
                }
                else{
                    dp[i][j] = arr[i][j];
                    dp[i][j] += Math.min(dp[i+1][j], dp[i][j+1]);
                    
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[0][0]);
    }


    public static void main(String[] args) {
        int arr[][] =  {{ 0 ,1, 4, 2, 8 ,2},
                        {4, 3 ,6 ,5 ,0,4},
                       { 1 ,2, 4 ,1, 4 ,6},
                        {2 ,0 ,7 ,3, 2, 2},
                       { 3 ,1, 5, 9 ,2, 4},
                       { 2, 7, 0, 8, 5,1}};
        minCostMazeSoln(arr);
            
    }
}
