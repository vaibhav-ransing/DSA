package kType;
public class rodCutting {
    

    static void solution(int arr[]){
        int dp[] = new int [arr.length+1];
        dp[1]=arr[0];
        for(int i=2; i<dp.length; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i], arr[j-1]+dp[i-j]);
            }
        }
        for(int val: dp)
            System.out.print(val+" ");
    }


    public static void main(String[] args) {
        int arr[] = {1,5,8,9,10,17,17,20};
        solution(arr);
    }
}
