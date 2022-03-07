
public class arrangeBuilding{

    static void dpSoln(int n){
        int dp[][] = new int[2][n+1];
        dp[0][1]=1;
        dp[1][1]=1;

        long sum = 0;
        for(int i=2; i<dp[0].length;i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[0][i-1] + dp[1][i-1];
            sum = Math.max(sum,dp[0][i]+dp[1][i]);
        }
        System.out.println((long) sum*sum);
        // display(dp);
    }
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
            
        }
    }

public static void main(String[] args) throws Exception {
    // write your code here
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();
    dpSoln(38);

 }

}