import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    int[][] memo;

    public int countSubstrings(String str) {
        int n = str.length();
        memo = new int[n][n]; // Use n instead of fixed size
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // Ensure i <= j
                if (check(i, j, str)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean check(int i, int j, String str) {
        if (i > j) {
            return true;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        if (str.charAt(i) != str.charAt(j)) {
            memo[i][j] = 0;
            return false;
        }
        boolean ans = check(i + 1, j - 1, str);
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }

}