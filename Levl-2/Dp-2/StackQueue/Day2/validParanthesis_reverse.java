package StackQueue.Day2;

import java.util.Stack;

public class validParanthesis_reverse {
    
    static int countRev (String s){
        Stack<Character> stack = new Stack<>();
        int opening =0, closing=0;
        for(char ch: s.toCharArray()){
            if(ch=='{'){
                opening++;
                stack.push(ch);
            }else{
                if( stack.size()==0 || stack.peek()==ch){
                    closing++;
                    stack.push(ch);
                }else{
                    opening--;  
                    stack.pop();
                }
            }
        }
        return (opening+1)/2 + (closing+1)/2;
    }


    public static void main(String[] args) {
        countRev("}{{}}{{{");
    }
}
