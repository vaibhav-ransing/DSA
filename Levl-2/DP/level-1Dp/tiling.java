import javax.swing.text.StyleConstants;

public class tiling{

    static void soln(int n){
        // fibonacchi
    }
    static void mlenTiles(int n, int m){
        int dp[] = new int[n+1];
        for(int i=1;i<dp.length;i++){
            
            if(i<m){
                dp[i]=1;
            } else if(i==m){
                dp[i]=2;
            }else{
                dp[i] = dp[i-1]+dp[i-m];
            }
            
        }
        for(int i=0;i<dp.length;i++)
            System.out.print(dp[i]+" ");
    }

    public static void main(String[] args) {
        mlenTiles(39, 16);
    }
}