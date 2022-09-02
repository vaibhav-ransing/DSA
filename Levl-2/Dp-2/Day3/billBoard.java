package Day3;

public class billBoard {
    
    public static int solution(int m , int[] x, int[] rev, int t) {

        // 20
        // 5
        // 6 7 12 14 15
        // 5 8 5 3 1
        // 5

        int dp[] = new int[x.length];
        dp[0] = rev[0];
        for(int i=1; i<dp.length; i++){
            dp[i] = rev[i];
            for(int j=0; j<i; j++){
                int ld = x[j];
                if(ld+t <x[i]){
                    dp[i] = Math.max(dp[i], dp[j]+rev[i]);
                }
            }
        }
        int max = 0;
        for(int val: dp){
            max = Math.max(max, val);
        }
        return max;
    }

    public static int solution2(int m , int[] x, int[] rev, int t) {

        int dp[] = new int[m];
        int j=0;
        for(int i=0; i<dp.length; i++){
            if(j>=x.length){
                break;
            }
            if(x[j]==i){
                dp[i] = rev[j];
                if(i-t-1>=0)
                    dp[i] = Math.max(dp[i-t-1]+rev[j], dp[i]);
            }
            
        }
        return dp[dp.length-1];
    }



    public static void main(String[] args) {
        
    }
}
