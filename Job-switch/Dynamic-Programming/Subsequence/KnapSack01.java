package Subsequence;

public class KnapSack01 {

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n][maxWeight+1];
        int ans = recursion(weight, value, maxWeight, n-1, dp);
        return ans;
    }

    public static int recursion(int[] weight, int[] value, int maxWeight, int idx, int dp[][]){
        if(idx < 0){
            return 0;
        }

        if(dp[idx][maxWeight] !=0)
            return dp[idx][maxWeight];
        int skip = recursion(weight, value, maxWeight, idx-1, dp);
        int take = 0;
        if(weight[idx] <= maxWeight){
            take = value[idx] +  recursion(weight, value, maxWeight - weight[idx], idx-1, dp);
        }
        return dp[idx][maxWeight] = Math.max(skip, take);
    }


    static int knapsackCall(int[] weight, int[] value, int n, int maxWeight) {
        return tabulation(weight, value, n, maxWeight);
    }

    public static int tabulation(int[] weight, int[] value, int n, int maxWeight){
        int dp[][] = new int[n+1][maxWeight+1];

        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                int skip = dp[i-1][j];
                int take = 0;
                if(j - weight[i-1] >= 0)
                    take = value[i-1] + dp[i-1][j-weight[i-1]];
                dp[i][j] = Math.max(take, skip);
            }
        }
        return dp[n][maxWeight];

        //   0   1   2   3   4   5 
//  0  0 //  --  --  --  --  --  --
//  5  1 //  --  -5-  --  --  --  --
//  4  2 //  --  --  --  --  --  --
//  8  3 //  --  --  --  --  --  --
//  6  4 //  --  --  --  --  --  --

    }

    public static int tabulationSpaceOptimize(int[] weight, int[] value, int n, int maxWeight){
        
        int pre[] = new int[maxWeight + 1];
        
        for(int i=0; i<weight.length; i++){
            int curr[] = new int[maxWeight + 1];
            for(int j=0; j<pre.length; j++){
                int skip = pre[j];
                int take = 0;
                if(j - weight[i] >= 0)
                    take = value[i] + pre[j-weight[i]];
                curr[j] = Math.max(take, skip);
            }
            pre = curr;
        }
        return pre[maxWeight];

    }

    public static int mostOptimized(int[] weight, int[] value, int n, int maxWeight){
        
        int pre[] = new int[maxWeight + 1];
        
        for(int i=0; i<weight.length; i++){  
            for(int j=maxWeight; j>=0; j--){ //  we start from end of prev, to fill pre[j] we only need values till pre[j-1]
                int skip = pre[j];
                int take = 0;
                if(j - weight[i] >= 0)
                    take = value[i] + pre[j-weight[i]];
                pre[j] = Math.max(take, skip);
            }
        }
        return pre[maxWeight];
    }
    public static void main(String[] args) {
        int[] weight = {1,2,3,4};
        int[] value = {5,4,8,6};
        int maxWeight = 5;
        int n = weight.length;
        System.out.println(tabulation(weight, value, n, maxWeight));
    }

}
