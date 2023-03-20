package CP.RangeQueries.Day1;

class NumMatrix {

    public int[][] dp;
    // public NumMatrix(int[][] arr) {
    //     int n = arr.length;
    //     int m = arr[0].length;
    //     dp = new int[n][m];
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(j==0)
    //                 dp[i][j] = arr[i][j];
    //             else
    //                 dp[i][j] = arr[i][j] + dp[i][j-1];
    //         }
    //     }
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<n; j++){
    //             System.out.println(dp[i][j]);
    //         }
    //     }
    // }
    
    public int sumRegion2(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if(col1==0){
            for(int i=row1; i<=row2; i++){  
                sum+= dp[i][col2];  
            }   
        }else{  
            for(int i=row1; i<=row2; i++){  
                sum+= dp[i][col2] - dp[col1-1][i];      
            }       
        }       
        return sum;     
    }       


    public NumMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        dp = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = arr[i][j];
                if(j!=0)
                    dp[i][j] += dp[i][j-1];
                if(i!=0)
                    dp[i][j] += dp[i-1][j];
                if(j!=0 && i!=0)
                    dp[i][j] -= dp[i-1][j-1];
            }   
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {  
        // int ans = dp[row2][col2];
        // if(col1>0) ans -= dp[row2][col1-1];
        // if(row1>0) ans -= dp[row1-1][col2];
        // if(col1>0 && row1>0) ans+= dp[row1-1][col1-1];

        // return ans;
        if(row1==0 && col1==0){
            return dp[row2][col2];
        }else if(row1==0){
            return dp[row2][col2] - dp[row2][col1-1];
        }else if(col1==0){
            return dp[row2][col2] - dp[row1-1][col2];
        }else{
            return dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1-1] + dp[row1-1][col1-1];
        }
    }   
}   