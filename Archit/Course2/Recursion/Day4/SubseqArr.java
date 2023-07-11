import java.util.*;

public class SubseqArr {
    
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solution(nums, 0, output);
        return result;
    }

    public void solution(int[] nums, int idx, List<Integer> output) {
        if(idx == nums.length){
            result.add(new ArrayList<>(output));
            return;
        }

        // yes call
        output.add(nums[idx]);
        solution(nums, idx+1, output);
        output.remove(output.size()-1);

        // No call
        solution(nums, idx+1, output);
    }



    public static void main(String[] args) {
        
    }
}
