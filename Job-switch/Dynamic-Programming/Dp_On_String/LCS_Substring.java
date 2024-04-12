import java.util.Arrays;
import java.util.stream.Collectors;

public class LCS_Substring {

    // https://leetcode.com/problems/maximum-length-of-repeated-subarray/

    public static int longestCommonSubString(String text1, String text2) {

        int n = text1.length() + 1;
        int m = text2.length() + 1;
        int[][] dp = new int[n][m];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = Arrays.stream(dp).flatMapToInt(row -> Arrays.stream(row)).max().getAsInt();
        return max;
    }

    // Leetcode
    public int findLength(int[] nums1, int[] nums2) {

        int n = nums1.length + 1;
        int m = nums2.length + 1;
        int[][] dp = new int[n][m];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = Arrays.stream(dp).flatMapToInt(row -> Arrays.stream(row)).max().getAsInt();
        return max;
    }

    public static void main(String[] args) {
        String s = "adebc";
        String t = "dcadbfff";

        // longestCommonSubString(t, s);

        int[] array = { 1, 2, 3 };
        String result = Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(result);

    }
}
