package Lc_Contests.Contest407;

import java.util.Arrays;
import java.util.HashSet;

public class VowelGameInString {

    public boolean doesAliceWin(String s) {
        for(char ch : s.toCharArray()){
            if(set.contains(ch))
                return true;
        }
        // return false;
        return helper(0, s, 1);
    }

    HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public boolean helper(int idx, String str, int alice) {
        if (idx == str.length()) {
            return alice == 1;
        }

        // alice turn
        if (alice == 1) {
            int count = 0;
            for (int i = idx; i < str.length(); i++) {
                if (set.contains(str.charAt(i))) {
                    count++;
                }
                if ((count & 1) == 1) {
                    boolean alWin = helper(i + 1, str, 0);
                    if (alWin)
                        return true;
                }
            }
        } else { // bob turn
            int count = 0;
            for (int i = idx; i < str.length(); i++) {

                if (set.contains(str.charAt(i))) {
                    count++;
                }
                if((count & 1) == 0){
                    boolean bobWin = helper(i+1, str, 1);
                    if(!bobWin)
                        return false;
                }
                
            }
            return true;
        }
        return false;
    }
}
