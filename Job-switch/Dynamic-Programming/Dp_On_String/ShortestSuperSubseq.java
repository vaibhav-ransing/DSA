import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ShortestSuperSubseq {

    public static String shortestSupersequence(String s1, String s2) {
        // Write your code here..
        String lcs_str = getLCS_String(s1, s2);
        String s1Rem = subtractString(s1, lcs_str);
        String s2Rem = subtractString(s2, lcs_str);

        return (s1Rem + s2Rem + lcs_str);
    }

    public static String getLCS_String(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        String dp[][] = new String[n + 1][m + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, ""));

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }

        return dp[n][m];
    }

    public static String subtractString(String parent, String child) {

        Map<Character, Long> map = child.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        String finalString = "";
        for (char ch : parent.toCharArray()) {
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                finalString += ch;
            }
        }

        return finalString;
    }

    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        System.out.println(shortestSupersequence(s1, s2));
    }

}
