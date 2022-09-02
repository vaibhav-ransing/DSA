package StackQueue.Day1;

import java.sql.RowId;
import java.util.Arrays;
import java.util.Stack;

public class histogram {
    public static int largestRectangleArea(int[] heights) {
        int left[] = smallerToLeft(heights);
        int right[] = smallerToRight(heights);
        for(int val: left){
            System.out.print(val+" ");
        }
        System.out.println();
        for(int val: right){
            System.out.print(val+" ");
        }

        int area=0;
        for(int i=0; i<heights.length; i++){
            int l = left[i];
            int r = right[i];
            if(l!=-1 && r!=-1){
                area = Math.max(area, (heights[i]*l+ heights[i]*(r-1)));
            }
        }
        System.out.println(area);
        return area;
    }
    public static int[]  smallerToLeft(int[] heights){
        int left[] = new int[heights.length];
        Arrays.fill(left, -1);
        Stack<Integer> stack = new Stack<>();
        // [2,1,5,6,2,3]
        // 
        stack.push(0);
        for(int i=1;i<heights.length;i++){
            while(stack.size()>0 && heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            if(stack.size()>0 && heights[stack.peek()] < heights[i]){
                left[i] = i-stack.peek();
            }
            stack.push(i);
        }
        return left;
    }

    public static int[] smallerToRight(int[] heights){
        int right[] = new int[heights.length];
        Arrays.fill(right, -1);
        Stack<Integer> stack = new Stack<>();
        // [2,1,5,6,2,3]
        stack.push(heights.length-1);
        for(int i=heights.length-2; i>=0; i--){
            while(stack.size()>0 && heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            if(stack.size()>0 && heights[stack.peek()] < heights[i]){
                right[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return right;
    }

    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        largestRectangleArea(arr);
    }
}
