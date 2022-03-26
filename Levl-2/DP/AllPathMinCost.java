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

    static void printAllPathMinJump(int arr[]){
        int n = arr.length;
        int dp[] = new int[n+1];
        for(int i=0;i<dp.length;i++)
            dp[i] = Integer.MAX_VALUE;
        dp[n]=0;
        
        for(int i=n-1;i>=0;i--){
            int jumps = arr[i];
            for(int j=1;j<=jumps;j++){
                dp[i] = Math.min(dp[i+j], dp[i]);
            }
            if(dp[i]!=Integer.MAX_VALUE)
                dp[i]++;

        }
        // for(int i=0;i<dp.length;i++)
        //     System.out.print(dp[i]+" ");
        System.out.println(dp[0]);
        printPathMinJump(dp, arr);
    }
    static class pair2{
        int index;
        String psf;
        int val;
        int jumps;
        pair2(int i, String psf, int val, int jumps){
            this.index = i;
            this.psf = psf;
            this.val = val;
            this.jumps = jumps;
        }
    }

    static void printPathMinJump(int dp[], int arr[]){
        pair2 p = new pair2(0, "0", dp[0], arr[0]);
        ArrayDeque<pair2> queue = new ArrayDeque<>();
        queue.add(p);
        while(queue.size()>0){
            pair2 peek = queue.removeFirst();
            if(peek.index==dp.length-1)
                System.out.println(peek.psf);
            for(int i=peek.index+1; i<=peek.jumps;i++){
                if(i==dp.length)
                    break;
                if(dp[i]==peek.val-1){
                    pair2 np = new pair2(i, peek.psf+" "+i, dp[i], arr[i]);
                    queue.add(np);
                }
            }
        }
    }

   public static void main(String[] args) throws Exception {
       int arr[] = {2,3,0,2,1,2,4,2,0,0};
       printAllPathMinJump(arr);
    //   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //   int n = Integer.parseInt(br.readLine());
    //   int m = Integer.parseInt(br.readLine());
    //   int[][] arr = new int[n][m];

    //   for (int i = 0; i < n; i++) {
    //      String str = br.readLine();
    //      for (int j = 0; j < m; j++) {
    //         arr[i][j] = Integer.parseInt(str.split(" ")[j]);
    //      }
    //   }

    //   //write your code here
    //   printMinCostAndPath(arr);

    //   int arr2[][] =  {    { 0 ,1, 4, 2, 8 ,2},
    //                         {4, 3 ,6 ,5 ,0,4},
    //                         { 1 ,2, 4 ,1, 4 ,6},
    //                         {2 ,0 ,7 ,3, 2, 2},
    //                         { 3 ,1, 5, 9 ,2, 4},
    //                         { 2, 7, 0, 8, 5,1}      };
    //                 printMinCostAndPath(arr);
   }

}