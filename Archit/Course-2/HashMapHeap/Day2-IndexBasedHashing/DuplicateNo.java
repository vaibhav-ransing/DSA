import java.util.ArrayList;

public class DuplicateNo {

    public int findDuplicate(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int val = nums[i] % (n + 1);
            nums[val - 1] += (n + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > n + 1) {
                return nums[i] % (n + 1);
            }
        }
        return -1;
    }

    public static ArrayList<Integer> duplicates(int nums[], int n) {

        for(int i=0; i<n; i++){
            int val = nums[i] %(n+1) ;
            nums[val] += (n+1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if((nums[i] / (n+1)) >1 ){
                ans.add(i);
            }
        }
        if(ans.size()==0) ans.add(-1);
        return ans;
    }

}
