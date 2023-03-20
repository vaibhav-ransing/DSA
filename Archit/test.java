import java.util.HashSet;
import java.util.Stack;

public class test {

    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val: nums){
            set.add(val);
        }
        return set.size();
    }


    public static void main(String[] args) {
    }
}
