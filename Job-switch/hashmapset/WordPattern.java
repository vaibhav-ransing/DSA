import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;
        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if(map.containsKey(word) && !(map.get(word) == ch) || map2.containsKey(ch) && !map2.get(ch).equals(word)){
                return false;
            }
            map.put(word, ch);
            map2.put(ch, word);
        }
        return true;
    }
}
