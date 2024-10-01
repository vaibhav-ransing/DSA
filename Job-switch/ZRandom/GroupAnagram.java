package ZRandom;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>(); // a2b3d1 : index in ans

        for (String str : strs) {
            TreeMap<Character, Integer> treeMap = new TreeMap();
            for (char ch : str.toCharArray()) {
                treeMap.put(ch, treeMap.getOrDefault(ch, 0) + 1);
            }
            StringBuilder sb = new StringBuilder();
            for (char key : treeMap.keySet()) {
                sb.append(key + " " + treeMap.get(key) + ",");
            }
            if (map.containsKey(sb.toString())) {
                int ansIdx = map.get(sb.toString());
                ans.get(ansIdx).add(str);
            } else {
                ans.add(new ArrayList<>());
                ans.get(ans.size() - 1).add(str);
                map.put(sb.toString(), ans.size() - 1);
            }
        }
        return ans;
    }
}
