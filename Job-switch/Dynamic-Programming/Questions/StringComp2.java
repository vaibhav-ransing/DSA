package Questions;

public class StringComp2 {
    public int getLengthOfOptimalCompression(String s, int k) {
        return rec(0, 0, 'A', s, k);
    }

    public int rec(int idx, int prevCount, char prevChar, String str, int k) {
        if (idx == str.length()) {
            return 0;
        }
        if (k == 0) {
            return Integer.MAX_VALUE;
        }

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

        return Math.min(take, del);
    }
}
