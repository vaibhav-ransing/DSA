import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MinNumberPusuhestoTypeWord1 {

    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : word.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }    
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(char ch : map.keySet()){
            pq.add(map.get(ch));
        }
        // total_diff_ch = 27, at_first we can keep = 8
        int ans = 0;
        int removals = 8;
        
        while (pq.size() > 0) {
            int occ = pq.remove();
            ans += (removals / 8) * occ;
            removals++;
        }
        return ans;
        
    }
    public static void main(String[] args) {
        System.out.println((int)'a');
    }
}
