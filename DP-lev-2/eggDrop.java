public class eggDrop {
    

    static void solution(int n, int k){
        int dp[][] = new int[n+1][k+1];
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(i==1) dp[i][j] = j;
                else if(j==0 || j==1) dp[i][j]=j;
                else{   
                    int min = Integer.MAX_VALUE;
                    for(int r=j-1, l=0; r>=0; r--,l++){
                        int brs = dp[i][r];
                        int sur = dp[i-1][l];
                        min = Math.min(min, Math.max(brs, sur));
                    }
                    dp[i][j]= min+1;
                }
            }
        }
        // return dp[n][k]
    }
    static int helper(int egg, int floor){
        if(floor==0 || floor==1) return floor;
        if(egg==1)  return floor;

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=floor; i++){
            int breaks = helper(egg-1, i-1);
            int dont = helper(egg, floor-i);
            ans = Math.min(ans,1+Math.max(breaks, dont));
        }
        return ans;
    }





    public static void main(String[] args) {
        
    }
}
