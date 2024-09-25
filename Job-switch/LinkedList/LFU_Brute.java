package LinkedList;

import java.util.HashMap;

public class LFU_Brute {

    class LFUCache {

        HashMap<Integer, Integer> map;
        int cap;

        public LFUCache(int capacity) {
            map = new HashMap<>();
            this.cap = capacity;
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }
            if (map.size() == cap)
                map.remove(getKeyWithMin());

            map.put(key, 1);
        }

        int getKeyWithMin() {
            int min = 99999;
            int gkey = -1;

            for (int key : map.keySet()) {
                int val = map.get(key);
                if (val < min) {
                    min = val;
                    gkey = key;
                }
            }
            return gkey;
        }
    }
}
