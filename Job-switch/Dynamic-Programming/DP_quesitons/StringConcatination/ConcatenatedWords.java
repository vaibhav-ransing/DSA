package StringConcatination;

import java.util.*;

public class ConcatenatedWords {
    

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>();
        
        for(String word : words){
            set.add(word);
        }
        List<String> ans = new ArrayList<>();
        for(String word : words){
            int dp[] = new int[word.length()];

            // remove the word an check if it is possible to make that word using other given words
            set.remove(word);
            Arrays.fill(dp, -1);
            if(helper(word, 0, set, dp)){
                ans.add(word);
            }

            // add the word back
            set.add(word);
        }
        return ans;
    }

    // Exact same as Word Break
    public static boolean helper(String str, int idx, HashSet<String> set, int dp[]) {

        if (idx == str.length() || set.contains(str)) {
            return true;
        }
        if (dp[idx] != -1)
            return dp[idx] == 1;
        boolean ans = false;
        for (int i = idx; i < str.length(); i++) {

            String temp = str.substring(idx, i + 1);
            if (set.contains(temp)) {
                ans |= helper(str, i + 1, set, dp);
            }
        }
        dp[idx] = ans ? 1 : 0;
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
