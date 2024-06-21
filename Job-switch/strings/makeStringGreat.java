import java.util.Stack;

public class makeStringGreat {

    public String makeGood(String s) {

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {

            if (stack.size() > 0) {
                if (stack.peek() != ch && Math.abs(((stack.peek()) - ch)) == 32) {
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            } else {
                stack.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println((int) 'A');
        System.out.println((int) 'a');

        System.out.println((int) 'x' - (int) 'X');

    }
}
