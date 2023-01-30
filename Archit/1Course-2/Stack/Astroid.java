import java.util.Stack;

public class Astroid {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int val : asteroids) {
            if (val < 0) {
                val = -val;
                boolean falg = false;
                while (stack.size() > 0 && stack.peek() <= val) {
                    falg = val == stack.peek() ? true : false;
                    stack.pop();
                    if(falg) break;
                }
                if(!falg && (stack.size()==0 || stack.peek()<0)){
                    stack.push(-val);
                }
            } else {
                stack.push(val);
            }
        }
        int ans[] = new int[stack.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
