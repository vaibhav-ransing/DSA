import java.util.Arrays;

public class NinjaTraining {

    public static int ninjaTraining(int n, int points[][]) {

        return dpSoln(n, points);
    }

    public static int dpSoln(int n, int points[][]) {

        int dp[] = points[0].clone();

        System.out.println(Arrays.toString(dp));
        int dpTemp[] = dp.clone();
        for (int row = 1; row < n; row++) {
            int arr[] = points[row];
            dpTemp = dp.clone();
            for (int j = 0; j < 3; j++) {
                int takeJ_point = arr[j] + getMax(dpTemp, j);
                dp[j] = Math.max(dp[j], takeJ_point);
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(Arrays.toString(dp));
        return Math.max(dp[0], Math.max(dp[1], dp[2]));
    }

    public static int getMax(int[] arr, int skipIdx) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = (i == skipIdx) ? max : Math.max(max, arr[i]);
        }
        return max;
    }

    public static int recursion(int row, int last, int[][] points, int dp[][]) {
        if (dp[row][last] != -1)
            return dp[row][last];

        if (row == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < points[0].length; i++) {
                max = i == last ? max : Math.max(max, points[0][i]);
            }
            return max;
        }
        
        int max = 0;
        for (int i = 0; i < 3; i++) {
            
            int takeIthVal = i == last ? 0 : (points[row][i] + recursion(row - 1, i, points, dp));
            max = Math.max(max, takeIthVal);
        }
        return dp[row][last] = max;
    }

    public static void main(String[] args) {
        // int[][] points = {{10,40,70}, {20,50,80}, {30,60,90}};
        int[][] points = { { 1, 2, 5 },
                { 3, 1, 1 },
                { 3, 3, 3 } };
        int n = points.length;

        int dp[][] = new int[n][4];
        for (int d[] : dp)
            Arrays.fill(d, -1);

        // ninjaTraining(3, points);
        System.out.println(recursion(points.length - 1, 3, points, dp));
        for (int d[] : dp) {
            System.out.println(Arrays.toString(d));
        }
    }
}
