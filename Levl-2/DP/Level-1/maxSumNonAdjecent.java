import java.util.Scanner;

public class maxSumNonAdjecent {
    
    static int recSoln(int arr[], boolean prevAdjTaken, int index, String ans){
        if(index==arr.length){
            System.out.println(ans);
            return 0;
        }
        if(prevAdjTaken==false){
            int take = arr[index]+recSoln(arr, true, index+1, ans+arr[index]+"-");
            return Math.max(recSoln(arr, false, index+1, ans), take);
        }else{
            return recSoln(arr, false, index+1, ans);
        }
    }
    static void dpSoln(int arr[]){
        int dp[][] = new int[2][arr.length];
        dp[0][0] = arr[0];
        dp[1][0] = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>0)
                dp[0][i] = arr[i]+ dp[1][i-1];
            else 
                dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[0][i-1];
        }
        System.out.println(Math.max(dp[0][dp[0].length-1], dp[1][dp[0].length-1]));
        display(dp);
    }
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
            
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,10,10, 100,5,6};
        // int arr[] = {1,2,3,4,5,6};
        // System.out.println(recSoln(arr, false,0, ""));
        dpSoln(arr);
       
    }
}
