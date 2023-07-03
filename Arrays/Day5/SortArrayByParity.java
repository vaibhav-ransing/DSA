public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        // 9 3 8 6 7 2 3
        int i=0, j=0;
        while(i<nums.length){
            if(nums[i]%2==0){  // if even integer found swap i and j 
                swap(nums, i, j);
                i++;
                j++;
            }else{ // odd number hai to j wont move and i will increase
                i++;
            }
        }
        return nums;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
