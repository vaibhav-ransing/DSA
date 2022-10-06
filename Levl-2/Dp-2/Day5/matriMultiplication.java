package Day5;

public class matriMultiplication {
    static int matrixMultiplication(int arr[]){
        int dp[][] = new int[arr.length-1][arr.length-1];
        for(int gap=1; gap<dp.length; gap++){
            for(int i=0, j=gap; j<dp.length; j++, i++){
                if(gap==1){
                    dp[i][j] = arr[j-1]*arr[j]*arr[j+1];
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i; k<j; k++){
                        int mult = arr[i]*arr[k+1]*arr[j+1];
                        int val = dp[i][k]+dp[k+1][j] + mult;
                        dp[i][j] = Math.min(dp[i][j], val);
                    }
                }
            }
        }
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" " );
            }
            System.out.println();
        }
        System.out.println(dp[0][dp[0].length-1]);
        return dp[0][dp[0].length-1];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        matrixMultiplication(arr);
    }
}
