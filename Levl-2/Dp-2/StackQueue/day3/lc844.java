package StackQueue.day3;

import java.util.Stack;

public class lc844 {
    
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='#' && s1.size()>0){
                s1.pop();
            }else{
                if(ch!='#')
                s1.push(ch);
            }
        }
        for(char ch: t.toCharArray()){
            if(ch=='#' && s2.size()>0){
                s2.pop();
            }else{
                s2.push(ch);
            }
        }
        String t1 = "";
        while(s1.size()>0){
            t1+=s1.pop();
        }
        String t2 = "";
        while(s2.size()>0){
            t2+=s2.pop();
        }
        System.out.println(t1+" "+t2);
        return t1.equals(t2);
    }

    public static void main(String[] args) {
        
    }
}
