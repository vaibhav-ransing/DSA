public class ValleysnMountains {
    
    static void catlanNo(int n){
         int dp[] = new int [n+1];
         n+=1;
         dp[0]=1;
         dp[1]=1;
         for(int i=2;i<n;i++){
             int start=0;
             int end= i-1;
             while(  start<i){
                 dp[i]+= dp[start]*dp[end];
                 end--;
                 start++;
             }
         }
            System.out.print(dp[dp.length-1]);
    }


    public static void main(String[] args) {
        catlanNo(4);
    }
}
