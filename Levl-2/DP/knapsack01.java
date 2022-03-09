import java.io.*;
import java.util.*;

public class knapsack01 {
    static class Pair{
        String psf;
        int i;
        int j;
        Pair(String psf, int i, int j){
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }
    static void soln(int cap[],int wt[], int weight){
        int dp[][] = new int[cap.length+1][weight+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j-wt[i-1]>=0){
                    int include = dp[i-1][j-wt[i-1]] + cap[i-1];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[cap.length][weight]);
        // display(dp);
        printPath(dp, wt,cap);

    }
    static void display(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void printPath(int dp[][], int wt[], int cap[]){
        int n = dp.length;
        int m = dp[0].length;
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("", n-1, m-1));

        while(queue.size()>0){
            Pair peek = queue.remove();
            int r = peek.i;
            int c = peek.j;
            if(r==0 || c==0){
                System.out.println(peek.psf);
            }else{
                if(c-wt[r-1]>=0){
                    if(dp[r][c] -dp[r-1][c-wt[r-1]] == cap[r-1])
                        queue.add(new Pair((r-1)+" "+peek.psf , r-1, c-wt[r-1]));
                }
                if(dp[r][c]==dp[r-1][c]){
                    queue.add(new Pair(peek.psf , r-1, c));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int[] wt = {15,14,10,45,30};
        int capacity[] = {2,5,1,3,4};
        int w = 7;
        
        //write your code here
        soln(values, wts, cap);
        
    }
}


                        


                        


                        