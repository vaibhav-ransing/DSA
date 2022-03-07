public class lisRev {
    

    static int[] dpSoln(int arr[]){
        int n= arr.length;
        int dp[] = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    dp[i] = Math.max(dp[i], dp[j]);
                
            }
            dp[i]+=1;
        }
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        return dp;
    }

    static int[] dpDescSoln(int arr[]){
        int n= arr.length;
        int dp[] = new int[n];
        dp[0]=1;
        
        for(int i=1;i<arr.length;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                if(arr[j]>arr[i])
                    dp[i] = Math.max(dp[j], dp[i]);
            }
            dp[i]+=1;
        }
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        return dp;
    }

    


    public static void main(String[] args) {
        
        // int arr[] = {4,3,2,8,10,5,1};
        // int arr[] = {1,11,2,10,4,5,2,1};
        int arr[] = {5,4,3,2,1};
        // int arr[] = {8,100,150,10,12,14,110};
        // dpSoln(arr);
        int dpInc[] = dpSoln(arr);
        int dpDec[] = dpDescSoln(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(dpInc[i] + dpDec[i] -1+" ");
        }

    }
}
