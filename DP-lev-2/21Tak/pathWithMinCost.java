import java.util.ArrayDeque;

public class pathWithMinCost {

    static void Solution(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];

        for(int j=0; j<dp[0].length; j++){
            for(int i=0; i<dp.length; i++){
                if(i==0 && j==0){
                    dp[i][j] = arr[i][j];
                }else if(i==0){
                    dp[i][j] = dp[i][j-1]+arr[i][j];
                }else if(j==0){
                    dp[i][j] = arr[i][j]+dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+arr[i][j], dp[i][j-1]+arr[i][j]);
                }
            }
        }
        printPath(arr, dp);
        // for(int a[]: dp){
        //     for(int val: a){
        //         System.out.print(val+" ");
        //     }
        //     System.out.println();
        // }
    }
    static void printPath(int arr[][], int dp[][]){
        // 0 1 5 7 15 17 
        // 4 4 10 12 12 16 
        // 5 6 10 11 15 21 
        // 7 6 13 14 16 18 
        // 10 7 12 21 18 22 
        // 12 14 12 20 23 23

        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(new pair("", dp.length-1, dp[0].length-1));
        while(queue.size()>0){
            pair peek = queue.pop();
            
            if(peek.row==0 && peek.col==0){
                System.out.println(peek.asf);
                continue;
            }else if(peek.row==0){
                queue.add(new pair("H"+peek.asf, peek.row, peek.col-1));
            }else if(peek.col==0){
                queue.add(new pair("V"+peek.asf, peek.row-1, peek.col));
            }else{
                int rem = dp[peek.row][peek.col] - arr[peek.row][peek.col];
                if(dp[peek.row][peek.col-1]==rem){
                    queue.add(new pair("H"+peek.asf, peek.row, peek.col-1));
                }
                if(dp[peek.row-1][peek.col]==rem){
                    queue.add(new pair("V"+peek.asf, peek.row-1, peek.col));
                }
                
            }
        }

    }
    static class pair{
        String asf;
        int row;
        int col;
        pair(String asf, int row, int col){
            this.asf = asf;
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) {
        int arr[][] = {{ 0, 1, 4, 2, 8, 2},
                        {4, 3, 6, 5, 0, 4},
                        {1, 2, 4, 1, 4, 6},
                        {2, 0, 7, 3, 2, 2},
                        {3, 1, 5, 9, 2, 4},
                        {2, 7, 0, 8, 5, 1}};
        Solution(arr);
         // 0 1 4 2 8 2
        // 4 3 6 5 0 4
        // 1 2 4 1 4 6
        // 2 0 7 3 2 2
        // 3 1 5 9 2 4
        // 2 7 0 8 5 1
    }
}
