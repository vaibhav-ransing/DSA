import java.io.*;
import java.util.*;

public class test {

    public static boolean DB(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch==')' && stack.peek()=='('){
                return true;
            }else if(ch==')'){
                while(stack.peek()!='('){
                    stack.pop();
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(DB(s));
    }

}