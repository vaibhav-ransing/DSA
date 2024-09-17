package SubarryQuestions;

import java.util.HashMap;

public class FindLongestSubstringEvenVowels {

    public HashMap<Character, Integer> buildMap() {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);

        return map;
    }

    public int findTheLongestSubstring(String s) {
        // a e i o u
        int ans = 0;
        HashMap<Character, Integer> mapChar = buildMap();
        HashMap<Integer, Integer> bitMap = new HashMap<>();
        int bit = 0;
        bitMap.put(0, -1); // Important initialization for handling substrings starting at index 0
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mapChar.containsKey(ch)) {
                bit = bit ^ (1 << mapChar.get(ch));
            }
            if (bitMap.containsKey(bit)) {
                ans = Math.max(ans, i - bitMap.get(bit) + 1);
            } else {
                bitMap.put(bit, i);
            }
        }
        return ans;
    }

}
