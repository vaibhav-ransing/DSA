import java.util.Stack;

public class infixToPrePost {
    
    public static void conversion(String s){
        Stack<Character> opstack = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();


        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch=='('){
                opstack.push(ch);
            }else if(ch==')'){
                while(opstack.size()>0 && opstack.peek()!='('){
                    conversion(opstack, pre, post);
                }
                opstack.pop();
            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while(opstack.size()>0 && precedence(ch)<=precedence(opstack.peek()) && opstack.peek()!='('){
                    conversion(opstack, pre, post);
                }
                opstack.push(ch);
            }else{
                pre.push(ch+"");
                post.push(ch+"");
            }
        }
        while(opstack.size()>0){
            conversion(opstack, pre, post);
        }
        System.out.println(pre.peek());
        System.out.println(post.peek());
    }
    static void conversion(Stack<Character> opstack, Stack<String> pre, Stack<String> post){
        char op = opstack.pop();

        String preval2 = pre.pop();
        String preval1 = pre.pop();
        pre.push(op + preval1 + preval2);

        String postval2 = post.pop();
        String postval1 = post.pop();
        post.push(postval1 + postval2 + op);

    }

   

    static int precedence(char ch){
        if(ch == '+'){
            return 1;
        } else if(ch == '-'){
            return 1;
        } else if(ch == '*'){
            return 2;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        String s = "a*(b-c+d)/e";
        conversion(s);
    }

}
