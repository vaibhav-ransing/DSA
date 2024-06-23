public class RepeatedSubStringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // if ((n & 1) == 1)
        //     return false;
        for (int i = n / 2; i > 0; i--) {
            // s = 12
            // i = 6
            if (n % i != 0)
                continue;
            StringBuilder sb = new StringBuilder();
            int repeat = n / i;
            while (repeat-- > 0) {
                sb.append(s.substring(0, i));
            }
            if(sb.toString().equals(s))
                return true;
        }
        return false;
    }
    // "babbabbabbabbab"

    public boolean helper(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        boolean split_s1 = helper(s1.substring(0, s1.length() >> 1), s1.substring((s1.length() >> 1)));
        boolean split_s2 = helper(s2.substring(0, s2.length() >> 1), s2.substring((s2.length() >> 1)));

        return split_s1 && split_s2;
    }

}
