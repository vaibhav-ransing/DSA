import java.util.HashMap;

public class StringPermutation {

    public static void printPermutation(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        helper(str, map, 0, "");
    }

    public static void helper(String str, HashMap<Character, Integer> map, int itemUsed, String asf) {

        if (itemUsed == map.size()) {
            System.out.println(asf);
            return;
        }
        if(asf.length() > str.length())
            return;

        for (char ch : map.keySet()) {
            if (map.get(ch) > 0) {
                map.put(ch, (map.get(ch) - 1));
                helper(str, map, itemUsed + 1, asf + ch);
                map.put(ch, (map.get(ch) + 1));
            }
        }
        helper(str, map, itemUsed, asf + "_");
    }

    public static void main(String[] args) {
        // aabb
        printPermutation("aabb");
    }
}
