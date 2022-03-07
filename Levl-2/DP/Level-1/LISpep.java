
class LISpep{


    static void dpSoln(int arr[]){

        int dp[] = new int[arr.length];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
        }
        // for(int i=0;i<dp.length;i++)
        //     System.out.print(dp[i]+" ");
        int max=0;
        for(int i=0;i<dp.length;i++)
        max = Math.max(max, dp[i]);
        System.out.print(max);
    }


    public static void main(String[] args) {
        int arr[] = {10,22,9,33,21,50,41,60,80,1};
        dpSoln(arr);

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int arr[] = new int[n];
        // for(int i=0;i<arr.length;i++)
        //     arr[i] = sc.nextInt();
    }
}