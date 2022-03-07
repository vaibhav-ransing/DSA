public class optimalGame {
    
    static int game(int arr[], int i, int j){

        if(i+1==j)
            return Math.max(arr[i], arr[j]);
        
        return Math.max(arr[i] + Math.min(game(arr, i+2, j), game(arr, i+1, j-1)),  
                        arr[j] + Math.min(game(arr, i+1, j-1), game(arr, i, j-2))); 
    }
    static int gameRec(int arr[], int i, int j){
        if(i==j)
            return arr[i];

        return Math.max(arr[i] + Math.min(game(arr, i+2, j),   game(arr, i, j-1)), 
                        arr[j] + Math.min(game(arr, i+1, j-1), game(arr, i, j-2)));
    }   

    static void gameDP(int arr[]){      
        int n = arr.length;     
        int dp[][] = new int[n][n]; 
        for(int i=0;i<n;i++)
            dp[i][i] = arr[i];

        for(int i=0,j=1; j<dp.length; j++, i++)
            dp[i][j] = Math.max(arr[i], arr[j]);

        for(int gap=2; gap<dp.length;gap++){
            for(int i=0; i<dp.length;i++){
                int j=gap+i;
                if(j<dp.length){
                    System.out.println("I "+i+" j "+j+" gap "+gap);
                    dp[i][j] = Math.max(arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]),
                                    arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]));
                }
            }     
        }

        for(int i=0; i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
    }   
    public static void main(String[] args) {
        int arr[] = {2,3,15,7};
        int i=0;
        int j =arr.length-1;
        // System.out.println(game(arr, i, j));

        // game(arr, start, end);
        // game(arr, start, end, 0);

        gameDP(arr);

    }
}
