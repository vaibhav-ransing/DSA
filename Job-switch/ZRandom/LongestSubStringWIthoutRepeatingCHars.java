package ZRandom;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWIthoutRepeatingCHars {

    public int lengthOfLongestSubstring(String str) {
        if (str.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 1;
        int max = 0;
        set.add(str.charAt(0));
        while (j < str.length()) {
            char ch = str.charAt(j);
            if (set.contains(ch)) {
                while (set.contains(ch)) {
                    set.remove(str.charAt(i++));
                }
            }
            set.add(ch);
            j++;
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int maxLength = 0;
            Set<Character> charSet = new HashSet<>();
            int left = 0;

            for (int right = 0; right < n; right++) {
                if (!charSet.contains(s.charAt(right))) {
                    charSet.add(s.charAt(right));
                    maxLength = Math.max(maxLength, right - left + 1);
                } else {
                    while (charSet.contains(s.charAt(right))) {
                        charSet.remove(s.charAt(left));
                        left++;
                    }
                    charSet.add(s.charAt(right));
                }
            }

            return maxLength;
        }
    }
}
