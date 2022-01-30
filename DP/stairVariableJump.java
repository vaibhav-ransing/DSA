import java.util.Scanner;

public class stairVariableJump {
    
    static int stair(int arr[], int n, int index, int res){
        
        if(n==0)
            return 1;
        if(n<0 || index==arr.length)
            return 0;
        
        for(int i=1;i<=arr[index];i++){
            res += stair(arr, n-i, index+1, res);
        }
        return res;
    }
    
    static void dpVarStair(int arr[], int n){
        int dp[] = new int[n+1];

        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=1; j<=arr[i];j++ ){
                if(i+j<=n)
                    dp[i]+=dp[i+j];
            }
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }

    public static void main(String[] args) {
        // int arr[] = {3,2,4,2,0,2,3,1,2,2};
        // int arr[] = {3,3,0,2,1,2,4,2,0,0};
        int arr[] = {2,3,0,2,2,3};
        int n = arr.length;
        dpVarStair(arr, n);
    }
}
