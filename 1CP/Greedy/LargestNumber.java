import java.util.Arrays;

public class LargestNumber {
    

    public static String largestNumber(int[] nums) {
        String[] sorted = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            sorted[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(sorted);
        for(String val: sorted){
            System.out.println(val);
        }
        return "";
    }


    public static void main(String[] args) {
        int[] arr = {54, 9, 1, 21, 210};
        largestNumber(arr);
    }
}
