import java.util.ArrayList;
import java.util.List;
// dabccd  // cadcbc

public class RestoreIpAddress {

    public List<String> restoreIpAddresses(String s) {

        list = new ArrayList<>();
        helper(s, 0, "", 4);
        return list;
    }

    List<String> list;

    public void helper(String str, int idx, String ans, int split) {

        if (idx == str.length() && split == 0) {
            list.add(ans);
            return;
        }
        if (split == 0 || idx == str.length())
            return;

        if (str.charAt(idx) == '0') {
            helper(str, idx + 1, ans + (ans == "" ? "0" : ".0"), split - 1);
        } else {
            for (int i = idx; i < str.length(); i++) {
                String substr = str.substring(idx, i + 1);
                String temps = (ans + (ans == "" ? substr : "." + substr));
                if (Integer.parseInt(substr) <= 255)
                    helper(str, i + 1, temps, split - 1); // 4
                if (i - idx == 2)
                    break;
            }
        }
    }

    // 2
    // 25525511135
    public static void main(String[] args) {
        String s = "25525511135"; // split 4 | 0 <= x <= 255
        // restoreIpAddresses(s);

    }
}
