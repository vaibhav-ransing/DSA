package StackQueue.day5;

import java.util.Stack;

public class lc946_validStackSeq {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        // pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
        int i=0,j=0;
        while(i<pushed.length){
            stack.push(pushed[i]);
            i++;
            while(stack.size()>0 && j<popped.length && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        
    }
}
