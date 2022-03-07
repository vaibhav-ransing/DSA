public class cc {

    static void rec(int arr[], int amt, int n, String ans){
        if(amt==0){
            System.out.println(ans);
            return;
        }  
        if(n==0 || amt<0)
            return;
        rec(arr, amt-arr[n-1], n, ans+arr[n-1]+"-");
        rec(arr, amt, n-1,ans);
    }
    static void dpCoinChange(int arr[], int amt){
        int n= arr.length;
        int dp[][]= new int[n+1][amt+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j-arr[i-1]>=0 && dp[i][j-arr[i-1]]>0){
                    dp[i][j]= dp[i-1][j]+dp[i][j-arr[i-1]];
                    // if(j-arr[i-1]!=0)
                    //     dp[i][j]= 1+ dp[i][j-arr[i-1]] +dp[i-1][j];
                    // else
                    //     dp[i][j]=  dp[i][j-arr[i-1]] +dp[i-1][j];
                }else
                    dp[i][j]= dp[i-1][j];
            }
        }
        display(dp);
        // System.out.println(dp[dp.length-1][dp[0].length-1]);
    }

    static void dpCoinChange2(int arr[], int amt){
        int n= arr.length;
        int dp[]= new int[amt+1];

        dp[0]=1;
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i]; j<dp.length;j++){
                if(dp[j-arr[i]]==1)
                    dp[j]+=dp[j-arr[i]];             
            }
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }


    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int arr[]={2,3,5};
        // int amt = 7;

        int arr[]={5,2,3,7,6,1,12,11,9,15};
        int amt = 45;
        
        int n= arr.length;
        // rec(arr, amt, n, "");
        dpCoinChange(arr, amt);
        // dpCoinChange2(arr, amt);
    }
}
