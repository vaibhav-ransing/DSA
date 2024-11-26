package AALastGo.String;

import java.util.*;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (sb.length() + word.length() <= maxWidth) {
                sb.append(word +" ");
            } else {
                String paddedWord = addPadding(sb.toString(), maxWidth);
                ans.add(paddedWord);
                sb = new StringBuilder(word);
                
            }
        }
        ans.add(sb.toString());
        return ans;
    }

    public String addPadding(String word, int width) {
        String[] words = word.split(" ");
        int count = words.length - 1;
        if (count == 0) {
            String spaces = " ".repeat(width - word.length());
            return word + spaces;
        }
        int totalFreeSpace = width - word.length();
        int padding = totalFreeSpace / count;
        int extaSpace = totalFreeSpace % count;

        StringBuilder sb = new StringBuilder();

        String spacesInBtween = " ".repeat(padding);
        
        for (String w : words) {
            if (extaSpace-- > 0) {
                sb.append(w + spacesInBtween + " ");
            } else {
                sb.append(w + spacesInBtween);
            }
        }
        
        return sb.toString().trim();
    }
}
