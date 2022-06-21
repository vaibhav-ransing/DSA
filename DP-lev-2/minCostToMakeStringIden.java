public class minCostToMakeStringIden {
    


    static void solution(String s1, String s2, int c1, int c2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                

                if(i==0 && j==0){
                    dp[i][j]=0;
                }else if(i==0){
                    dp[i][j]+=c2+dp[i][j-1];
                }else if(j==0){
                    dp[i][j]+= c1+dp[i-1][j];
                }else{
                    char ch1 = s1.charAt(i-1);
                    char ch2 = s2.charAt(j-1);
                    if(ch1==ch2){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        int rci = dp[i-1][j]+c1;
                        int rcj = dp[i][j-1] + c2;
                        int mid = dp[i-1][j-1]+c1+c2;
                        dp[i][j] = Math.min(Math.min(rci, rcj), mid);
                    }
                }
                
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }

    public static void asciSoln(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 && j==0){
                    dp[i][j]=0;
                }else if(i==0){
                    char cj = s2.charAt(j-1);
                    int vj = (int) cj;
                    dp[i][j] = dp[i][j-1]+vj;
                }else if(j==0){
                    char ci = s1.charAt(i-1);
                    dp[i][j] = dp[i-1][j]+ (int) ci;
                }else{
                    char cj = s2.charAt(j-1);
                    int vj = (int) cj;
                    char ci = s1.charAt(i-1);
                    int vi = (int) ci;

                    if(ci==cj){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        int left = dp[i][j-1]+vj;
                        int up = dp[i-1][j]+ vi;
                        dp[i][j] = Math.min(left, up);
                    }
                }
            }
        }
        // System.out.println(dp[dp.length-1][dp[0].length-1]);
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }

    }



    public static void main(String[] args) {
        // solution("sea", "eat", 10, 7);
        asciSoln("sea", "eat");
        System.out.println();
        System.out.println("a = "+(int)'a');
        System.out.println("e = "+(int)'e');
        System.out.println("s = "+(int)'s');
        System.out.println("t = "+(int)'t');

    }
}
