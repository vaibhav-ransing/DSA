public class StrangePrinter {

    public static int strangePrinter(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        return helper(s, 0, n - 1, memo);
    }

    public static int helper(String str, int left, int right, int[][] memo) {
        if (left == right)
            return 1;

        if (left > right)
            return 0;

        if (memo[left][right] != 0) 
            return memo[left][right];

        int ans = 1 + helper(str, left + 1, right, memo); // Printing str[left] separately

        // aabcbad
        // aaa
        for (int i = left + 1; i <= right; i++) {
            if (str.charAt(left) == str.charAt(i)) {
                // I was doing left + 1 -> i-1 and i + 1 -> right
                // this is incorrect because at least one of the two calls has to hold at least one of the same characters
                // i.e. aba here left = 0 and right = 2
                // temp = helper(1, 0) + helper(2,2) -> 0 + 1 = 1
                // we technically just ignore the fact that a also exist so either not do left + 1 or not do i+1 (both cannot be there)
                int temp = helper(str, left + 1, i - 1, memo) + helper(str, i, right, memo); 
                ans = Math.min(ans, temp);
            }
        }

        memo[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(strangePrinter("aba"));  // Output should be 2
    }
}
