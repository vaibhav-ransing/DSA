import java.util.Stack;

public class test {

    public boolean isValid(String s) {
        // { [ (

        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch==')'){
                if(stack.size()==0 || stack.peek()!='('){
                    return false;
                }else{
                    stack.pop();
                }
            }else if(ch=='}'){
                if(stack.size()==0 || stack.peek()!='{'){
                    return false;
                }else{
                    stack.pop();
                }
            }else if(ch==']'){
                if(stack.size()==0 || stack.peek()!='['){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.size()==0;
    }


    public static void main(String[] args) {
    }
}
