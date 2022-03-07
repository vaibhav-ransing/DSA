public class stairsMinMoves {
    
    static void dpStair(int arr[], int n){
        Integer dp[] = new Integer[n+1];
        dp[n] = 0;
        for(int i=n-1; i>=0;i--){
            if(arr[i]==0)
                continue;
            dp[i]=Integer.MAX_VALUE;
            for(int j=1; j<=arr[i]; j++){
                if(i+j<=n && dp[j+i]!=null)
                    dp[i] = Math.min(dp[i], dp[j+i]);
            }
            if(dp[i]!=Integer.MAX_VALUE)
                dp[i]++;
            else
                dp[i] = null;
        }
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        // System.out.println(dp[0]);
    }

    public static void main(String[] args) {
        
        // int arr[] = {3,2,4,2,0,2,3,1,2,2};
        int arr[] = {3,3,0,2,1,2,4,2,0,0};
        int n = arr.length;
        dpStair(arr, n);
    }
}
