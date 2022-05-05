import java.io.*;
import java.util.*;

public class Main {

	    static void solution(String s,int index,String ans, int minRemoval, HashSet<String> set){

        if(index==s.length()){
            if(minRemoval==0 && isValid(ans)){
                set.add(ans);
            }
            return;
        }

        solution(s, index+1, ans+s.charAt(index), minRemoval, set);
        solution(s, index+1, ans, minRemoval-1, set);
    }
    static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push('(');
            }else{ 
                if(stack.size()==0){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size()==0?true:false;
    }

    static int getMin(String s){

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(ch);
            }else{
                if(stack.size()==0){
                    count++;
                    continue;
                }else{
                    stack.pop();
                }
            }
        }
        while(stack.size()!=0){
            count++;
            stack.pop();
        }
        return count;
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
        
		solution(str,0, "", getMin(str),new HashSet<>());
		for(String val: set){
            System.out.println(val);
        }
	}
		
}