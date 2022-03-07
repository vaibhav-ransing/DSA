

public class lcs {
    
    static int PrintLCS(String s1, String s2, int count){

        if(s1.length()==0 || s2.length()==0)
            return count;   

        if(s1.charAt(s1.length()-1)==s2.charAt(s2.length()-1)){
            return PrintLCS(s1.substring(0,s1.length()-1), s2.substring(0,s2.length()-1), count+1);
        }else{
            return Math.max(PrintLCS(s1.substring(0,s1.length()-1), s2, count), 
                            PrintLCS(s1, s2.substring(0,s2.length()-1), count));
        }
    } 

    static int PrintLcsMemo(String s1, String s2, int count, int memo[][]){

        if(memo[s1.length()-1][s2.length()-1]==-1){

            if(s1.length()==0 || s2.length()==0)
                return count;   
            int n = s1.length();
            int m = s2.length();
            if(s1.charAt(s1.length()-1)==s2.charAt(s2.length()-1)){
                memo[n-1][m-1]= PrintLCS(s1.substring(0,n-1), s2.substring(0,m-1), count+1);
            }else{
                memo[n-1][m-1]= Math.max(PrintLCS(s1.substring(0,s1.length()-1), s2, count), 
                            PrintLCS(s1, s2.substring(0,s2.length()-1), count));
            }
            return memo[n-1][m-1]; 
        }
        else
            return memo[s1.length()-1][s2.length()-1];
    }

    static void printArr(int memo[][]){
        for(int i=0; i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                System.out.print(memo[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void lcsTabu(String s1, String s2, int n, int m){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0]=0;
        for(int i=0;i<dp[0].length;i++)
            dp[0][i]=0;
        
        for(int i=1; i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                    // System.out.println(dp[i][j]);
                }else{
                    dp[i][j]  = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
        printArr(dp);
    }

    public static void main(String[] args) {
        String s1 = "axyz";
        String s2 = "baz";
        int s1L = s1.length();
        int s2L = s2.length();
        int memo[][] = new int[s1L][s2L];
        lcs c = new lcs();
        PrintLcsMemo(s1, s2, 0, memo);
        // c.printArr(memo);

        // System.out.println(PrintLcsMemo(s1, s2, 0, memo));
        lcsTabu(s1, s2, 0, 0);
    }
}

 

