import java.io.*;
import java.util.*;

public class smallestNo{
  
    static void descSoln(String s){

        Stack<Integer> stack = new Stack<>();
        int val =1;
        String ans="";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='d'){
                // System.out.println("val D "+val);
                stack.push(val);
                val++;
            }else{
                // System.out.println("val I "+val);
                // System.out.println();
                stack.push(val);
                helper(stack, ans);
                val++;
            }
        }
        if(stack.size()!=0)
            helper(stack, ans);
        System.out.println(val);
    }
    static void helper(Stack<Integer> stack, String ans){
        while(stack.size()>0){
            ans+=Integer.toString(stack.pop());
        }
        System.out.print(ans);
    }
    
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    descSoln(str);
    // code
 }
}