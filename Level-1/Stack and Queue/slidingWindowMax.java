import java.util.Stack;

public class slidingWindowMax {
    
    public static void SWM(int arr[], int k){

        int ng[] = nge(arr);
        int[] soln = new int[arr.length-k+1];
        int windowMax = 0;
        for(int i=0;i<=arr.length-k;i++){
            if(windowMax<i)
                windowMax++;

            while(ng[windowMax]<k+i && ng[windowMax]!=-1){
                windowMax = ng[windowMax];
                if(windowMax==ng[windowMax])
                    break;
            }
            soln[i] = arr[windowMax];
        }
        for(int i=0;i<soln.length;i++)
            System.out.print(soln[i]+" ");
    } 
    public static int[] nge(int arr[]){
        int ng[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1;i<arr.length;i++){
            ng[i] = i;
            while(stack.size()>0 && arr[stack.peek()]<=arr[i] ){
                ng[stack.peek()] = i;
                stack.pop();
            }
             stack.push(i);
        }
        return ng;
    }

    public static void main(String[] args) {
        int arr[]  ={1,6,2,9, 3,5,1,12};
        SWM(arr, 3);
    }
}
