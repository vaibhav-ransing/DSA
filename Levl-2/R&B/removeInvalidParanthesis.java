import java.util.HashSet;
import java.util.Stack;

public class removeInvalidParanthesis {
    
    static void solution(String s,int index,String ans, int minRemoval, HashSet<String> set){

        if(index==s.length()){
            if(minRemoval==0 && isValid(ans)){
                if(set.contains(ans)==false){
                    System.out.println(ans);
                }
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
        int minRemoval = getMin("()())()");
        HashSet<String> set = new HashSet<>();
        solution("()())()", 0, "", minRemoval, set);
    }
}
