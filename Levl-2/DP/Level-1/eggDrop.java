public class eggDrop {
    
    static int recEgg(int egg , int floor){

        if(egg==1 || floor==1 || floor==0)
            return floor;

        
        int min = Integer.MAX_VALUE;
        int res;
        for(int k=1;k<=floor;k++){
            res= Math.max(recEgg(egg-1, k-1), recEgg(egg, floor-k));
            min = Math.min(res, min);
        }
        return min+1;
    }

    static void dpEgg(int egg, int floor){

        int dp[][] = new int[egg+1][floor+1];
        for(int i=1; i<dp.length;i++)
            dp[i][0] = 0;
        for(int i=1; i<dp.length;i++)
            dp[i][1] = 1;
        for(int i=0; i<dp[0].length;i++)
            dp[1][i] = i;
        
        for(int i=2;i<dp.length;i++){
            for(int j=2; j<dp[0].length;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=1; k<=j;k++){
                    int res = Math.max(dp[i-1][k-1], dp[i][j-k]);
                    dp[i][j] = Math.min(dp[i][j], res);
                }
                dp[i][j]++;
            }
        }
        display(dp);
        
          
    }
    static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String args[]){
        // System.out.println(recEgg(2, 10));
        // dpEgg(3, 7);
        dpEgg(2, 10);
    }
}
