import java.util.Arrays;
import java.util.Stack;

public class NextGE_rightSide{

    public static void solution(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);

        for(int i=0; i<arr.length; i++){
            int cv = arr[i];
            while(stack.size()>0 && arr[stack.peek()]<cv){
                int idx = stack.pop();
                ans[idx] = cv;
            }
            stack.push(i);
        }
    }

    public static void rightToLeft(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        stack.push(arr.length-1);
        for(int i=arr.length-2; i>=0; i--){
            int cv = arr[i];
            while(stack.size()>0 && cv>arr[stack.peek()]){
                stack.pop();
            }
            if(stack.size()>0 && cv<arr[stack.peek()]){
                ans[i] = arr[stack.peek()];
            }
            
            stack.push(i);
        }
        for(int val: ans){
            System.out.println(val+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,1,6,2,1};
        rightToLeft(arr);
    }
}