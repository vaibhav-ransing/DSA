public class terst{

    static int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        if(s.charAt(0)!='0')
            dp[1]=1;
        dp[0]=1;

        for(int i=2;i<dp.length;i++){
            int together = Integer.parseInt(s.substring(i-2, i));
            if(s.charAt(i-1)=='0'){
                if(together<=20 && together/10 !=0){
                    if(s.length()!=i)
                        dp[i]+=dp[i-1]-1;
                    else
                        dp[i] = dp[i-1];
                }
            }else{
                dp[i] = dp[i-1];
                if(together<=26 && together/10 !=0){
                    dp[i]+=dp[i-2];
                }
            }
        }
        // for(int i=0; i<dp.length;i++)
        //     System.out.print(dp[i]+" ");
        return dp[dp.length-1];
    }
    
    static void robber(int arr[]){
        int dp[][] = new int[2][arr.length+1];
        
        for(int i=1;i<dp[0].length;i++){
            dp[0][i] = arr[i-1]+dp[1][i-1];
            dp[1][i] = dp[0][i-1];
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        int a = dp[0][dp[0].length-1];
        int b = dp[1][dp[0].length-1];
        System.out.println(Math.max(a, b));
    }
    
    static int robberDp(int arr[], int index, boolean prev, int ans, int dp[]){
        if(index==arr.length)
            return ans;
        if(dp[index]!=0)
            return dp[index];
        if(prev==false){
            int a = robberDp(arr, index+1, true, ans+arr[index],dp);
            int b = robberDp(arr, index+1, false, ans,dp);
            System.out.println(a+" "+b+" "+ans);
            dp[index] = Math.max(dp[index], Math.max(a, b));
            return Math.max(a, b);
        }else{
            int a= robberDp(arr, index+1, false, ans,dp);
            dp[index] = Math.max(dp[index], Math.max(a, ans));
            System.out.println("ans "+a+" "+ans);
            return Math.max(a, ans);
        }
    }
    public static void main(String[] args) {
        // System.out.println(numDecodings("ABC"));
        // System.out.println(numDecodings("12"));
        // numDecodings("1123");
        // int arr[] = {2,7,9,3,1};
        int arr[] = {1,2};
        int dp[] = new int[arr.length];
        System.out.println(robberDp(arr, 0, false, 0, dp));
    }
}