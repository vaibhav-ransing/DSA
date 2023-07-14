import java.util.*;

public class SubseqArrNoDuplicate {
    

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
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
        if(output.size() > 0 && output.get(output.size() - 1) == nums[idx] )
            return;
        solution(nums, idx+1, output);
    }

}
