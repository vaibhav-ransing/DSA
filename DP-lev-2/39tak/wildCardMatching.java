public class wildCardMatching {
    
    static void solution(String s1, String s2){
        // baaabab    ba*a?
        int n1 = s1.length();
        int n2 = s2.length();
        boolean dp[][] = new boolean[n2+1][n1+1];
        dp[n2][n1] = true;
        for(int i=n2-1; i>=0; i--){
            for(int j=n1-1; j>=0; j--){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(i);
                if(c2=='*'){
                    for(int k=j; k<dp[0].length; k++){
                        dp[i][j] |=dp[i+1][k];
                    }
                }else if(c2=='?'){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j]= c2==c1?(true & dp[i+1][j+1]):false;
                }
            }
        }

        // for(boolean d[]: dp){
        //     for(boolean val: d){
        //         System.out.print(val==true?1+" ":0+" ");
        //     }
        //     System.out.println();
        // }
    }


    public static void main(String[] args) {
        solution("baaabab", "ba*a?");
    }
}
