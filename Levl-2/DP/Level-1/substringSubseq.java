
public class substringSubseq {
    
    static void dpSoln(String s){
        int n =s.length();
        boolean dp[][] = new boolean[n][n];

        for(int gap=0;gap<n;gap++){
            for(int i=0, j=gap; j<n; i++,j++){
                if(i==j)
                    dp[i][j]=true;
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=true;
                    else dp[i][j]=false;
                }
                else
                    dp[i][j]=dp[i+1][j-1];
            }
        }
        int count=0;
        // display(dp, count);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(dp[i][j]==true)
                    count++;
            }
            System.out.println();
        }
        System.out.println(count);
    }
    static void display(boolean dp[][], int count){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
                if(dp[i][j]==true)
                    count++;
            }
               
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        dpSoln("abccbc");
    }
}
