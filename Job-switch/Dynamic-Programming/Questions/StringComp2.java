package Questions;

import java.util.Arrays;
import java.util.HashMap;

public class StringComp2 {

    HashMap<String, Integer> map = new HashMap<>();

    public int getLengthOfOptimalCompression(String str, int k) {
        // char[] charArray = str.toCharArray();
        // Arrays.sort(charArray);
        // String s = new String(charArray);
        // return rec(0, 0, 'A', s, k);
        return rec(0, 0, 'A', str, k);
    }

    // aabbaa
    public int rec(int idx, int prevCount, char prevChar, String str, int k) {

        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        if (idx == str.length()) {
            return 0;
        }
        String cs = idx + "-" + prevCount + "-" + prevChar + "-" + k;
        if (map.containsKey(cs))
            return map.get(cs);
        char currCh = str.charAt(idx);
        int take = Integer.MAX_VALUE;
        int del = Integer.MAX_VALUE;

        // take
        if (idx == 0 || prevChar != currCh) { // prev is not same as current
            take = 1 + rec(idx + 1, 1, currCh, str, k);
        } else {
            int count = 0;
            if (prevCount == 1 || prevCount == 9 || prevCount == 99) {
                count++;
            }
            take = count + rec(idx + 1, prevCount + 1, currCh, str, k);
        }

        // del
        del = rec(idx + 1, prevCount, prevChar, str, k - 1);

        map.put(cs, Math.min(take, del));
        return Math.min(take, del);
    }
}
