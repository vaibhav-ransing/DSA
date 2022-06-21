package kType;
public class matrixChainMult {
    
    
    static void solution(int arr[]){
        // A  B  C  D  E
        // 10 20 30 40 50 60
        int dp[][]  = new int[arr.length-1][arr.length-1];
        for(int gap=0; gap<dp.length; gap++){
            for(int i=0, j=gap; j<dp.length; i++, j++ ){
                if(gap==0){
                    dp[i][j]=0;
                }else if(gap==1){
                    dp[i][j] = arr[i]*arr[j]*arr[j+1];
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i; k<j; k++){
                        int mult =  arr[i]*arr[k+1]*arr[j+1];
                        int val = dp[i][k]+dp[k+1][j]+mult;
                        dp[i][j] = Math.min(val, dp[i][j]);
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
        // System.out.println(dp[0][dp.length-1]);
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        solution(arr);
    }
}
