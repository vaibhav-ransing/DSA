public class MinWindowSubstring {

    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length())
                return "";

            int[] map = new int[128];
            int count = t.length();
            int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;

            for (char c : t.toCharArray())
                map[c]++;

            while (end < s.length()) {
                if (map[s.charAt(end++)]-- > 0)
                    count--;

                while (count == 0) {
                    if (end - start < minLen) {
                        minStart = start;
                        minLen = end - start;
                    }

                    if (map[s.charAt(start++)]++ == 0)
                        count++;
                }
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }
    }

    public boolean check(int[] freq, int[] running) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > running[i])
                return false;
        }
        return true;
    }

    private int getIndex(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        } else if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A' + 26;
        } else {
            throw new IllegalArgumentException("Unsupported character: " + ch);
        }
    }

    public String minWindow(String str, String pat) {

        int[] freq = new int[52];
        for (char ch : pat.toCharArray()) {
            freq[getIndex(ch)]++;
        }
        int[] arr = new int[52];
        int i = 0, j = 0;
        String ans = "";
        while (j < str.length()) {

            char ch = str.charAt(j);
            arr[getIndex(ch)]++;

            while (check(freq, arr)) {
                String subStr = str.substring(i, j + 1);
                if (ans.length() == 0) {
                    ans = subStr;
                } else {
                    ans = subStr.length() < ans.length() ? subStr : ans;
                }
                char chi = str.charAt(i);
                arr[getIndex(chi)]--;
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinWindowSubstring mws = new MinWindowSubstring();
        String str = "ADOBECODEBANC";
        String pat = "ABC";
        System.out.println(mws.minWindow(str, pat)); // Output should be "BANC"
    }
}
