package Subarray;

import java.util.*;

public class BitwiseORsOfSubarray {

    // 1,2,4 
    // if we do this
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> prev_set = new HashSet<>();
        HashSet<Integer> curr_set;

        for (int cv : arr) {
            curr_set = new HashSet<>();
            curr_set.add(cv);

            for(int key : prev_set){
                curr_set.add(key | cv);
            }

            for(int val : prev_set){  
                curr_set.add(val);
            }

            prev_set = curr_set;
        }
        return prev_set.size();
    }

    // Why result_set is needed
    public int subarrayBitwiseORsGpt(int[] arr) {
        HashSet<Integer> prev_set = new HashSet<>();
        HashSet<Integer> curr_set;
        HashSet<Integer> result_set = new HashSet<>();
    
        for (int cv : arr) {
            curr_set = new HashSet<>();
            curr_set.add(cv);
            for (int key : prev_set) {
                curr_set.add(key | cv);
            }
            prev_set = curr_set;
            result_set.addAll(curr_set);
        }
        return result_set.size();
    }
    

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        int ans = 0;
        if (set.add(1)) {
            ans++;
        }
    }
}
