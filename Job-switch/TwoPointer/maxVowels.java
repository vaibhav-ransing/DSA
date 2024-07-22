import java.util.*;

public class maxVowels {

    HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public int maxVowels(String s, int k) {

        int i = 0, j = 0;
        int count = 0, ans = 0;

        while (j < s.length()) {
            while (j - i < k) {
                char ch = s.charAt(j);
                if (set.contains(ch))
                    count++;
                j++;
            }
            ans = Math.max(ans, count);
            if(set.contains(s.charAt(i)))
                count--;
            i++;

        }
        return ans;
    }
}
