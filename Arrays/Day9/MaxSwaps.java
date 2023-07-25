package Day9;

import java.util.Stack;

public class MaxSwaps {

    public static int maximumSwap(int num) {
        String str = num+"";
        int n = str.length();
        char[] arr = str.toCharArray();

        // 1 prepare last index of digit
        int[] li = new int[10];
        for(int i=0; i<arr.length; i++){
            int digit = arr[i] - '0';
            li[digit] = i;
        }

        // 2 figure out the position of swapping
        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            int digit = arr[i] - '0';
            for(int j=9; i>digit; j--){
                if(i < li[j]){
                    // swap and break;
                    swap(arr, i, li[j]);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        String temp = new String(arr);
        return Integer.parseInt(temp);
    }
    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

    public static int maximumSwap2(String num) {

        char[] charArray = num.toCharArray();
        int n = charArray.length;
        int[] arr = new int[n];
        int maxToRight[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            arr[i] = (int) (charArray[i] - '0');
        }

        maxToRight[n - 1] = -1;
        stack.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            maxToRight[i] = -1;
            int cv = arr[i];
            while(stack.size()>0 && cv > arr[stack.peek()]){
                stack.pop();
            }
            if(stack.size() > 0){
                maxToRight[i] = stack.peek();
            }
            stack.push(i);
        }
        for(char ch : charArray){
            System.out.print(ch+" ");
        }
        System.out.println();
        for(int i=0; i<arr.length; i++){
            if(maxToRight[i] == -1) System.out.print("0 ");
            else
                System.out.print(arr[maxToRight[i]] +" ");
        }

        return 0;
    }

    public static void main(String[] args) {
        // maximumSwap("965836952");
    }
}