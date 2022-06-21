public class palindromePartition {
    

    static void solution(String s){
        int n = s.length();
        int dp[][] = new int[n][n];
        
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; j<n; j++, i++){
                if(gap==0){
                    dp[i][j]=0;
                }else if(gap==1){
                    if(s.charAt(i)!=s.charAt(j))
                        dp[i][j]=1;
                }else{
					dp[i][j] = Integer.MAX_VALUE;
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==0)
                        dp[i][j] = dp[i+1][j-1];

					for(int k=i; k<j; k++){
						int val = dp[i][k]+dp[k+1][j]+1;
						dp[i][j] = Math.min(dp[i][j], val);
					}
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
    static boolean isPal(String s){
        for(int i=0, j=s.length()-1; i<=j; i++, j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }




    public static void main(String[] args) {
        solution("abccbc");
    }
}
