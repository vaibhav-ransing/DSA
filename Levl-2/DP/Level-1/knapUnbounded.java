public class knapUnbounded {
    
    static void knapUnbound(int val[], int wt[], int cap){
        int n= val.length;
        int dp[][]= new int[n+1][cap+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j-wt[i-1]>=0){
                    int v1= val[i-1]+ dp[i][j-wt[i-1]];
                    int v2= val[i-1]+ dp[i-1][j-wt[i-1]];
                    dp[i][j]= Math.max(v1,v2);
                    dp[i][j]= Math.max(dp[i][j],dp[i-1][j]);
                    
                }else
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        display(dp);
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }

    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
    }

    static void dpOneDsoln(int val[], int wt[], int cap){
        int dp[]= new int[cap+1];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<val.length;j++){
                if(i-wt[j]>=0){
                    dp[i]= Math.max(val[j]+dp[i-wt[j]], dp[i]);
                }else
                    dp[i]=Math.max(dp[i-1], dp[i]);
            }
        }
        // for(int i=0;i<dp.length;i++)
        //     System.out.print(dp[i]+" ");
        System.out.println(dp[dp.length-1]);
    }
    
    public static void main(String[] args) {
        int val[]= {15,14,10,45,30};
        int wt[]=  {2, 5, 1, 3, 4};
        int cap=7;
        // knapUnbound(val, wt, cap);
        dpOneDsoln(val, wt, cap);

        
    }
}
