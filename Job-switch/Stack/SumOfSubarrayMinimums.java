package Stack;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int right[] = new int[n];
        int left[] = new int[n];

        // Fill Right array
        right[n - 1] = 1;
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int cv = arr[i];
            while (stack.size() > 0 && arr[stack.peek()] > cv) {
                stack.pop();
            }
            right[i] = stack.size() == 0 ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // Fill Left Array
        stack.clear();
        left[0] = 1;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            int cv = arr[i];
            while (stack.size() > 0 && arr[stack.peek()] > cv) {
                stack.pop();
            }
            left[i] = stack.size() == 0 ? (i + 1) : i - stack.peek();
            stack.push(i);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += (arr[i] * left[i] * right[i]);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 2, 3, 4, 1, 4 };
        System.out.println(sumSubarrayMins(arr));
    }

}
