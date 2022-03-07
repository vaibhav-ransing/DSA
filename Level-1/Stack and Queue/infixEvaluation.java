import java.util.Stack;
import java.util.function.ObjDoubleConsumer;

public class infixEvaluation {
    
    public static void infix(String str){
        Stack<Integer> num = new Stack<>();
        Stack<String> oper = new Stack<>();
        String[] arr = str.split(" ");
        for(int i=0;i<arr.length;i++){
            String s = arr[i];
            try {
                int val = Integer.parseInt(s);
                // System.out.println(val);
                num.push(val);

            } catch (Exception e) {
                // System.out.println(s);
                if(oper.size()==0){
                    oper.push(s);
                }else{
                    String peek = oper.peek();
                    if(s.equals("*") || s.equals("/")){
                        if(peek.equals("*") || peek.equals("/")){
                            numHelper(num, oper);
                        }
                        oper.push(s);
                    }
                    else if(s.equals("(")){
                        oper.push(s);
                    }
                    else if(s.equals("+") || s.equals("-")){
                        if(peek.equals("*") || peek.equals("/") || peek.equals("+") || peek.equals("-")){
                            numHelper(num, oper);
                        }
                        oper.push(s);
                    }
                    else if(s.equals(")")){
                        numHelper(num, oper);
                        oper.pop();
                    }

                }
            }
        }
        
        while(oper.size()>0){
            numHelper(num, oper);
        }
        System.out.println(num.pop());
    }

    public static void numHelper( Stack<Integer> num,Stack<String> oper){
            int p1 = num.pop();
            int p2 = num.pop();
            String operation= oper.pop();
            if(operation.equals("-")){
                int val = p2-p1;
                num.push(val);
            }else if(operation.equals("+")){
                int val = p2+p1;
                num.push(val);
            }else if(operation.equals("*")){
                int val = p2*p1;
                num.push(val);
            }else if(operation.equals("/")){
                int val = p2/p1;
                num.push(val);
            }

    }



    public static void main(String[] args) {
        String s = "2 + 6 * 4 / 8 - 3";
        infix(s);
    }
}
