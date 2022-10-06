package Day10;

import java.util.HashMap;

public class lc2014 {
    
    public String longestSubsequenceRepeatedK(String s, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        helper(s, 0, "", map);
        String ans = "";
        for(String key: map.keySet()){
            int rep = map.get(key);
            if(rep==k && ans.length()<key.length()){
                ans = key;
            }
        }
        return ans;
    }

    public void helper(String s, int i, String ss, HashMap<String, Integer> map ){
        if(i==s.length()){
            map.put(ss, map.getOrDefault(ss, 0)+1);
        }
        helper(s, i+1, ss+s.charAt(i), map);
        helper(s, i+1, ss, map);
    }




    public static void main(String[] args) {
        System.out.println("a" < "b");
    }
}
