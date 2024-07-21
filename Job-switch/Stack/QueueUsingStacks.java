package Stack;

import java.util.Stack;

public class QueueUsingStacks {

    class MyQueue {

        Stack<Integer> input;
        Stack<Integer> output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if (output.size() == 0) {
                while (input.size() > 0) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public int peek() {

            if (output.size() == 0) {
                while (input.size() > 0) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}