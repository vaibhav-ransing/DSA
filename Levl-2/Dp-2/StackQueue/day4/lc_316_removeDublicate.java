package StackQueue.day4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class lc_316_removeDublicate {
    
    public static String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(!set.contains(ch)){
                while(stack.size()>0 && map.get(stack.peek())>1 && stack.peek()>ch){
                    if(ch=='a'){
                        System.out.println(map.get(stack.peek())+" "+stack.peek()) ;
                    }
                    map.put(stack.peek(), map.get(stack.peek())-1);
                    set.remove(stack.peek());
                    stack.pop();
                }
                stack.push(ch);
                set.add(ch);
            }else{ 
                map.put(ch, map.get(ch)-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size()>0){
            sb = sb.append(stack.pop());
        }
        
        System.out.println(sb.reverse());
        return sb.toString();
    }





    public static void main(String[] args) {
        removeDuplicateLetters("bbcaac");
    }
}
