package Day8;

import java.util.Arrays;

public class lc313_uglyNo {
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int dp[] = new int[n+1];
        dp[1] = 1;

        int[] idces = new int[primes.length];
        Arrays.fill(idces, 1);
        for(int i=2; i<dp.length; i++){
            long ans = Integer.MAX_VALUE;
            for(int j=0; j<idces.length; j++){
                int prime = primes[j];
                int idx = idces[j];
                ans = Math.min(ans, prime*idx);
            }
            dp[i] = (int)ans;
            for(int j=0; j<idces.length; j++){
                int prime = primes[j];
                int idx = idces[j];
                if(prime*idx ==ans){
                    idces[j]++;
                }
            }

        }
        return dp[n];
    }



    public static void main(String[] args) {
        
    }
}
