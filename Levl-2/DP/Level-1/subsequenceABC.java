public class subsequenceABC {
    static void ABC(String s){
        int dp[][] = new int[4][s.length()+1];
        for(int j=1;j<dp[0].length;j++){
            for(int i=1;i<dp.length;i++){
                dp[i][j]= dp[i][j-1];
                if(i==1 && s.charAt(j-1)=='a')
                    dp[i][j]= 2*dp[i][j-1]+1;

                else if(i==2 && s.charAt(j-1)=='b')
                    dp[i][j]= 2*dp[i][j-1]+dp[i-1][j];
                    
                else if(i==3 && s.charAt(j-1)=='c') 
                    dp[i][j]= 2*dp[i][j-1]+dp[i-1][j];
            }

        }
        // display(dp);
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }

    }
    public static void main(String[] args) {
        ABC("abcabc");
    }
}
