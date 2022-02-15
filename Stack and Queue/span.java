import java.util.Stack;

import javax.swing.plaf.synth.SynthScrollPaneUI;

public class span {
    
    static void stockSpan(int arr[]){
        int ans[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        ans[0] = 1;
        for(int i=1;i<arr.length;i++){
            int index =1;
             while(stack.size()>0){
                 if(arr[stack.peek()] >arr[i]){
                     index = i - stack.peek() ;
                     break;
                 }
                 stack.pop();
             }
            
             if(stack.size()==0){
                 ans[i] = i+1;
             }else{
                 ans[i] = index;
             }
             stack.push(i);
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(ans[i]+" ");
    }

    static void stockSpan2(int arr[]){
        int ans[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(stack.size()>0 && arr[i] > arr[stack.peek()]){
                ans[stack.peek()] = stack.peek() - i;
                stack.pop();
            }
            stack.push(i);
        }
        while(stack.size()>0){
            int ind = stack.pop();
            ans[ind] = ind+1;
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(ans[i]+" ");
    }

    
    public static void main(String[] args) {
        int arr[] = {2, 5, 9, 3, 1 ,12 ,6 ,8 ,7};
        stockSpan(arr);
    } 
}
