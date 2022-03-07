import java.util.Stack;

public class postFixEval {

    static void conversion(String s){

        Stack<Integer> vstack = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> infix = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch>='0' && ch<='9'){
                vstack.push(ch-'0');
                pre.push(ch+"");
                infix.push(ch+"");
            }else{   
                conversion(vstack, pre, infix, ch);
            }
        }

        System.out.println(vstack.peek());
        System.out.println(infix.peek());
        System.out.println(pre.peek());
    }

    static void conversion(Stack<Integer> vstack, Stack<String> pre, Stack<String> infix, char ch){
        int v2 = vstack.pop();
        int v1 = vstack.pop();
        int val = operationHelper(v1, v2, ch);
        vstack.push(val);

        String s2 = infix.pop();
        String s1 = infix.pop();
        infix.push( "("+s1+ch+s2+")" );

        String p2 = pre.pop();
        String p1 = pre.pop();
        pre.push(ch+p1+p2);


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
        String s = "264*8/+3-";
        conversion(s);
    }
}
