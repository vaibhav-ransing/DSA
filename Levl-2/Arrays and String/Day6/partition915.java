package Day6;

import javax.swing.Painter;

public class partition915 {
    
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int mts = nums[0];
        int mtp = nums[0];  
        int partition = 0;
        for(int i=1; i<n; i++){
            mts = Math.max(mts, nums[i]);
            if(nums[i]<mtp){
                partition = i;
                mtp = mts;
            }
        }    
        return partition;
    }

    public int partitionDisjoint2(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        int max = 0;
        right[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            left[i] = Math.max(left[i-1], nums[i]);
        }
        for(int i=n-2; i>=0; i--){
            right[i] = Math.min(right[i+1], nums[i]);
        }
        for(int i=0; i<n-1; i++){
            int l = left[i];
            int r = right[i+1];
            if(l<=r){
               return i+1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        
    }
}
