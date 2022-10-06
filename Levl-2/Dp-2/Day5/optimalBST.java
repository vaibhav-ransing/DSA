package Day5;
// https://practice.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1
public class optimalBST {
    

    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int dp[][] = new int[n][n];
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; j<n; j++,i++){
                if(gap==0){
                    dp[i][j] = freq[i];
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                    int extra = 0;
                    for(int k=i; k<=j; k++){
                        extra+=freq[k];
                        int left = k==i?0:dp[i][k-1];
                        int right = k==j?0:dp[k+1][j];
                        dp[i][j] = Math.min(dp[i][j], left+right);
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
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] keys = {10, 12, 20};
        int[] freq = {34, 8, 50};
        int n=3;
        optimalSearchTree(keys, freq, n);
    }
}



// for(int k=i-1; k<j; k++){
//     int left=k>=0?dp[k][i]:0;
//     int rigt = k+2<n?dp[k+2][j]:0;
//     if(k!=-1)
//         extra=extra+ freq[k+1];
//     System.out.println(left+" "+ rigt+" "+extra+" "+k);
//     dp[i][j] = Math.min(dp[i][j], left+rigt);
// }
// // int[] freq = {34, 8, 50};
// dp[i][j]+=extra;
// System.out.println("--- "+dp[i][j]+" -- "+extra);

