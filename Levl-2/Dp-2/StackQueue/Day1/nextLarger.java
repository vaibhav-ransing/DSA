package StackQueue.Day1;

import java.util.Stack;

public class nextLarger {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        // [73,74,75,71,69,72,76,73]
        // [1,1,4,2,1,1,0,0]
        stack.push(0);
        int[] ans = new int[temperatures.length];
        for(int i=1; i<temperatures.length; i++){
            while(stack.size()>0 && temperatures[stack.peek()]<temperatures[i]){
                ans[stack.peek()] =  i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
