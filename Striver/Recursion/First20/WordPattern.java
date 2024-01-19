package First20;

import java.util.HashMap;

public class WordPattern {

    public static void solution(String a, String b) {
        HashMap<Character, String> map = new HashMap<>();
        helper(a, b, map);
    }

    public static void helper(String small, String big, HashMap<Character, String> map) {
        if (small.length() == 0 && big.length() == 0) {
            for (char key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
            System.out.println("-----------");
            return;
        }
        if (small.length() == 0 && big.length() != 0 || small.length() != 0 && big.length() == 0) {
            return;
        }
        char ch = small.charAt(0);
        if (map.containsKey(ch)) {
            String charAssignedStr = map.get(ch);
            if (big.length() < charAssignedStr.length()) {
                return;
            }
            if (!charAssignedStr.equals(big.substring(0, charAssignedStr.length()))) {
                return;
            } else {
                helper(small.substring(1), big.substring(charAssignedStr.length()), map);
            }
        } else {
            for (int i = 0; i < big.length(); i++) {
                map.put(ch, big.substring(0, i + 1));
                helper(small.substring(1), big.substring(i + 1), map);
                map.remove(ch);
            }
        }
    }

    public static void main(String[] args) {
        solution("abcb", "mazddytzaddy");
    }
}