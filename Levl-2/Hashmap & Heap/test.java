import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class test {

   static boolean pairWithEqualSum(int arr[]){
       HashSet<Integer> set = new HashSet<>();
       for(int i=0;i<arr.length;i++){
           for(int j=i+1;j<arr.length;j++){
                int key = arr[i]+ arr[j];
                if(set.contains(key)){
                    return true;
                }else
                    set.add(key);
           }
       }
       return false;
   }
   public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
    int len = nums.length;
    for(int i = 0; i < len; i++){
        if(tracker.containsKey(nums[i])){
            int left = tracker.get(nums[i]);
            return new int[]{left+1, i+1};
        }else{
            tracker.put(target - nums[i], i); 
        }
    }
    return new int[2];
}



    public static void main(String[] args) {

    }
}
