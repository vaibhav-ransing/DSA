import java.util.Arrays;

public class GridUniquePath {

    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int[][] dp = new int[m][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int ans = recursion(0, 0, dp);
        System.out.println(ans);
        return ans;
    }

    static int[][] dir = { { 0, 1 }, { 1, 0 } }; // , { 0, -1 }, { -1, 0 }

    public static int recursion(int row, int col, int[][] dp) {
        if (row == dp.length - 1 && col == dp[0].length - 1) {
            return 1;
        }

        if (row < 0 || row >= dp.length || col < 0 || col >= dp[0].length)
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];

        int count = 0;

        for (int d[] : dir) {
            int rr = row + d[0];
            int cc = col + d[1];
            count += recursion(rr, cc, dp);
        }
        return dp[row][col] = count;
    }

    public static int tabulation(int m, int n) {
        int pre[] = new int[n];
        Arrays.fill(pre, 1);

        for (int row = m - 1; row > 0; row--) {
            int temp[] = new int[n];
            temp[n - 1] = 1;
            System.out.println(Arrays.toString(pre));
            for (int i = n - 2; i >= 0; i--) {
                temp[i] = temp[i + 1] + pre[i];
            }
            System.out.println(Arrays.toString(temp));
            System.out.println("---------");
            pre = temp;
        }
        System.out.println("ans " + pre[0]);
        return pre[0];
    }

    public static void main(String[] args) {
        tabulation(3, 7);
    }
}