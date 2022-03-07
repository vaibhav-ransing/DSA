import java.util.Stack;

public class infixEvaluation2 {

    public static void evaluate(String s){
        Stack<Integer> vstack = new Stack<>();
        Stack<Character> opstack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                vstack.push(ch-'0');
            }else if(ch=='('){
                opstack.push(ch);
            }else if(ch==')'){
                while(opstack.size()>0 && opstack.peek()!='('){
                    cal(vstack, opstack);
                }
                opstack.pop();
            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while(opstack.size()>0 && precedence(opstack.peek())>=precedence(ch) && opstack.peek()!='(') {
                    cal(vstack, opstack);
                }
                opstack.push(ch);
            }
        }
        while(opstack.size()>0){
            cal(vstack, opstack);
        }
        System.out.println(vstack.peek());
    }
    static int precedence(char ch){
        if(ch=='+' || ch=='-')
            return 1;
        else
            return 2;
    }
    static void cal(Stack<Integer> vstack,Stack<Character> opstack){
        int v1 = vstack.pop();
        int v2 = vstack.pop();
        char op = opstack.pop();
        int val = operation(op, v1, v2);
        vstack.push(val);
    }
    static int operation(char ch , int v1, int v2){
        if(ch=='+') 
            return v1+v2;
        else if(ch=='-')
            return v2-v1;
        else if(ch=='/')
            return v2/v1;
        else
            return v1*v2;
    }


    public static void main(String[] args) {
        String s = "3 / (6 * 8 - 4) + 9";
        // String s = "2 + 6";
        evaluate(s);
    }
}
