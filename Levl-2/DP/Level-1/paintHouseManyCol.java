import java.util.Scanner;

public class paintHouseManyCol {
    
    static void dpSoln(int arr[][]){
        int n = arr.length;
        int k = arr[0].length;
        int dp[][] = new int[n][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                if(i==0)
                    dp[i][j] = arr[i][j];
                else{
                    int cost=Integer.MAX_VALUE;
                    for(int m=0; m<k;m++){
                        if(m==j)
                            continue;
                        cost = Math.min(cost, dp[i-1][m]);
                    }
                    dp[i][j] = cost+arr[i][j];
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<k;i++)
            min = Math.min(min, dp[n-1][i]);
            
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[][] = new int[n][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++)
                arr[i][j] = sc.nextInt();
        }
        dpSoln(arr);
    }
}
