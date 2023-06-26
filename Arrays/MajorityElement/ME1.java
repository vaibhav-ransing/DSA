public class ME1{

    public int majorityElement(int[] nums) {
        int me = nums[0], count=1;
        
        for(int i=1; i<nums.length; i++){
            int cv = nums[i];
            
            if(me == cv) count++;
            else count--;

            if(count==0) {
                me = cv;
                count = 1;
            }
        }
        return me;
    }

    public static void main(String[] args) {
        
    }
}