package StackQueue.Day2;

import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/3b47f0ad00f953dd514235ddec54e39fdc297dda/1
public class longestValidPar {
    

    static int findMaxLen(String S) {
        // code here
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            if(ch=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.size()>0){
                    int len = i - stack.peek();
                    res = Math.max(res, len);
                }else{
                    stack.push(i);
                }
            }
        }
        return res;
    }



    
    public static void main(String[] args) {
        
    }
}
