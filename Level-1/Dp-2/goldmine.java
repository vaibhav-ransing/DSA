public class goldmine {
    
    static void soln(int[][] arr, int n, int m){
        int dp[][] = new int[n][m];

        for(int j=m-1; j>=0;j--){
            for(int i=0;i<n;i++){
                if(j==m-1){
                    dp[i][j] = arr[i][j];
                }else{
                    dp[i][j] = arr[i][j];
                    if(i==0 && i+1<n){
                        dp[i][j] += Math.max(dp[i][j+1], dp[i+1][j+1]);
                    }else if(i==n-1 && i-1>=0){
                        dp[i][j] += Math.max(dp[i][j+1], dp[i-1][j+1]);
                    }else{
                        dp[i][j] += Math.max(dp[i+1][j+1], Math.max(dp[i][j+1], dp[i-1][j+1]));
                    }
                }
            }
        }
        // display(dp);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp[i][0]);
        }
        System.out.println(max);

    }

    static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = 
                        {{0, 1, 4, 2, 8, 2},
                        {4, 3, 6, 5, 0, 4},
                        {1, 2, 4, 1, 4, 6},
                        {2, 0, 7, 3, 2, 2},
                        {3, 1, 5, 9, 2, 4},
                        {2, 7, 0, 8, 5, 1}};
        // soln(arr, arr.length, arr.length);

    }   
}
