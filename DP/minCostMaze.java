public class minCostMaze {
    
    static int minRec(int arr[][], int n, int m){

        if(n==arr.length-1 && m==arr[0].length-1)
            return 0;
        int moveR= Integer.MAX_VALUE;
        int moveD= Integer.MAX_VALUE;
        
        if(m+1<arr[0].length)
            moveR= arr[n][m+1] + minRec(arr, n, m+1);
        if(n+1<arr.length) 
            moveD= arr[n+1][m] + minRec(arr, n+1, m);
        
        return Math.min(moveR, moveD);
    }

    static void minDP(int arr[][], int n, int m){
        int dp[][] = new int[n][m];
        dp[n-1][m-1]=arr[n-1][m-1];

        for(int i=n-1; i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1)
                    continue;
                int moveR= Integer.MAX_VALUE;
                int moveD= Integer.MAX_VALUE;
                if(j+1<arr[0].length)
                    moveR= arr[i][j] + dp[i][j+1];
                if(i+1<arr.length)
                    moveD = arr[i][j] + dp[i+1][j];
                dp[i][j] = Math.min(moveD, moveR);
                
            }
        }
         
        // display(dp);
        System.out.println(dp[0][0]);
    }
    static void minDP2(int arr[][], int n, int m){
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
         
        // display(dp);
        System.out.println(dp[0][0]);
    }
    static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){ 
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
            
    }


    public static void main(String[] args) {
        int n=0;
        int m=0;
        // int arr[][] = { {0,1,4,2,8,2},
        //                 {4,3,6,5,0,4},
        //                 {1,2,4,1,4,6},
        //                 {2,0,7,3,2,2},
        //                 {3,1,5,9,2,4},
        //                 {2,7,0,8,5,1} };
        int arr[][] = { {2,8,4,1,6,4,2},
                        {6,0,9,5,3,8,5},
                        {1,4,3,4,0,6,5},
                        {6,4,7,2,4,6,1},
                        {1,0,3,7,1,2,7},
                        {1,5,3,2,3,0,9},
                        {2,2,5,1,9,8,2} };
        // int arr[][] = { {0,1,4,2},
        //                 {4,3,6,5},
        //                 {1,2,4,1},
        //                 {2,0,7,3}};
        // System.out.println(minRec(arr, n, m));
        // System.out.println(count(arr, n, m, 0, ""));

        minDP2(arr,arr.length, arr.length);
    }
}
