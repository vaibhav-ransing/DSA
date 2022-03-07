import java.util.Scanner;

public class LCSpep {
    

    // static void dpSon(String s1, String s2){
    //     int dp[][] = new int[s1.length()+1][s2.length()+1];
    //     boolean firstSimilar=false;
    //     for(int i=0;i<dp.length;i++){
    //         for(int j=0;j<dp[0].length;j++){
    //             if(i==0 ||j==0 || i==1 || j==1)
    //                 dp[i][j]=1;
    //             else{
    //                 if(s1.charAt(i-1)==s2.charAt(j-1))
    //                     dp[i][j] = dp[i-1][j-1]+1;
    //                 else
    //                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    //             }
    //         }
    //     }
    //     display(dp);
    //     // System.out.println(dp[dp.length-1][dp[0].length-1]);
    // }
    static void dpSon(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        boolean firstSimilar=false;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                
            }
        }
        // display(dp);
        if(s1.length()==0 || s2.length()==0)
            System.out.println(1);
        else
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
        dpSon("ab", "");
        // Scanner sc = new Scanner(System.in);
        // String s1= sc.nextLine();
        // String s2= sc.nextLine();
        // dpSon("aadb", "ccdb");
        
    }
}
