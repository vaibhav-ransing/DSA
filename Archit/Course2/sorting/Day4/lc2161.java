public class lc2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1;
        
        for(int val : nums){
            if(val <= pivot){
                ans[left++] = val;
            }else{
                ans[right--] = val;
            }
        }
        return ans;
    }



.    public static void main(String[] args) {

    }
}
