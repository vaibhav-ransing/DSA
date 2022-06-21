public class editDistance {
    


    static void soln(String s1, String s2){
        int ans = recSoln(s1, s2, 0,0);
    }
    static int recSoln(String s1, String s2, int i, int j){

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if(c1==c2){
            return recSoln(s1, s2, i+1, j+1);
        }else{
            int del = recSoln(s1.substring(0,i)+s1.substring(i+1), s2, i, j);
            int insert = recSoln(s1.substring(0, i)+c2+s1.substring(i), s2, i+1, j+1);
            int replace = recSoln(s1, s2, i+1, j+1);
            int min = Math.min(del, Math.min(insert, replace));
            return min+1;
        }
    }
    static void dpSoln(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 && j==0){
                    dp[i][j]=0;
                }else if(i==0){
                    dp[i][j] = 1+dp[i][j-1];
                }else if(j==0){
                    dp[i][j] = 1+dp[i-1][j];
                }else{
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        int insert = dp[i][j-1];
                        int replace = dp[i-1][j-1];
                        int delete = dp[i-1][j];

                        int min = Math.min(insert, Math.min(replace, delete));
                        dp[i][j] = 1+min;
                    }
                }
            }
        }
        // return dp[s1.length()][s1.length()];
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }





    public static void main(String[] args) {
        dpSoln("pepperatcoding", "pepcoding");
    }
}
