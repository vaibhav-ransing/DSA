package StackQueue.day3;

import java.util.ArrayList;
import java.util.Stack;

class MinStack {

    int min;
    Stack<Integer> stack;
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(min==Integer.MAX_VALUE){
            min = val;
            stack.add(val);
        }else if(val<min){
                int cv = val+val - min;
                min = val;
                stack.push(cv);
        }else{
            stack.push(val);
        }

    }
    
    public void pop() {
        if(stack.size()==0){
            return;
        }
        if(stack.peek()<min){
            min = min + min - stack.peek();
        }
        stack.pop();
        if(stack.size()==0){
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        if(stack.peek()<min){
            return min;
        }
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
