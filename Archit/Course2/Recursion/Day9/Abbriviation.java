package Day9;

import java.util.ArrayList;
import java.util.Collections;

public class Abbriviation {

    static ArrayList<String> ans;

    public static ArrayList<String> findAbbr(String str) {
        ans = new ArrayList<>();
        solution(str, 0, 0, "");
        Collections.sort(ans);
        return ans;
    }

    public static void solution(String word, int idx, int curr_count, String asf) {

        if (idx == word.length()) {
            if (curr_count != 0) {
                System.out.println(asf + curr_count);
                // ans.add(asf + curr_count);
            } else {
                System.out.println(asf);
                // ans.add(asf);
            }
            return;
        }
        solution(word, idx + 1, curr_count + 1, asf);
        solution(word, idx + 1, 0, curr_count == 0 ? asf + word.charAt(idx) : asf + curr_count + word.charAt(idx));
        
    }

    public static void main(String[] args) {
        solution("ab", 0, 0, "");
    }
}
