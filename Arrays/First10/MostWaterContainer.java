package Arrays.First10;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/container-with-most-water/description/
public class MostWaterContainer {
    
    public int maxArea(int[] heights) {
        int i=0, j=heights.length-1;
        int ans = 0;
        while(i < j){
            int minHeight = Math.min(heights[i], heights[j]);
            int wid = j-i;
            int cv = minHeight*wid;
            ans = Math.max(ans, cv);
            if(heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
    public static void nextGreaterToRight(int arr[]){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] =  new int[n];
        Arrays.fill(arr, -1);
        stack.push(arr[n-1]);
        for(int i=n-2; i>=0; i--){
            int cv = arr[i];
            while(stack.size() > 0){
                if(stack.peek() < cv)
                    stack.pop();
            }
            if(stack.size() > 0){
                ans[i] = stack.peek();
            }
            stack.push(cv);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,8,6,2,5,4,8,3,7};
    }
}
