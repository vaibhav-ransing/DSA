import java.util.Scanner;

public class paintHouse {
    
    static void dpSoln(int red[] , int blue[],int green[]){
        int n = red.length;
        int dp[][] = new int[3][n];
        dp[0][0] = red[0];
        dp[1][0] = blue[0];
        dp[2][0] = green[0];

        for(int i=1; i<red.length;i++){
            dp[0][i] = Math.min(red[i]+dp[1][i-1], red[i]+dp[2][i-1]);
            dp[1][i] = Math.min(blue[i]+ dp[0][i-1], blue[i]+dp[2][i-1]);
            dp[2][i] = Math.min(green[i]+ dp[0][i-1], green[i]+dp[1][i-1]);
        }
        display(dp);
    }
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
            
        }
    }

    public static void main(String[] args) {
        // int red[]= {1,5,3,1};
        // int blue[]= {5,8,2,2};
        // int green[]= {7,4,9,4};
        // dpSoln(red, blue, green);
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int red[] = new int[n];
        int blue[] = new int[n];
        int green[] = new int[n];
        for(int i=0;i<n;i++){
            red[i] = sc.nextInt();
            blue[i] = sc.nextInt();
            green[i] = sc.nextInt();
        }
        dpSoln(red, blue, green);
    }
}
