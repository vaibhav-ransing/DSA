import java.util.Scanner;

public class climbStairs {  
    
    static int rec(int n){
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        
        return rec(n-1)+rec(n-2)+rec(n-3);
    }
    static void dp(int n){
        int dp[]= new int[n+1];

        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            dp[i] = dp[i-1];
            if(i-2>=0)
                dp[i]+=dp[i-2];
            if(i-3>=0)  
                dp[i]+=dp[i-3];
        }
        // for(int i=0;i<dp.length;i++)
        //     System.out.print(dp[i]+" ");
        System.out.println(dp[dp.length-1]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(rec(4));
        dp(4);
    }
}
