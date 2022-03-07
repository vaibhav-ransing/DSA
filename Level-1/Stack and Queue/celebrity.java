import java.io.*;
import java.util.*;

public class celebrity {
    
    public static void isCelebrity(int[][] arr){
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            stack.push(i);
        }
        while(stack.size()>1){
            int v1 = stack.pop();
            int v2 = stack.pop();
            
            if(arr[v1][v2]==1){
                stack.push(v2);
            }else if(arr[v2][v1]==1){
                stack.push(v1);
            }
        }
        if(stack.size()==1){
            int index = stack.peek();
            if(check(index, arr))
                System.out.println(stack.peek());
            else
                System.out.println("none");
        }
    }
    public static boolean check(int index, int arr[][]){
        for(int i=0;i<arr.length;i++){
            if(index==i)
                continue;
            if(arr[i][index]==0 || arr[index][i]==1)
                return false;
        }
        return true;
    }
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(line.charAt(j)+"");
            }
        }
        isCelebrity(arr);
    }
}