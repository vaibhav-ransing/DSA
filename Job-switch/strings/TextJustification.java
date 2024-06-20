import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            if (ans.size() != 0) {
                if (ans.get(ans.size() - 1).length() + word.length() + 1 <= maxWidth) {
                    String updated_str = ans.get(ans.size() - 1) + word + " ";
                    ans.remove(ans.size() - 1);
                    ans.add(updated_str);
                } else {
                    ans.add(word + " ");
                }
            } else {
                ans.add(word + " ");
            }
        }
        return simulateString(ans, maxWidth);
    }

    public List<String> simulateString(List<String> list, int maxWidth) {

        List<String> ans = new ArrayList<>();
        for (String full_str : list) {
            int len = full_str.length() - 1;
            String[] arr = full_str.split(" ");

            int additonal_spaces = maxWidth - len; // 5
            int totalWords = arr.length; // 3

            int add_spaces = 0;
            int rem = 0;

            if (totalWords > 1) {
                add_spaces = additonal_spaces / (totalWords - 1);
                rem = additonal_spaces % (totalWords - 1);
            } else {
                add_spaces = additonal_spaces;
                rem = additonal_spaces;
            }

            StringBuilder sb = new StringBuilder();

            int idx = 0;
            for (String word : arr) {
                int space = (idx == word.length()) ? 0 : (add_spaces + rem + 1);
                if (space == 0) {
                    sb.append(word);
                } else {
                    sb.append(word + String.format("%" + space + "s", ""));
                }
                rem = 0;
                idx++;
            }
            ans.add(sb.toString());
        }
        return ans;
    }

}