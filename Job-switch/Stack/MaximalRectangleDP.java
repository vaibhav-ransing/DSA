package Stack;

import java.util.*;

public class MaximalRectangleDP {

    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i] - '0';
        }
        int max = largestRectangleArea(dp);
        for (int row = 1; row < matrix.length; row++) {
            for (int i = 0; i < n; i++) {
                if (matrix[row][i] == '0') {  // means the height is 0
                    dp[i] = 0;
                } else {
                    dp[i] += 1;
                }
            }
            max = Math.max(max, largestRectangleArea(dp));
        }
        return max;
    }

    public static int largestRectangleArea(int[] heights) {
        int[] left = smallerToLeft(heights);
        int[] right = smallerToRight(heights);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = right[i] - left[i] + 1;
            int area = width * heights[i];
            max = Math.max(max, area);
        }
        return max;
    }

    public static int[] smallerToLeft(int[] heights) {
        int n = heights.length;
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            arr[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        return arr;
    }

    public static int[] smallerToRight(int[] heights) {
        int n = heights.length;
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            arr[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }
        return arr;
    }

}
