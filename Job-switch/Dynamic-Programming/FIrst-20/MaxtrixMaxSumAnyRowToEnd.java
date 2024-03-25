import java.util.Arrays;

public class MaxtrixMaxSumAnyRowToEnd {

    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];

        for (int d[] : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int ans = recursion(0, i, dp, matrix);
            max = Math.max(max, ans);
        }
        return max;
    }

    public static int recursion(int row, int col, int[][] dp, int[][] matrix) {
        if (row == matrix.length - 1)
            return matrix[row][col];

        if (row < 0 || row == matrix.length ||
                col < 0 || col == matrix[0].length)
            return Integer.MIN_VALUE;

        if (dp[row][col] != Integer.MIN_VALUE)
            return dp[row][col];

        int leftCol = recursion(row + 1, col - 1, dp, matrix);
        int frontCol = recursion(row + 1, col, dp, matrix);
        int rightCol = recursion(row + 1, col + 1, dp, matrix);

        int max = Math.max(leftCol, Math.max(frontCol, rightCol));

        return dp[row][col] = matrix[row][col] + max;
    }

    // Tabulation
    // Fill the dp first row with matrix first row
    // start from 1st row and call for
    // dp[i][col] = matrix[i][col] + max(dp[i-1][col-1], dp[i-1][col],
    // dp[i-1][col+1])

    public static int tabulation(int[][] matrix) {
        int pre[] = matrix[0].clone();
        int n = matrix[0].length;
        for (int row = 1; row < matrix.length; row++) {
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                int topLeft = i == 0 ? 0 : pre[i - 1];
                int top = pre[i];
                int topRight =  i== n - 1 ? 0 : pre[i + 1];
                
                int tempMax = Math.max(top, Math.max(topLeft, topRight));
                temp[i] = matrix[row][i] + tempMax;
                if(row == 1)
                    System.out.println(temp[i]);
            }
            System.out.println(Arrays.toString(pre));
            System.out.println(Arrays.toString(temp));
            System.out.println();
            pre = temp;
        }

        return Arrays.stream(pre).max().orElse(Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 10, 4},
            {100, 3, 2, 1},
            {1, 1, 20, 2},
            {1, 2, 2, 1}
        };
        tabulation(matrix);
        
    }
}
