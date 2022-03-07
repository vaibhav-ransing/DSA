import java.io.*;
import java.util.*;

public class AllPathMinCost {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }

   static void fillDp(int arr[][], int dp[][]){

        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1 ){
                    dp[i][j] = arr[i][j];
                }else if(i==dp.length-1){
                    dp[i][j] = arr[i][j]+dp[i][j+1];
                }else if(j==dp[0].length-1){
                    dp[i][j] = arr[i][j]+dp[i+1][j];
                }else{
                    int right = arr[i][j] + dp[i][j+1];
                    int down = arr[i][j] + dp[i+1][j];
                    dp[i][j] = Math.min(right, down);
                }
            }
        }
    }

    static void printPath(int dp[][]){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("", 0, 0));

        while(queue.size()>0){
            Pair peek = queue.remove();
            int r = peek.i;
            int c = peek.j;
            
            if(r==dp.length-1 && c== dp[0].length-1){
                System.out.println(peek.psf);

            }else if(r!= dp.length-1 && c!= dp[0].length-1){
                if(dp[r+1][c] < dp[r][c+1]){
                    queue.add( new Pair(peek.psf+"V", r+1, c) );
                }else if(dp[r+1][c] > dp[r][c+1]){
                    queue.add( new Pair(peek.psf+"H", r, c+1) );
                }else{ // equal
                    queue.add( new Pair(peek.psf+"V", r+1, c) );
                    queue.add( new Pair(peek.psf+"H", r, c+1) );
                }

            }else if(r==dp.length-1){
                queue.add( new Pair(peek.psf+"H", r, c+1) );

            }else if(c == dp[0].length-1){
                queue.add( new Pair(peek.psf+"V", r+1, c) );
            }
        }
    }

    static void printMinCostAndPath(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];
        fillDp(arr, dp);
        System.out.println(dp[0][0]);
        printPath(dp);
    }


   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //write your code here
      printMinCostAndPath(arr);

      int arr2[][] =  {    { 0 ,1, 4, 2, 8 ,2},
                            {4, 3 ,6 ,5 ,0,4},
                            { 1 ,2, 4 ,1, 4 ,6},
                            {2 ,0 ,7 ,3, 2, 2},
                            { 3 ,1, 5, 9 ,2, 4},
                            { 2, 7, 0, 8, 5,1}      };
                    printMinCostAndPath(arr);
   }

}