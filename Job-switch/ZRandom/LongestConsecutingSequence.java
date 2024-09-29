package ZRandom;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutingSequence {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }
        int ans = 0;
        for (int val : nums) {
            int count = 1;
            int lower = val - 1;
            while (set.contains(lower)) {
                count++;
                set.remove(lower);
                lower--;
            }
            int higher = val + 1;
            while (set.contains(higher)) {
                count++;
                set.remove(higher);
                higher++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public int longestConsecutiveDSU(int[] nums) {
        DSU ds = new DSU();
        HashSet<Integer> found = new HashSet<>();
        for (int val : nums) {
            if (found.contains(val - 1)) {
                ds.union(val, val - 1);
            }
            if (found.contains(val + 1)) {
                ds.union(val, val + 1);
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            int par = ds.find(val);
            map.put(par, map.getOrDefault(par, 0) + 1);
        }
        int max = 0;
        for (int lens : map.values()) {
            max = Math.max(lens, max);
        }
        return max;
    }

    class DSU {
        HashMap<Integer, Integer> map; // integer, parent

        int find(int x) {
            if (map.get(x) == x) {
                return x;
            }
            int par = find(map.get(x));
            map.put(x, par);
            return par;
        }

        void add(int x) {
            if (!map.containsKey(x)) {
                map.put(x, x); // Each element is its own parent initially
            }
        }

        void union(int x, int y) {
            if (!map.containsKey(x))
                map.put(x, x);
            if (!map.containsKey(y))
                map.put(y, y);
            int px = find(x);
            int py = find(y);
            if (px == py)
                return;
            map.put(px, py);
        }
    }

}
