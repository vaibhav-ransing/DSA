public class test{

    static void fibonaci(int val){
        int arr[] = new int[val+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<arr.length;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        System.out.println(arr[arr.length-1]);
    }
   
    static int stairs(int n , int[] arr){
        if (n == 0) {
            return 1;
        } 
        else if (n < 0) {
            return 0;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n]=stairs(n - 1, arr)+ stairs(n - 2, arr)+stairs(n - 3, arr);
        return arr[n];
    }

    static void climbStairDp(int val){
        int arr[] = new int[val+1];
        arr[0]=1;
        for(int i=1;i<arr.length;i++){
            if(i-1>=0)
                arr[i]+=arr[i-1];
            if(i-2>=0)
                arr[i]+=arr[i-2];
            if(i-3>=0)
                arr[i]+=arr[i-3];

        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static int fibo(int n){
        if(n<0)
            return 0;

        if(n==0 || n==1)
            return n;
        return fibo(n-1)+fibo(n-2);
        
    }

    static void dpVarStair(int arr[], int n){
        int dp[] = new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            int steps = arr[i];
            for(int j=1;j<=steps;j++){
                if(i+j<=n){
                    dp[i]+=dp[i+j];
                }
            }
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }

    static void climbStairMinSteps(int arr[] , int n){
        int dp[] = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int steps = arr[i];
            dp[i] = Integer.MAX_VALUE;
            for(int j=1;j<=steps;j++){
                if(i+j<=n && dp[i+j]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i+j]);
                }
            }
            if(dp[i]!=Integer.MAX_VALUE)
                dp[i]++;
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }

    public static void main(String[] args) {
        int n=10;
        int arr[] = {3,3,0,2,1,2,4,2,0,0};
        // dpVarStair(arr, n);
        // int arr[] = {3,2,1,1};
        // int n=4;
        climbStairMinSteps(arr, n);
    }
}