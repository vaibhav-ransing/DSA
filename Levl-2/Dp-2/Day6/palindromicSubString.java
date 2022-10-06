package Day6;

import javax.sound.midi.Track;

public class palindromicSubString {
    

    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[s.length()][s.length()];
        int len=0, count=0;
        int start = 0;
        int end = 0;
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; j<n; i++,j++){
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if(gap==0){
                    dp[i][j] = true;
                }else if(gap==1){
                    dp[i][j] = ci==cj;
                }else{
                    boolean mid = dp[i+1][j-1];
                    dp[i][j] = (ci==cj) && mid;
                }
                if(dp[i][j]){
                    int currLen = j-i+1;
                    if(currLen>len){
                        len = currLen;
                        start = i;
                        end=j; 
                    }
                    count++;
                }
            }
        }
        
        return count;
    }



    public static void main(String[] args) {
        
    }
}
