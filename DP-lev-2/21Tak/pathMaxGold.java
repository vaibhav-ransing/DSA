import java.util.ArrayDeque;


public class pathMaxGold {
    
    // 0 1 4 2 8 2
    // 4 3 6 5 0 4
    // 1 2 4 1 4 6
    // 2 0 7 3 2 2
    // 3 1 5 9 2 4
    // 2 7 0 8 5 1

    static void Solution(int arr[][]){
        int dp[][] = new int[arr.length][arr[0].length];
        for(int j=0; j<arr[0].length-1; j++){
            for(int i=0;i<dp.length;i++){
                if(j==0){
                    dp[i][j] = arr[i][j];
                }
                if(i==0){
                    dp[i][j+1] = Math.max(arr[i][j+1]+dp[i][j], dp[i][j+1]);
                    dp[i+1][j+1] = Math.max(arr[i+1][j+1]+dp[i][j], dp[i+1][j+1]);

                }else if(i==dp.length-1){
                    dp[i][j+1] = Math.max(arr[i][j+1]+dp[i][j], dp[i][j+1]);
                    dp[i-1][j+1] = Math.max(arr[i-1][j+1]+dp[i][j], dp[i-1][j+1]);
                }else{
                    dp[i-1][j+1] = Math.max(arr[i-1][j+1]+dp[i][j], dp[i-1][j+1]);
                    dp[i][j+1] = Math.max(arr[i][j+1]+dp[i][j], dp[i][j+1]);
                    dp[i+1][j+1] = Math.max(arr[i+1][j+1]+dp[i][j], dp[i+1][j+1]);
                }
            }
        }
        // for(int a[]: dp){
        //     for(int val: a){
        //         System.out.print(val+" ");
        //     }
        //     System.out.println();
        // }
        printPath(arr, dp);
    }
    // 0 1 4 2 8 2
    // 4 3 6 5 0 4
    // 1 2 4 1 4 6
    // 2 0 7 3 2 2
    // 3 1 5 9 2 4
    // 2 7 0 8 5 1

    // 0 5 11 15 26 28 
    // 4 7 13 18 18 30 
    // 1 6 11 14 22 32 
    // 2 3 13 18 26 28 
    // 3 4 15 24 26 33 
    // 2 10 10 23 29 30 
    // 33
    // 4 d3 d1 d2 d3 d1 
    static class Pair{
        int i;
        int j;
        String asf;
        Pair(int i, int j, String asf){
            this.i = i;
            this.j =j;
            this.asf = asf;
        }
    }
    static void printPath(int arr[][], int dp[][]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<dp.length; i++){
            max = Math.max(max, dp[i][dp[0].length-1]);
        }
        System.out.println(max);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for(int i=0; i<dp.length; i++){
            if(dp[i][dp[0].length-1]==max){
                queue.add(new Pair(i, dp[0].length-1, ""));
            }
        }
        while(queue.size()>0){
            Pair peek = queue.pop();
            int i= peek.i;
            int j= peek.j;
            if(j==0){
                System.out.println(i+" "+ peek.asf);
                continue;
            }
            if(i==0){
                int rem = dp[i][j] - arr[i][j];
                if(dp[i][j-1]==rem){
                    queue.add(new Pair(i, j-1, "d2 "+peek.asf));
                }
                if(dp[i+1][j-1]==rem){
                    queue.add(new Pair(i+1, j-1, "d1 "+peek.asf));
                }
                
            }else if(i==dp.length-1){
                int rem = dp[i][j] - arr[i][j];
                if(dp[i][j-1]==rem){
                    queue.add(new Pair(i, j-1, "d2 "+peek.asf));
                }
                if(dp[i-1][j-1]==rem){
                    queue.add(new Pair(i-1, j-1, "d3 "+peek.asf));
                }
            }else{
                int rem = dp[i][j] - arr[i][j];
                if(dp[i-1][j-1]==rem){
                    queue.add(new Pair(i-1, j-1, "d3 "+peek.asf));
                }
                if(dp[i][j-1]==rem){
                    queue.add(new Pair(i, j-1, "d2 "+peek.asf));
                }
                if(dp[i+1][j-1]==rem){
                    queue.add(new Pair(i+1, j-1, "d1 "+peek.asf));
                }
            }
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
    }
}