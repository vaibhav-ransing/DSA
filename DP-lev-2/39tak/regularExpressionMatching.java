public class regularExpressionMatching {
    
    static void solution(String p, String s){
        boolean dp[][] = new boolean[p.length()+1][s.length()+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){

                if(i==0 && j==0){
                    dp[i][j] = true;
                }else if(i==0){
                    dp[i][j] = false;
                }else if(j==0){
                    char ch = p.charAt(i-1);
                    dp[i][j] = ch=='*'?dp[i-2][j]:false;
                }else{
                    char pc = p.charAt(i-1);
                    char ch = s.charAt(j-1);
                    if(pc=='*'){    
                        dp[i][j] = dp[i-2][j];
                        char cw = p.charAt(i-2);
                        if(cw == ch || cw=='.'){
                            dp[i][j] =dp[i][j] || dp[i][j-1];
                        }
                    }else if(pc=='.'){      
                        dp[i][j] = dp[i-1][j-1];
                    }else if(pc==ch){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] =false;
                    }
                }
            }
        }
        // System.out.println(dp[dp.length-1][dp[0].length-1]);
          for(boolean d[]: dp){
            for(boolean val: d){
                System.out.print(val==true?1+" ":0+" ");
            }
            System.out.println();
        }

    }



    public static void main(String[] args) {
        solution("mis*i.*p*i", "mississippi");
    }
}
