class fibo{


    static void printFib(int n){
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3; i<dp.length;i++){
            dp[i] = dp[i-1]+dp[i-2];

        }

        System.out.println(dp[dp.length-1]);
    }

    public static void main(String[] args) {
        printFib(5);
    }
}