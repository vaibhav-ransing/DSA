
import java.util.*;
public class Triange {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> pre = new ArrayList<>(triangle.get(0));
        for(int row=1; row<triangle.size(); row++){
            List<Integer> currArr = triangle.get(row);
            List<Integer> temp = new ArrayList<>();
            
            for(int i=0; i<currArr.size(); i++){
                int preI = i==0 ? Integer.MAX_VALUE : pre.get(i-1);
                int preNext = i == currArr.size() - 1 ? Integer.MAX_VALUE : pre.get(i);
                int val = currArr.get(i) + Math.min(preI, preNext);
                temp.add(val);
            }
            System.out.println(pre);
            pre = temp;
        }
        int min = Integer.MAX_VALUE;
        for(int val : pre){
            min = Math.min(min, val);
        }
        return min;
    }
    public int minimumTotalArr(int[][] triangle) {
        int n = triangle.length;
        int[] pre = triangle[0];
        
        for (int row = 1; row < n; row++) {
            int[] currArr = triangle[row];
            int[] temp = new int[currArr.length];
            
            for (int i = 0; i < currArr.length; i++) {
                int preI = i == 0 ? Integer.MAX_VALUE : pre[i - 1];
                int preNext = i == currArr.length - 1 ? Integer.MAX_VALUE : pre[i];
                int val = currArr[i] + Math.min(preI, preNext);
                temp[i] = val;
            }
            pre = temp;
        }
        int min = Integer.MAX_VALUE;
        for (int val : pre) {
            min = Math.min(min, val);
        }
        return min;
    }

     public static int recursion(int[][] triangle, int row, int col, int[][] dp){
        if(row == triangle.length - 1)  
            return triangle[row][col];

        int down = recursion(triangle, row+1, col, dp);
        int downNext = recursion(triangle, row+1, col+1, dp);

        return triangle[row][col] + Math.min(down, downNext);
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int m = triangle.length;
        n = triangle[0].length;
        int dp[][] = new int[m][n];
        return recursion(triangle, 0, 0, dp);
    }
    

}
