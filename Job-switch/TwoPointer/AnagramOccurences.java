import java.util.ArrayList;
import java.util.List;

public class AnagramOccurences {

    static int search(String pat, String str) {
        int[] freq = new int[26];
        for (char ch : pat.toCharArray()) {
            freq[ch - 'a']++;
        }
        int l = 0, r = 0, count = 0;
        while (r < str.length()) {
            char chR = str.charAt(r);
            freq[chR - 'a']--;
            if (r - l + 1 == pat.length()) {
                if (allZero(freq)) {
                    count++;
                }
                freq[str.charAt(l) - 'a']++;
                l++;
            }
            r++;
        }
        return count;
    }

    static boolean allZero(int[] freq) {
        for (int v : freq) {
            if (v != 0)
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String str, String pat) {
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[26];
        for (char ch : pat.toCharArray()) {
            freq[ch - 'a']++;
        }
        int l = 0, r = 0;
        while (r < str.length()) {
            char chR = str.charAt(r);
            freq[chR - 'a']--;
            if (r - l + 1 == pat.length()) {
                if (allZero(freq)) {
                    ans.add(l);
                }
                freq[str.charAt(l) - 'a']++;
                l++;
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(search("forxxorfxdosfr", "for"));
    }
}