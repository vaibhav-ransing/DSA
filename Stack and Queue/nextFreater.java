import java.lang.Thread.State;
import java.util.Stack;

import javax.swing.text.AbstractDocument.BranchElement;

public class nextFreater {
    

    public static void nextGreater(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int ng = -1;
            while(stack.size()>0){
                if(stack.peek()>arr[i]){
                    ng= stack.peek();
                    break;
                }
                stack.pop();
            }
            ans[i]=ng;
            stack.push(arr[i]);
        }
        for(int i=0;i<ans.length;i++)
            System.out.println(ans[i]);
    }

    public static void nextGreaterFront(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[arr.length];
        stack.push(0);
        for(int i=1;i<arr.length;i++){
            while(stack.size()>0 && arr[stack.peek()] <= arr[i]){
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(stack.size()>0){
            ans[stack.pop()] = -1;
        }
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");
    }

    public static void main(String[] args) {
        int arr[] = {4,2,3,5};
    }
}
