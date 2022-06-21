public class LCS {
    
    static void solution(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<dp.length; i++){
            boolean added = false;
            for(int j=1; j<dp[0].length; j++){
                int left = dp[i][j-1];
                int right = dp[i-1][j];
                dp[i][j] += Math.max(left, right);
                if(s1.charAt(i-1)==s2.charAt(j-1) && added==false){
                    dp[i][j]+=1;
                    added = true;
                }
            }
        }

        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    static void copySon(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
                
            }
        }
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    static void pepSoln(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for(int i=dp.length-2; i>=0; i--){
            for(int j=dp[0].length-2; j>=0; j--){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if(c1==c2){
                    dp[i][j] = 1+dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // pepSoln("cabg", "dgbabfgg");
        // copySon("cba", "aecb");
        // pepSoln("cba", "aecb");
        pepSoln("cba", "abcd");
        
    }
}
