package Day11;

import java.util.ArrayList;
import java.util.HashSet;

public class wordBreak {
    // https://practice.geeksforgeeks.org/problems/word-break1352/1

    public static int wordBreak(String A, ArrayList<String> B ){

        HashSet<String> set = new HashSet<>();
        for(String s: B){
            set.add(s);
        }
        boolean[] dp = new boolean[A.length()];
        for(int i=0; i<A.length(); i++){
            String ss = A.substring(0, i+1);
            if(set.contains(ss)){
                dp[i] = true;
            }else{
                for(int j=1; j<i; j++){
                    String ss1 = A.substring(j, i+1);
                    if(dp[j] && set.contains(ss1)){
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[dp.length-1]==true?1:0;
    }

    public static void main(String[] args) {
        
    }
}
