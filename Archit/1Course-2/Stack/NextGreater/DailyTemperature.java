import java.util.Stack;

public class DailyTemperature {
    
    public int[] dailyTemperatures(int[] temperatures) {

        int ans[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures.length-1);
                                                                         
        for(int i=temperatures.length-2; i>=0; i--){
            int cv = temperatures[i];
            while(stack.size()>0 && temperatures[stack.peek()] < cv){
                stack.pop();
            }
            if(stack.size()==0){
                int span = temperatures.length - i;
                ans[i] = span;
            }else{
                int span = stack.peek() - i;
                ans[i] = span;
            }
            stack.push(i);
        }
        
        return ans;

    }

    public static void main(String[] args) {
        
    }
}