
public class lc1470 {
    public int[] shuffle(int[] nums, int n) {
        int arr[] = new int[nums.length];
        int i=0, left=0;
        while(n<nums.length){
            arr[i] = nums[left];
            arr[i+1] = nums[n];
            n++;
            i++;
            left++;
        }
        return arr;
    }
}
