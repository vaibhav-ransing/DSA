package Day4;
public class firstMissing41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0 || nums[i]>n){
                nums[i] = n+1;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i]<0 && -nums[i]<n+1){
                nums[-nums[i]-1] = -nums[-nums[i]-1] ;
            }else if(nums[i]<n+1 && nums[i]>0){
                nums[nums[i]-1] = -nums[nums[i]-1] ;
            }
        }     
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                return i+1;
            }
        }  
        return -1;
    }

    public static void main(String[] args) {
        
    }
}
