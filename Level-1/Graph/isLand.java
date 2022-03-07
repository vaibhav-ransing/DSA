import java.io.*;
import java.util.*;

public class isLand {

    static void totalIsland(int arr[][]){
        
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0 && visited[i][j]==false){
                    ans++;
                    helper(arr, visited, i, j);
                }
            }
        }
        System.out.println(ans);

    }
    static void helper(int arr[][] ,boolean visited[][], int i, int j){
        if(i==arr.length || j==arr.length || i<0 || j<0 )
            return;
        if(visited[i][j] || arr[i][j]==1)
            return;
        visited[i][j] = true;
        helper(arr, visited, i+1, j);
        helper(arr, visited, i-1, j);
        helper(arr, visited, i, j+1);
        helper(arr, visited, i, j-1);
    }


   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }
      totalIsland(arr);

      // write your code here
   }

}