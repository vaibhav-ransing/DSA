public class longestPalSubstr {
    
    static void dpSoln(String s){
        int n = s.length();
        boolean dpBool[][] = new boolean[n][n];
        // int dp[][] = new int[n][n];

        for(int gap=0;gap<n;gap++){
            for(int i=0, j=gap; j<n;j++,i++){
                if(gap==0){
                    // dp[i][j]=1;
                    dpBool[i][j]= true;
                }else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        // dp[i][j]=2;
                        dpBool[i][j]= true;
                    }
                    // else
                    //     dp[i][j]=1;

                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        if(dpBool[i+1][j-1]){
                            // dp[i][j] = (j-i)+1;
                            dpBool[i][j]=true;
                        }
                        // else
                        //     dp[i][j] = 1;
                        }
                    // else 
                    //     dp[i][j] = 1;
                }
            }
        }
        int max=0;
        for(int gap=0;gap<n;gap++){
            for(int i=0, j=gap; j<n;j++,i++){
                if(dpBool[i][j])
                    max = Math.max(max, j-i+1);
            }
        }
        System.out.println(max);
    }
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        String s = "abccbc";
        dpSoln(s);
    }
}
