import java.util.*;

public class CountCompleteSubstring {

    public int countCompleteSubstrings(String word, int k) {
        int[] freq = new int[26];
        int i = 0, j = 0, max = 0;
        while (j < word.length()) {
            char ch = word.charAt(j);
            freq[ch - 'a']++;
            boolean[] allEqlK_valLessThanK = helper(freq, k);
            if (allEqlK_valLessThanK[0]) {
                max = Math.max(max, j - i + 1);
            } else if (allEqlK_valLessThanK[1] == false) {
                while (!helper(freq, k)[1] == true) {
                    freq[word.charAt(i) - 'a']--;
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public boolean[] helper(int[] freq, int k) { // [ all values are == k, all values are <= k ]
        boolean allValsEqualK = true;
        for (int v : freq) {
            if (v > k) {
                return new boolean[] { false, false };
            }
            if (v != 0 && v != k)
                allValsEqualK = false;
        }
        return new boolean[] { allValsEqualK, true };
    }

}