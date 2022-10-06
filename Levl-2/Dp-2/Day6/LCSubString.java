package Day6;

public class LCSubString {
    

    static int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int dp[][] = new int[n+1][m+1];
        int max=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                char c1 = S1.charAt(i-1);
                char c2 = S2.charAt(j-1);
                dp[i][j] = c1==c2? dp[i-1][j-1]+1:0;
                max = Math.max(max, dp[i][j]);
            }
        }
        for(int d[]:dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        return max;
    }
    public static void main(String[] args) {
        longestCommonSubstr("adac", "adadac", 4 , 6);
    }
}
