
public class palindromSubseq {
    
    static void dpSoln(String s){
        int n = s.length();
        int dp[][] = new int[n][n];
        
        for(int gap=0; gap<n;gap++){
            for(int i=0, j=gap; j<n; j++,i++){
                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1){
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=3;
                    else
                        dp[i][j]=2;
                }
                else{
                    if(s.charAt(i)!=s.charAt(j)){
                        dp[i][j] = dp[i][j-1]+dp[i+1][j]- dp[i+1][j-1];
                    }else{
                        dp[i][j] = dp[i][j-1]+dp[i+1][j] +1;
                    }
                }
            }   
        }
        // display(dp);
        System.out.println(dp[0][dp[0].length-1]);
    }
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        dpSoln("ccbbgd");

    }
}
