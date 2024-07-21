package Stack;

import java.util.*;

public class MaximalRectangle {

    public static int largestRectangleArea(int[] heights) {
        int[] left = smallerToLeft(heights);
        int[] right = smallerToRight(heights);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = right[i] - left[i] + 1;
            int area = width * heights[i];
            max = Math.max(max, area);
        }
        System.out.println(max);
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

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        largestRectangleArea(arr);
    }
}