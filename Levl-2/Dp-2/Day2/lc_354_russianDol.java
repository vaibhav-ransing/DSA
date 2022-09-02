package Day2;

import java.util.Arrays;

public class lc_354_russianDol {
    public static class pair implements Comparable<pair>{
        int np;
        int sp;
        pair(int np, int sp){
            this.np = np;
            this.sp = sp;
        }
        public int compareTo(pair o){
            return this.np - o.np;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> Double.compare(a[0], b[0]));
        
        int dp[] = new int[envelopes.length];
        dp[0]=1;

        for(int i=1; i<envelopes.length; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0] ){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int val: dp){
            max = Math.max(max, val);
        }
        return max;
    }


    public static void main(String[] args) {
        
    }
}
