class kanp{

    static int printMaxVal2(int wt[], int val[], int cw,  int n){

        if(n<=0 || cw==0)    
            return 0;
        int inc=0;
        if(cw-wt[n-1]>=0)
            inc= val[n-1]+printMaxVal2(wt, val, cw-wt[n-1],n-1);
        int exc = printMaxVal2(wt, val, cw, n-1);
        return Math.max(inc, exc);
    }

    static void dpSoln(int wt[], int val[], int w){
        int n = val.length;
        int dp[][] = new int[n+1][w+1];
        for(int i=0;i<n+1;i++)
            dp[i][0]=0;
        for(int i=0;i<w+1;i++)
            dp[0][i]=0;
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(wt[i-1]>j){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j-1]);

                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int val[] = {10,40,30,50};
        int wt[] = {5,4,6,3};
        int cw = 10;
        int n = val.length;
        dpSoln(wt, val, cw);
    }
}


    // static void dpSoln(int wt[], int val[], int w){
    //     int n = val.length;
    //     int dp[] = new int[w+1];

    //     for(int i=1;i<w+1;i++){
    //         for(int j=0;j<n;j++){
    //             if(i-wt[j]>=0){
    //                 dp[i] = Math.max(dp[i], val[j]+dp[i-wt[j]]);
    //             }
    //         }
    //     }
    //     for(int i=0;i<dp.length;i++)
    //         System.out.print(dp[i]+" ");
    // }
    