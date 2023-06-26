import java.util.ArrayList;
import java.util.HashMap;

public class ME3 {
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        // write yout code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) > arr.length/k){
                ans.add(key);
            }
        }
        return ans;
    }
}
