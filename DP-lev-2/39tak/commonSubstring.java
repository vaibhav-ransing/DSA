public class commonSubstring {
    
    static void solution(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int max=0;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                dp[i][j] = c1==c2?1+dp[i-1][j-1]:0;
                max = Math.max(max, dp[i][j]);
            }
        }
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        System.out.println(max);
    }

    static void solution2(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int max=0;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                dp[i][j] = c1==c2?1+dp[i-1][j-1]:Math.max(dp[i-1][j], dp[i][j-1]);
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        solution("pqabcxy", "xyzabcp");
    }
}
