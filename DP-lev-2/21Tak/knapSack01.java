import java.util.ArrayDeque;

public class knapSack01 {
    
    static void Solution(int bg, int wt[], int val[]){
        int dp[][] = new int[wt.length+1][bg+1];
        for(int j=1; j<dp[0].length; j++){
            for(int i=1; i<dp.length; i++){
                if(j-wt[i-1]>=0){
                    int rem = dp[i-1][j-wt[i-1]];
                    dp[i][j] = val[i-1]+rem;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
            }
        }
        for(int ar[]: dp){
            for(int a: ar){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        printPath(dp, val, wt);
    }
    
    static class pair{
        int i;
        int j;
        String asf;
        pair(int i, int j, String asf){
            this.i=i;
            this.j = j;
            this.asf = asf;
        }
    }
    static void printPath(int dp[][], int val[], int wt[]){
        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(new pair(dp.length-1, dp[0].length-1, ""));

        while(queue.size()>0){
            pair peek = queue.remove();
            int i = peek.i;
            int j = peek.j;
            if(j==0){
                System.out.println(peek.asf);
                continue;
            }
            if(dp[i-1][j]==dp[i][j]){
                queue.add(new pair(i-1, j, peek.asf));
            }
            if(j-wt[i-1]>=0 && (dp[i-1][j-wt[i-1]]==dp[i][j]-val[i-1])){
                queue.add(new pair(i-1, j-wt[i-1], (i-1)+" "+peek.asf));
            }
        }
    }


    public static void main(String[] args) {
        int wt[] = {2,5,1,3,4};
        int val[] = {15,14,10,45,30};
        int bg = 7;
        Solution(bg, wt, val);
    }
}
