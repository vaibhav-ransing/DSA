import java.util.HashMap;
import java.util.HashSet;

public class duplicates {
    
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for(int val: nums){
            if(map.contains(val)) return true;
            map.add(val);
        }   
        return false;
    }
}
