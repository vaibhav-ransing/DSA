package kType;
public class optimalBST {
    
    static void solution(int arr[], int freq[]){
        int dp[][] = new int[arr.length][arr.length];
        for(int gap=0; gap<dp.length; gap++){
            for(int i=0, j=gap; j<dp.length; j++, i++){
                if(gap==0){
                    dp[i][j] = freq[i];
                }else{
                    int extra = 0;
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i; k<=j; k++){
                        int left=0;
                        int right=0;
                        if(k!=i) left = dp[i][k-1];
                        if(k!=j) right = dp[k+1][j];
                        extra+=freq[k];
                        int tv = left+ right;
                        dp[i][j] = Math.min(dp[i][j], tv);

                    }
                    dp[i][j]+=extra;
                }
            }
        }
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        // System.out.println(dp[0][dp.length]);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int freq[] = {3,5,2,4};
        solution(arr, freq);
    }
}
