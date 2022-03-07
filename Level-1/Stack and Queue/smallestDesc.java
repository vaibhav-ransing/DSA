import java.util.Stack;

public class smallestDesc {
    
    static void descSoln(String s){

        Stack<Integer> stack = new Stack<>();
        int val =1;
        String ans="";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='d'){
                stack.push(val);
                val++;
            }else{
                stack.push(val);
                helper(stack, ans);
                val++;
            }
        }
        System.out.println(val);
    }
    static void helper(Stack<Integer> stack, String ans){
        while(stack.size()>0){
            ans+=Integer.toString(stack.pop());
        }
        System.out.print(ans);
    }

    public static void main(String[] args) {
        String s = "ddiddiid";
        descSoln(s);
        // 321654798
    }
}
