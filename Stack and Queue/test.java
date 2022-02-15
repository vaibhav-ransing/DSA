import java.util.Stack;

import javax.xml.validation.Validator;

public class test {
    
    static void NextGreater(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int val = -1;
            while(stack.size()>0){
                if(stack.peek()>arr[i]){
                    val=stack.peek();
                    break;
                }
                stack.pop();
            }
            ans[i] = val;
        }
    }

    static void stockSpan(int arr[]){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        ans[0]=1;
        for(int i=1;i<arr.length;i++){
            int index=1;
            while(stack.size()>0){
                if(arr[stack.peek()] > arr[i]){
                    index++;
                    stack.pop();
                }
                else
                    index = stack.peek() -i+1;
            }
            ans[i] = index;
        }
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 9, 3 ,1 ,12 ,6 ,8 ,7};
        stockSpan(arr);
    }
}
