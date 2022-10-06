package Day9;

public class longestRepeatingSubSeq {
    

    public int LongestRepeatingSubsequence(String str){
        int n = str.length();
        int dp[][] = new int[n+1][n+1];
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp.length; j++){
                int ci=str.charAt(i-1);
                int cj = str.charAt(j-1);
                if(ci==cj && i!=j){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }





    public static void main(String[] args) {
        
    }
}
