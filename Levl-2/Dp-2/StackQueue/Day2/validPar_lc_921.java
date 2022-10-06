package StackQueue.Day2;

import java.util.Stack;

public class validPar_lc_921 {
    
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            }else{
                if( stack.size()==0 && stack.peek()==ch){
                    stack.push(ch);
                }else{
                    stack.pop();
                }
            }
        }
        return stack.size();   
    }

    public static void main(String[] args) {
        
    }
}
