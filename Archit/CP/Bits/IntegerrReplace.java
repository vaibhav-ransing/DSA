package CP.Bits;

public class IntegerrReplace {
    

    public static int integerReplacement(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            if((i&1)==0){
                //even
                dp[i] = dp[i/2]+1;
            }else{
                int left = dp[i-1]+1;
                int right = dp[(i+1)/2]+1;
                dp[i] = Math.min(left, right);
            }
        }
        for(int val: dp){
            System.out.print(val+" ");
        }
        return dp[n];
    }

    public static void main(String[] args) {
        integerReplacement(8);
    }

}
