public class goldMine {
    
    static void dp(int arr[][]){
        int n=  arr.length;
        int m = arr[0].length;
        
        int dp[][]= new int[n][m];

        for(int i=0; i<n; i++)
            dp[i][m-1] = arr[i][m-1];
        
        for(int j=m-2;j>=0;j--){
            for(int i=0;i<n;i++){
                if(i-1>=0 && j+1<m)
                    dp[i][j]= Math.max(dp[i][j], dp[i-1][j+1]);
                if(j+1<m)
                    dp[i][j]= Math.max(dp[i][j], dp[i][j+1]);
                if(i+1<n && j+1<m)
                    dp[i][j]= Math.max(dp[i][j], dp[i+1][j+1]);
                dp[i][j]= dp[i][j]+arr[i][j];
            }
        }
        // display(dp);
        int max=0;
        for(int i=0; i<n;i++)
            max= Math.max(max, dp[i][0]);
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
        int arr[][] = { {0,1,4,2,8,2},
                        {4,3,6,5,0,4},
                        {1,2,4,1,4,6},
                        {2,0,7,3,2,2},
                        {3,1,5,9,2,4},
                        {2,7,0,8,5,1}};
        dp(arr);
    }
}
