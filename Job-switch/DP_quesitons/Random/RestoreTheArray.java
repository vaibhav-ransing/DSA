package Random;

import java.util.HashMap;

public class RestoreTheArray {

    private static final int MOD = 1000000007;

    public static int numberOfArrays(String s, int k) {
        HashMap<String, Long> map = new HashMap<>();
        return (int) helepr(s, k, map);
    }

    public static long helepr(String str, int k, HashMap<String, Long> map) {
        if (str.length() == 0)
            return 1;
        if (str.charAt(0) == '0')
            return 0;
        if (map.getOrDefault(str, 0L) != 0)
            return map.get(str);
        long count = 0;
        for (int i = 1; i <= str.length(); i++) {
            if (Long.parseLong(str.substring(0, i)) <= k) {
                count = (count + helepr(str.substring(i), k, map)) % MOD;
            } else {
                break;
            }
        }
        map.put(str, count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArrays("555", 55));
    }
}
