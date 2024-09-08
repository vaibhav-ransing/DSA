import java.util.HashSet;

public class SplitStringToMaxUniqueSubstring {

    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        return helper(0, s, set);
    }

    public int helper(int idx, String str, HashSet<String> set) {
        if (idx == str.length())
            return 0;
        int ans = 0;
        for (int i = idx; i < str.length(); i++) {
            if (!set.contains(str.substring(idx, i + 1))) {
                set.add(str.substring(idx, i + 1));
                int rec = 1 + helper(i + 1, str, set);
                set.remove(str.substring(idx, i + 1));

                ans = Math.max(ans, rec);
            }
        }
        return ans;
    }
}
