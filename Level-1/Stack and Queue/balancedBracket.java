import java.io.*;
import java.util.*;

public class balancedBracket {

    static void check(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{')
                stack.push(c);
            else if(c==')' || c==']' || c=='}'){
                if(stack.size()>0 ){

                    char peek = stack.pop();
                    if(peek=='(' && c!=')'){
                        System.out.println(false);
                        return;
                    }else if(peek=='[' && c!=']'){
                        System.out.println(false);
                        return;
                    }else if(peek=='{' && c!='}'){
                        System.out.println(false);
                        return;
                    }
                }
                else{
                    System.out.println(false);
                    return;
                }
            }
        }
        if(stack.size()==0)
            System.out.println(true);
        else
            System.out.println(false);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

    }

}