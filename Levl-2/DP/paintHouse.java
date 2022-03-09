public class paintHouse {
    
    static void soln(int red[], int blue[], int green[]){

        int dp[][] = new int[3][red.length+1];

        for(int j=1;j<dp[0].length;j++){
            for(int i=0;i<dp.length;i++){
                if(i==0){
                    dp[i][j] = red[j-1] + Math.min(dp[i+1][j-1], dp[i+2][j-1]);
                }else if(i==1){
                    dp[i][j] = blue[j-1] + Math.min(dp[i-1][j-1], dp[i+1][j-1]);
                }else{
                    dp[i][j] = green[j-1] + Math.min(dp[i-1][j-1], dp[i-2][j-1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for( int i=0;i<dp.length;i++){
            min = Math.min(dp[i][dp[0].length-1], min);
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        
    }
}
