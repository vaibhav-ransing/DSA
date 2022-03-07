public class coinChange {
    
    
    static int printWays(int arr[], int sum, int count, int index){
        
        if(sum<0)
            return 0;
        if(sum==0)
            return 1;
        if(index>=arr.length)
            return 0;
        return
            printWays(arr, sum-arr[index], count, index)+printWays(arr, sum, count, index+1);
    }
    static int printWaysMemo(int arr[], int sum, int count, int index, int memo[][]){
        
        if(sum<0)
            return 0;
        if(sum==0)
            return 1;
        if(index==memo[0].length)
            return 0;
        if(memo[sum][index]==-1){
            memo[sum][index] = printWaysMemo(arr, sum-arr[index], count, index, memo)+
                                printWaysMemo(arr, sum, count, index+1, memo);
            
        }   
        return memo[sum][index];
    }

    static int getCount(int arr[], int n, int sum){

        if(sum==0)
            return 1;
        if(n==0)
            return 0;
        int res = getCount(arr, n-1, sum);
        if(arr[n-1]<=sum)
            res = res+ getCount(arr, n, sum-arr[n-1]);
        
        return res;
    }

    static void printWaysBtup(int arr[], int sum){
        int memo[][]= new int[sum+1][arr.length+1];

        for(int i=0;i<memo.length;i++)
            memo[i][0]=0;
        for(int i=0;i<memo[0].length;i++)
            memo[0][i]=1;
        
        for(int i=1; i<memo.length;i++){
            for(int j=1;j<memo[0].length;j++){
                int res = memo[i][j-1];
                if(i>=arr[j-1]){
                    memo[i][j] = res+ memo[i-arr[j-1]][j];
                }else
                    memo[i][j] = memo[i][j]+res;
            }
        }

        for(int i=0; i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                System.out.print(memo[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    static void pw(int arr[], int sum){
        int n = arr.length;
        int dp[][] = new int[n+1][sum+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1;
        for(int i=0;i<dp[0].length;i++)
            dp[0][i]=0;
        
        for(int i=1;i<dp[0].length;i++){
            for(int j=1; j<dp.length;j++){
                
            }
        }

    }
        public static void main(String[] args) {
        int arr[] = {1,2,3};
        // int arr[] = {2,5,3,6};
        int sum= 4;
        // int sum= 10;
        // System.out.println(printWays(arr, sum, 0,0));
        int memo[][]= new int[sum+1][arr.length];
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                memo[i][j] = -1;
            }
        }
        // System.out.println(printWaysMemo(arr, sum, 0, 0, memo));
        printWaysBtup(arr, sum);
    } 
}
