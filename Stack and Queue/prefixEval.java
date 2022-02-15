import java.util.Stack;

public class prefixEval{

    static void preEval(String s){
        Stack<Integer> vstack = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> post = new Stack<>();

        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                vstack.push(ch-'0');
                infix.push(ch+"");
                post.push(ch+"");
            }else{
                int v1 = vstack.pop();
                int v2 = vstack.pop();
                int val = operationHelper(v1, v2, ch);
                vstack.push(val);

                String s1 = infix.pop();
                String s2 = infix.pop();
                String inf = "("+s1+ch+s2+")";
                infix.push(inf);

                String p1 = post.pop();
                String p2 = post.pop();
                post.push(p1+p2+ch);
            }
        }
        System.out.println(vstack.pop());
        System.out.println(infix.pop());
        System.out.println(post.pop());
    }
    static int operationHelper(int v1, int v2 , char ch){
        if(ch=='+'){
            return v1+v2;
        }else if(ch=='-')
            return v1-v2;
        else if(ch=='*')
            return v1*v2;
        else 
            return v1/v2;
    }


    public static void main(String[] args) {
        String s = "-+2/*6483";
        preEval(s);
    }
}