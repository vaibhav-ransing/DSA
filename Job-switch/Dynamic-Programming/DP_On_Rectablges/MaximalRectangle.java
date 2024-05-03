package DP_On_Rectablges;
import java.util.Arrays;

public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {

        int m = matrix[0].length;
        int n = matrix.length;

        int[] dp = new int[m];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(matrix[i][j]);
                if (matrix[i][j] == '1')
                    dp[j]+=1;
                else
                    dp[j] = 0;
            }
            System.out.println(Arrays.toString(dp));
            max = Math.max(max, largestRectangleArea(dp));
        }
        return max;
    }

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;
    
        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
    
            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
    
        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
    
            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
    
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
    
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };

        System.out.println('1' + '1');

    }
}