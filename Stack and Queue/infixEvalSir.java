import java.io.*;
import java.util.*;

public class infixEvalSir{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code

    Stack<Integer> vstack = new Stack<>();
    Stack<Character> ostack = new Stack<>();
    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);

        if(ch == '('){
            ostack.push(ch);
        } else if(ch >= '0' && ch <= '9'){
            vstack.push(ch - '0');
        } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(ostack.size() > 0 && ostack.peek() != '(' && 
                  precedence(ostack.peek()) >= precedence(ch)){
                doInfixEvaluation(ostack, vstack);
            }
            ostack.push(ch);
        } else if(ch == ')'){
            while(ostack.size() > 0 && ostack.peek() != '('){
                doInfixEvaluation(ostack, vstack);
            }
            ostack.pop(); // removing the opening bracket
        }
    }

    while(ostack.size() > 0){
        doInfixEvaluation(ostack, vstack);
    }

    System.out.println(vstack.peek());
 }

 static void doInfixEvaluation(Stack<Character> ostack, Stack<Integer> vstack){
    char op = ostack.pop();
    int v2 = vstack.pop();
    int v1 = vstack.pop();
    int res = operation(v1, v2, op);
    vstack.push(res);
 }

 static int precedence(char op){
     if(op == '+'){
         return 1;
     } else if(op == '-'){
         return 1;
     } else if(op == '*'){
         return 2;
     } else {
         // divide
         return 2;
     }
 }

 static int operation(int v1, int v2, char op){
     if(op == '+'){
         return v1 + v2;
     } else if(op == '-'){
         return v1 - v2;
     } else if(op == '*'){
         return v1 * v2;
     } else {
         return v1 / v2;
     }
 }
}