import java.util.Stack;

public class infexEvalSplit {
    
    static void Evaluate(String exp){
        Stack<Integer> vstack = new Stack<>();
        Stack<String> opstack = new Stack<>();
        String[] arr = exp.split(" ");

        for(int i=0;i<arr.length;i++){
            String s = arr[i];
            try {
                int val = Integer.parseInt(s);
                vstack.push(val);

            } catch (Exception e) {

                if(s.equals("(")){
                    opstack.push(s);

                }else if(s.equals(")")){
                    while(opstack.size()>0 && !opstack.peek().equals("(") ){
                        conversion(vstack, opstack);
                    }
                    opstack.pop();

                }else{   // + - * ?
                    while(opstack.size()>0 && !opstack.peek().equals("(") && precedence(s)<=precedence(opstack.peek())){
                        conversion(vstack, opstack);
                    }
                    opstack.push(s);
                }
            }
        }
        while(opstack.size()>0){
            conversion(vstack, opstack);
        }
        System.out.println(vstack.peek());
    }
    static void conversion(Stack<Integer> vstack,Stack<String> opstack){
        
            int p1 = vstack.pop();
            int p2 = vstack.pop();
            String operation= opstack.pop();
            // System.out.println(p1+" "+operation+" "+p2);

            if(operation.equals("-")){
                int val = p2-p1;
                vstack.push(val);
            }else if(operation.equals("+")){
                int val = p2+p1;
                vstack.push(val);
            }else if(operation.equals("*")){
                int val = p2*p1;
                vstack.push(val);
            }else if(operation.equals("/")){
                int val = p2/p1;
                vstack.push(val);
            }
    }

    static int precedence(String s){
        if(s.equals("+") || s.equals("-"))
            return 1;
        else 
            return 2;
    }


    public static void main(String[] args) {
        String s = "3 / ( 6 * 8 - 4 ) + 9";
        
        Evaluate(s);
    }
}
