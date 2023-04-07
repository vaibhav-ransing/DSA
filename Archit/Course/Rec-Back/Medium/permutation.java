import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.StyleSheet.BoxPainter;

public class permutation {
    

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] boxes = new int[nums.length];
        permutations(nums, boxes, 0, list, new ArrayList<Integer>());
        return list;
    }
    public static void permutations(int[] nums, int[] boxes, int idx, List<List<Integer>> list, ArrayList<Integer> temp){
        if(idx>=nums.length){
            list.add(temp);
            return;
        }
        if(boxes[idx]==0){
            boxes[idx] = 1;
            temp.add(nums[idx]);
            permutations(nums, boxes, idx+1, list, temp);
            boxes[idx] = 0;
            temp.remove(temp.size()-1);
        }else{
            permutations(nums, boxes, idx+1, list, temp);
        }
    }



}
