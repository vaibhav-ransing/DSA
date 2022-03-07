import java.io.*;
import java.util.*;

public class PathMaxGold {

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

    static void maxGold(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];

        for(int j=dp[0].length-1;j>=0;j--){
            for(int i=0;i<dp.length;i++){
                if(j==dp[0].length-1){
                    dp[i][j] = arr[i][j];

                }else if(i==0){
                    int right = dp[i][j+1];
                    int down = dp[i+1][j+1];
                    dp[i][j] += arr[i][j]+ Math.max(right, down);

                }else if(i==dp.length-1){
                    int right = dp[i][j+1];
                    int up = dp[i-1][j+1];
                    dp[i][j] += arr[i][j]+ Math.max(right, up);

                }else{
                    int up = dp[i-1][j+1];
                    int right = dp[i][j+1];
                    int down = dp[i+1][j+1];
                    dp[i][j] += arr[i][j]+ Math.max(right, Math.max(up, down));
                }
            }
        }
        // display(dp);
        printPath(dp);

    }
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
    }

    static void printPath(int dp[][]){

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int index=0;
        int val=0;
        for(int t=0;t<dp.length;t++){
            if(dp[t][0]>val){
                val=dp[t][0];
                index = t;
            }
        }
        System.out.println(val);
        
        for(int i=0; i<dp.length;i++){
            if(dp[i][0]==val){
                queue.add(new Pair("", i, 0));
                System.out.print(i+" ");
                while(queue.size()>0){
                    Pair peek = queue.remove();
                    int r=peek.i;
                    int c=peek.j;
        
                    if(c==dp[0].length-1){
                        System.out.print(peek.psf);
                        System.out.println();
                    }

                    else if(r==0){
                        int right = dp[r][c+1];
                        int down = dp[r+1][c+1];
                        if(right>down){
                            queue.add(new Pair(peek.psf+"d2 ", r, c+1));
                        }else if(down>right){
                            queue.add(new Pair(peek.psf+"d3 ", r+1, c+1));
                        }else if(down==right){
                            queue.add(new Pair(peek.psf+"d2 ", r, c+1));
                            queue.add(new Pair(peek.psf+"d3 ", r+1, c+1));
                        }

                    }else if(r==dp.length-1){
                        int right = dp[r][c+1];
                        int up = dp[r-1][c+1];
                        if(right>up){
                            queue.add(new Pair(peek.psf+"d2 ", r, c+1));
                        }else if( right < up){
                            queue.add(new Pair(peek.psf+"d1 ", r-1, c+1));
                        }else if(right==up){
                            queue.add(new Pair(peek.psf+"d1 ", r-1, c+1));
                            queue.add(new Pair(peek.psf+"d2 ", r, c+1));
                        }

                    }else{
                        int up = dp[r-1][c+1];
                        int right = dp[r][c+1];
                        int down = dp[r+1][c+1];

                        if(right>down && right>up){
                            queue.add(new Pair(peek.psf+"d2 ", r, c+1));
                            
                        }else if(up>right && up>down){
                            queue.add(new Pair(peek.psf+"d1 ", r-1, c+1));

                        }else if(down>right && down>up) {
                            queue.add(new Pair(peek.psf+"d3 ", r+1, c+1));

                        }else if(up==right && right==down){
                            queue.add(new Pair(peek.psf+"d1 ", r-1, c+1));
                            queue.add(new Pair(peek.psf+"d2 ", r, c+1));
                            queue.add(new Pair(peek.psf+"d3 ", r+1, c+1));

                        }else if( up==right ){
                            queue.add(new Pair(peek.psf+"d1 ", r-1, c+1));
                            queue.add(new Pair(peek.psf+"d2 ", r, c+1));

                        }else if(right==down){
                            queue.add(new Pair(peek.psf+"d2 ", r, c+1));
                            queue.add(new Pair(peek.psf+"d3 ", r+1, c+1));

                        }else if(up==down){
                            queue.add(new Pair(peek.psf+"d1 ", r-1, c+1));
                            queue.add(new Pair(peek.psf+"d3 ", r+1, c+1));
                        }
                    }
                    
                }
                System.out.println();
            }
            
        }
        
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
      maxGold(arr);
   }


}