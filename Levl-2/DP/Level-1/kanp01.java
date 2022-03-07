import java.util.Scanner;

public class kanp01 {
    
    static int knapRec(int val[], int wt[], int cap, int n, int currVal){
        
        if(cap==0 || n==0)
            return currVal;
        
        int take = 0;
        if(cap-wt[n-1]>=0)
            take= knapRec(val, wt, cap-wt[n-1], n-1,currVal+val[n-1]);
        int dontTake = knapRec(val, wt, cap, n-1, currVal);
        
        return Math.max(take, dontTake);
    }

    static void knapDP(int val[], int wt[], int cap){
        int n=val.length;
        int dp[][]= new int[n+1][cap+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<wt[i-1]){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);

                }
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
        // Scanner sc = new Scanner(System.in);
        // int n= sc.nextInt();
        // int val[]= new int[n];
        // int wt[]= new int[n];
        // for(int i=0;i<n;i++)
        //     val[i]= sc.nextInt();
        // for(int i=0;i<n;i++)
        //     wt[i]= sc.nextInt();
        // int cap = sc.nextInt();

        int val[]= {15,14,10,45,30};
        int wt[]=  {2, 5, 1, 3, 4};
        int cap=7;
        // System.out.println(knapRec(val, wt, cap, val.length, 0));
        knapDP(val, wt, cap);
    }
}
