public class minCoins {
    // minimum coins to make a value 
    // eg 30 = 25+5  , 30= 5+5+5+5..  op=2

    static int minC(int arr[],int n, int val){
        if(val<0)
            return Integer.MAX_VALUE;
        if(val==0)
            return 0;
        if(n==0 && val!=0)
            return Integer.MAX_VALUE;
        int inc =  1+minC(arr, n, val-arr[n-1]);
        int exc = minC(arr, n-1, val);
        return Math.min(inc, exc);
    }

    static void dp(int arr[], int val){
        int n = arr.length;
        int dp[] = new int[val+1];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            dp[i] =val;
            for(int j=0;j<arr.length;j++){
                if(i-arr[j]>=0 && dp[i-arr[j]]!=-Integer.MIN_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-arr[j]]+1);
            }
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
            System.out.println();
        System.out.println(dp[dp.length-1]);

    }
    public static void main(String[] args) {
        // int arr[] = {25,10,5};
        int arr[] = {1,1,1};
        int val = 17;
        int n = arr.length;
        // System.out.println(minC(arr, n, val));
        dp(arr, val);
        // System.out.println(Integer.MIN_VALUE-1);
    }
}
