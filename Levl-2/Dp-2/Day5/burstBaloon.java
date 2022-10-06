package Day5;

public class burstBaloon {
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; j<n; j++,i++){
                if(gap==0){
                    int cv = nums[i];
                    int left = i>0?nums[i-1]:1;
                    int right = i<n-1?nums[i+1]:1;
                    dp[i][j] = cv*left*right;

                }else{
                    dp[i][j] = Integer.MIN_VALUE;
                    for(int k=i; k<=j; k++){
                        int left = k==i?0:dp[i][k-1];
                        int right = k==j?0:dp[k+1][j];
                        
                        int lm = i==0?1:nums[i-1];
                        int rm = j!=n-1?nums[j+1]:1;
                        int cv = nums[k]*lm*rm;

                        dp[i][j] = Math.max(dp[i][j], cv+left+right);
                    }
                }
            }   
        }for(int d[]: dp){
                for(int val: d){
                    System.out.print(val+" ");
                }
                System.out.println();
            }
        return dp[0][n-1];
    }
}
