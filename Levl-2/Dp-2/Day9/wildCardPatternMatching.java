package Day9;

public class wildCardPatternMatching {


    public boolean isMatch(String s, String p) {
        // lc-44
        int n = p.length();
        int m = s.length();
        
        
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                char sChar = s.charAt(j-1);
                char pChar = s.charAt(i-1);

                if(pChar=='*'){
                    if(dp[i][j-1]==true){
                        dp[i][j]=true;
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }else if(pChar=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = sChar==pChar;
                }
            }
        }
        for(boolean d[]: dp){
            for(boolean val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        return dp[n][m];
    }



    public static void main(String[] args) {
        
    }
}
