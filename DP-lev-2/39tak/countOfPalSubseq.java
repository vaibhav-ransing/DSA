import java.util.HashMap;

public class countOfPalSubseq {
    
    static void solution(String s){
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        
        for(int gap=1; gap<dp.length; gap++){
            for(int i=1, j=gap; j<dp.length; j++, i++){
                char ci = s.charAt(i-1);
                char cj = s.charAt(j-1);
                if(gap==1){
                    dp[i][j]=1;
                }else if(gap==2){
                    dp[i][j] = ci==cj?3:2;
                }else{
                    int left = dp[i][j-1];
                    int right = dp[i+1][j];
                    int mid = dp[i+1][j-1];
                    dp[i][j] = left+right-mid;
                    dp[i][j]+= ci==cj?1:0;
                }
            }
        }
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    
    static void solution2(String s){
        int n = s.length();
        int dp[][] = new int[n][n];
        
        for(int gap=0; gap<dp.length; gap++){
            for(int i=0, j=gap; j<dp.length; j++, i++){
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1){
                    dp[i][j] = ci==cj?3:2;
                }else{
                    int left = dp[i][j-1];
                    int right = dp[i+1][j];
                    int mid = dp[i+1][j-1];
                    dp[i][j] = left+right-mid;
                    dp[i][j] += ci==cj?1:0;
                }
            }
        }
        System.out.println(dp[0][dp.length-1]);
        for(int d[]: dp){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    
    static void countOfDiffSubseq(String s){
        int n = s.length();
        int dp[] = new int[n+1];
        dp[0]=1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=1;i<=n; i++){
            char ch =s.charAt(i-1);
            if(map.containsKey(ch)){
                int j = map.get(ch);
                dp[i] = 2*dp[i-1] - dp[j-1];
            }else{
                dp[i] = 2*dp[i-1];
            }
            map.put(ch, dp[i]);
        }
        for(int i=0; i<=n; i++)
            System.out.print(dp[i]+" ");
    }
    
    static void countOFDistinctPalSubseq(String s){

    }



    public static void main(String[] args) {
        solution2("abacb");
        // countOfDiffSubseq("abc");
    }
}
