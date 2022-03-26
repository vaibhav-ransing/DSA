public class minPalindromCut {
    
    static void rodCutting(int arr[]){
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i] = arr[i];
            for(int j=0; j<i;j++){
                int sum = 0;
                sum += dp[j];
                sum += dp[i-j-1];
                dp[i] = Math.max(dp[i], sum);
            }
        }
        for(int val: dp)
            System.out.print(val+" ");
    }

    static void display(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
    }
    static void countPalindromicSubsequences(String s){
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        
        for(int gap=0; gap<n;gap++){
            for(int i=0; i<n;i++){
                int j = i+gap;
                System.out.println(gap+" "+i+" "+j);
                if(j>=n)
                    break;
                if(i==j){
                    dp[i][j] = true;
                }else if(j-1==i){
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j] = true;
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }

        display(dp);
    }

    public static void main(String[] args) {
        // int arr[] = {1,5,8,9,10,17,17,20};
        // rodCutting(arr);
        countPalindromicSubsequences("aba");
    }
}
