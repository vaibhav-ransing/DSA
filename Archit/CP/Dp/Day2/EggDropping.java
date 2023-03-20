package CP.Dp.Day2;

public class EggDropping {
    

    public int superEggDrop(int eggs, int floors) {
        int dp[][] = new int[eggs+1][floors+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(eggs, floors, dp);
    }

    public static int helper(int eggs, int floors, int[][] dp){
        if(eggs==1) return floors;
        if(floors==0 || floors==1)  return floors;
        
        if(dp[eggs][floors]!=-1) return dp[eggs][floors];

        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=floors; i++){
            int breaksEgg = helper(eggs-1, i-1, dp);
            int surviveEgg = helper(eggs+1, floors-i, dp);
            ans = Math.max(ans, Math.min(breaksEgg, surviveEgg));
        }
        dp[eggs][floors] = ans;
        return ans;
    }

    public static int helperBinarySearch(int eggs, int floors, int[][] dp){
        if(eggs==1) return floors;
        if(floors==0 || floors==1)  return floors;
        
        if(dp[eggs][floors]!=-1) return dp[eggs][floors];

        int ans = Integer.MIN_VALUE;
        int low = 1, high = floors;
        while(low<=high){
            int mid = (low+high)/2;
            int breaksEgg = helperBinarySearch(eggs-1, mid-1, dp);
            int surviveEgg = helperBinarySearch(eggs, floors-mid, dp);

            ans = Math.max(ans, Math.min(breaksEgg, surviveEgg));
            if(breaksEgg>surviveEgg){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        dp[eggs][floors] = ans;
        return ans;
    }

}
