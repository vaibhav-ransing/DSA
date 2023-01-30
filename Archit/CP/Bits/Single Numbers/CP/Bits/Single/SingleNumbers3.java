
public class SingleNumbers3 {
    
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int val: nums){
            xor = xor^val;
        }
        int rsb = Integer.lowestOneBit(xor);
        int a = 0;
        for(int val: nums){
            if((val&rsb)==1){
                a = a^val;
            }
        }
        int b = xor^a;
        int ans[] = {a,b};
        return ans;
    }


    public static void main(String[] args) {
        
    }
}
