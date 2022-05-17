public class perfectSquare {
    
    static void solution(int n){
        int dp[] = new int[n+1];
        for(int i=1; i<dp.length; i++){
            int sq=1;
            dp[i] = i;
            while(i-(sq*sq)>=0){
                dp[i] = Math.min(dp[i], dp[i-(sq*sq)]);
                sq++;
            }
            dp[i]+=1;
        }
        // for(int val: dp)
        //     System.out.print(val+" ");
        System.out.println(dp[n]);
    }


    public static void main(String[] args) {
        solution(5);
    }
}
