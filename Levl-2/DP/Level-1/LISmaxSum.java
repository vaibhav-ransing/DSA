public class LISmaxSum {
    
    static void dpSoln(int arr[]){
        int n= arr.length;
        int dp[]= new int[n]; 
        int overAllmax=0;
         for(int i=0;i<dp.length;i++){
             dp[i]=0;
             for(int j=0;j<i;j++){
                 if(arr[j]<=arr[i])
                    dp[i] = Math.max(dp[i], dp[j]);
             }
             dp[i]+=arr[i];

             overAllmax= Math.max(overAllmax, dp[i]);
         }  
         System.out.println("max "+overAllmax);

        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");

    }
    static void display(int dp[]){
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
        System.out.println("----------------");
    }

    public static void main(String[] args) {
    int arr[]  = {10,22,9,33,21,50,41,60,80};
    // int arr[]  = {35,35,97,25,97,54,46,22,26,86,13,48,99,63,38};
    
    // int arr[]  = {96,75,84,27};
    // int arr[] = {11,3,6,7};
    dpSoln(arr);
    // 363
    }
}
