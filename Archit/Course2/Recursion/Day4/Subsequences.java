import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsequences {

    public List<String> AllPossibleStrings(String s) {
        List<String> res = getSubseq(s, 0);
        Collections.sort(res); // lexico order sorted
        res.remove(0);  // empty subseqeunce ignored
        return res;
    }

    public List<String> getSubseq(String s, int idx) {

        if (idx == s.length()) {
            List<String> res = new ArrayList<>();
            res.add("");  // add empty string (Very imp)
            return res;
        }

        List<String> res = getSubseq(s, idx + 1); // no call

        // yes call is done here  (Remaining work)
        int size = res.size();
        for (int i = 0; i < size; i++) {
            String cv = s.charAt(idx) + res.get(i);
            res.add(cv);
        }

        return res;
    }

    //  Pre-order work
    public static void printSubseq(String s, String ans, int idx) {
        if (idx == s.length()) {
            System.out.println(ans);
            return;
        }
        // pre-order
        printSubseq(s, ans, idx + 1);  // we skipped the idx char that is done in pre-order
        printSubseq(s, ans + s.charAt(idx), idx + 1); // we added the current char and then called for the next index
    } 

    public static void main(String[] args) {
        printSubseq("abc", "", 0);
    }
}