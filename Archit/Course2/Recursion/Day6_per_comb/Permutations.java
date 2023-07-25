package Day6_per_comb;      

import java.util.ArrayList;     
import java.util.List;      

public class Permutations {     

    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        return ans;
    }
    public void recursion(){
         
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.set(0, 10);
        System.out.println(list);
    }
}
