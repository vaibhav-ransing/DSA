package kType;
public class polygonTraing {
    

    static void solution(int arr[]){
        int dp[][] = new int[arr.length][arr.length];

        for(int gap=0; gap<dp.length; gap++){
            for(int i=0, j=gap; j<dp.length; j++, i++){
                dp[i][j] = Integer.MAX_VALUE;
                if(gap==0 || gap==1){
                    dp[i][j] =0;
                }else{
                    for(int k=i+1; k<j; k++){
                        int val = arr[i]*arr[k]*arr[j];
                        int left = dp[i][k];
                        int right = dp[k][j];
                        System.out.println(i+" "+j+" "+  val+" "+left+" "+ right);
                        int tv = val+left+right;

                        dp[i][j] = Math.min(dp[i][j], tv);
                    }
                    System.out.println("------------------------");
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
        int arr[] ={4,3,7,4,5};
        solution(arr);

    }
}
