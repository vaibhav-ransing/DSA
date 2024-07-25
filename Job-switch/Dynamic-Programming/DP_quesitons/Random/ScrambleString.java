package Random;

import java.util.HashMap;

public class ScrambleString {

    public static boolean isScramble(String s1, String s2) {
        HashMap<String, Boolean> map = new HashMap<>();
        boolean ans = helper(s1, s2, map);
        System.out.println(map.size());
        return ans;
    }

    public static boolean helper(String s1, String s2, HashMap<String, Boolean> map) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        // gr eat | rg eat
        // g r | r g
        String key = s1 + "-" + s2;
        if (map.containsKey(key))
            return map.get(key);

        boolean ans = false;
        for (int i = 1; i < s1.length(); i++) {
            boolean dont_swap = (helper(s1.substring(0, i), s2.substring(0, i), map) &&
                    helper(s1.substring(i), s2.substring(i), map));

            boolean swap = (helper(s1.substring(0, i), s2.substring(s2.length() - i), map) &&
                    helper(s1.substring(i), s2.substring(0, s2.length() - i), map));

            ans |= dont_swap;
            ans |= swap;
        }
        map.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        isScramble(s1, s2);
        // int i = 1;
        // System.out.println(s1.substring(0, i) + " - " + s2.substring(s2.length() -
        // i));
        // System.out.println(s1.substring(i) + " _ " + s2.substring(0, s2.length() -
        // i));
    }

}