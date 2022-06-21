public class longestRepeatingSubseq {
    


    static void solution(String s){
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp.length; j++){
                char ci = s.charAt(i-1);
                char cj = s.charAt(j-1);

                if(ci==cj && i!=j){
                    dp[i][j]+=1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }



    public static void main(String[] args) {
        
    }
}
