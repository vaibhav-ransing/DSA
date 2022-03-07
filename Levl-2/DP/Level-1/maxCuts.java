public class maxCuts {
    
    static int mc(int n, int a, int b, int c){
        if(n<0)
            return -1;
        if(n==0)
            return 0;
        int cutA = 1+mc(n-a, a, b, c); 
        int cutB = 1+mc(n-b, a, b, c);
        int cutC = 1+mc(n-c, a, b, c);

        return Math.max(Math.max(cutA, cutB), cutC) ;
    }
     
    static void dpSoln(int n,int a, int b, int c){
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            dp[i]=-1;
            if(i-a>=0)
                dp[i] = Math.max(dp[i], dp[i-a]);
            if(i-b>=0)
                dp[i] = Math.max(dp[i], dp[i-b]);
            if(i-c>=0)
                dp[i] = Math.max(dp[i], dp[i-c]);
            if(dp[i]!=-1)
                dp[i]++;
        }

        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
        // System.out.println(dp[n]);
    }

    static void maxDp(int n, int a , int b, int c){
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++)
            dp[i]=-1;
        for(int i=1;i<dp.length;i++){
            if((i-a)>=0){
                if(dp[i-a]!=-1)
                    dp[i] = Math.max(dp[i-a]+1, dp[i]);
            }
            if((i-b)>=0){
                if(dp[i-b]!=-1)
                    dp[i] = Math.max(dp[i-b]+1, dp[i]);
            }
            if((i-c)>=0){
                if(dp[i-c]!=-1)
                    dp[i] = Math.max(dp[i-c]+1, dp[i]);
            }
            
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }

    public static void main(String[] args) {
        // int n=23;
        // int a=11;
        // int b=11;
        // int c=13;
        int n=10;
        int a=3;
        int b=8;
        int c=7;
        // System.out.println(mc(n, a, b, c));
        dpSoln(n, a, b, c);
        // maxDp(n, a, b, c); 
    }
}
