public class targetSumSubset {
    
    static void tss(int arr[], int n, int tar, String s){
        if(n==0){
            if(tar==0)
                System.out.println(s);
            return;
        }
        tss(arr, n-1, tar-arr[n-1],s+arr[n-1]+"-" );
        tss(arr, n-1, tar,s);
    } 

    static void dpSoln(int arr[], int tar){
        int dp[][] = new int[arr.length+1][tar+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]]==1){
                    // dp[i][j]=dp[i][j-arr[i-1]];
                    dp[i][j]=1;
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        display(dp);
        if(dp[dp.length-1][dp[0].length-1]==1)
            System.out.println(true);
        else
            System.out.println(false);

    }
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int tar=10;
        
        // int arr[] = {4,6,0,18,12,4,17,5,5,4,17,1,20,14};
        // int tar=3;
        
        // tss(arr, arr.length, tar, "");
        dpSoln(arr, tar);
    }

}
