package Stack;

import java.util.Stack;

public class DailyTemp {

    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (stack.size() > 0 && temp[stack.peek()] < temp[i]) {
                stack.pop();
            }
            if(stack.size() !=0){
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}   
