package ZRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsetDeleteGetRandomO1 {
    class RandomizedSet {

        HashMap<Integer, Integer> map; // val, indx_arr
        List<Integer> list;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;
        
            int curr_val_idx = map.get(val);
            int lastVal = list.get(list.size() - 1);
        
            // Move the last element to the place of the element to delete
            list.set(curr_val_idx, lastVal);
            map.put(lastVal, curr_val_idx);
        
            // Remove the last element
            list.remove(list.size() - 1);
            map.remove(val);  // Remove the element from the map
        
            return true;
        }
        

        public int getRandom() {
            Random rand = new Random();
            int randomIndex = rand.nextInt(list.size());
            return list.get(randomIndex);
        }
    }
}
