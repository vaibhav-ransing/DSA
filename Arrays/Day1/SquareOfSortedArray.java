package Arrays.Day1;

public class SquareOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1, idx = n - 1;
        int[] ans = new int[n];
        while (i < j) {
            int start = Math.abs(nums[i]);
            int end = Math.abs(nums[j]);
            int max = Math.max(start, end);
            ans[idx] = max*max;
            if(start > end){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
