package First10;

import java.util.HashMap;
import java.util.HashSet;

public class Cryptarithmetic {

    public static boolean isSolvable(String[] words, String result) {
        HashMap<Character, Integer> map = new HashMap<>();

        HashSet<Character> tempSet = new HashSet<>();
        StringBuilder uniqueStr = new StringBuilder();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!tempSet.contains(ch)) {
                    tempSet.add(ch);
                    uniqueStr.append(ch);
                }
            }
        }
        for (char ch : result.toCharArray()) {
            if (!tempSet.contains(ch)) {
                tempSet.add(ch);
                uniqueStr.append(ch);
            }
        }
        HashSet<Integer> set = new HashSet<>();

        return helper(words, result, uniqueStr.toString(), 0, set, map);
    }

    public static boolean helper(String[] words, String result, String uniqueStr, int idx, HashSet<Integer> set,
            HashMap<Character, Integer> map) {

        if (idx == uniqueStr.length()) {
            if (isValid(words, result, map)) {
                map.forEach((key, value) -> System.out.print(key + " : " + value +"  -  "));
                return true;
            }
            return false;
        }
        char currCh = uniqueStr.charAt(idx);
        for (int k = 0; k < 10; k++) {
            if (!set.contains(k)) {
                set.add(k);
                map.put(currCh, k);
                if (helper(words, result, uniqueStr, idx + 1, set, map)) {
                    return true;
                }

                set.remove(k);
            }
        }
        return false;
    }

    public static boolean isValid(String[] words, String result, HashMap<Character, Integer> map) {

        int count = 0;
        for (String word : words) {
            StringBuilder currWord = new StringBuilder();
            for (char ch : word.toCharArray()) {
                currWord.append(map.get(ch));
            }
            count += Integer.parseInt(currWord.toString());
        }
        String tempRes = "";
        for (char ch : result.toCharArray()) {
            tempRes += map.get(ch);
        }
        if(count == Integer.parseInt(tempRes)){
            System.out.println(count +" "+ tempRes);
        }
        return count == Integer.parseInt(tempRes);
    }

    public static void main(String[] args) {
        String[] arr = { "SEND", "MORE" };
        String result = "MONEY";
        System.out.println(isSolvable(arr, result));
    }

}