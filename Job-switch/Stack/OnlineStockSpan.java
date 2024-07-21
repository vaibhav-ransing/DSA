package Stack;

import java.util.Stack;

public class OnlineStockSpan {

    class StockSpanner {

        Stack<int[]> stack;  // val, count
        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int val) {
            int count = 1;
            while (stack.size() > 0 && stack.peek()[0] <= val) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{val, count});
            return count;
        }
    }

}