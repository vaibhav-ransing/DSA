package Partition_DP;

import java.util.Arrays;
import java.util.List;

public class PalindromePartition2 {
    // public List<List<String>> partition(String s) {

    // }

    public static int minCut(String str) {
        int[][] dp = new int[str.length()][str.length()];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return recursion(0, 0, str, dp);
    }

    public static int recursion(int preIdx, int currIdx, String str, int[][] dp) {
        // aab
        if (currIdx == str.length() && preIdx == str.length())
            return 0;
        if (currIdx == str.length()) {
            if (isPalindrome(str, preIdx, currIdx - 1))
                return 0;
            return 9999;
        }
        if(dp[preIdx][currIdx] != -1)
            return dp[preIdx][currIdx];
            
        int skip = recursion(preIdx, currIdx + 1, str, dp);
        int take = 9999;
        if (isPalindrome(str, preIdx, currIdx)) {
            take = 1 + recursion(currIdx + 1, currIdx + 1, str, dp);
        }
        return dp[preIdx][currIdx] = Math.min(skip, take);
    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
}
