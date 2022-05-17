public class catlanNo {
    
    static void soln(int n){
        int dp[] = new int[n];
        dp[0]=dp[1]=1;
        for(int i=2;i<dp.length;i++){
            int start=0;
            int end = i-1;
            while(start<i){
                dp[i]+=dp[start]*dp[end];
                start++;
                end--;
            }
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }

    public static void main(String[] args) {
        soln(7);
    }
}
