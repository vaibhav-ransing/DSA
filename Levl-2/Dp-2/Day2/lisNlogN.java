package Day2;

import java.util.Arrays;

public class lisNlogN {
    
    public static void lis(int nums[]){
        int[] tails = new int[nums.length];
        int len = 1;
        tails[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>tails[len-1]){
                tails[len++] = nums[i];
            }else{
                int idx = Arrays.binarySearch(tails, 0, len-1, nums[i]);
                if(idx <0){
                    idx = -idx;
                    idx = idx-1;
                }
                tails[idx] = nums[i];
            }
        }
        System.out.println(len);
    }







    public static void main(String[] args) {
        
    }
}
