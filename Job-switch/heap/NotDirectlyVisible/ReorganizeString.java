package NotDirectlyVisible;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        PriorityQueue<Pair> maxHeap = helper(s);
        if(maxHeap == null) return "";
        StringBuilder ans = new StringBuilder();

        while (maxHeap.size() > 1) {
            
            Pair p1 = maxHeap.poll();
            Pair p2 = maxHeap.poll();
            ans.append(p1.ch);
            ans.append(p2.ch);

            p1.count = p1.count -1;
            p2.count = p2.count -1;

            if(p1.count >0){
                maxHeap.add(p1);
            }
            if(p2.count > 0){
                maxHeap.add(p2);
            }
        }
        if(maxHeap.size() > 0){
            Pair peek = maxHeap.poll();
            if(peek.count > 1) return "";
            ans.append(peek.ch);
        }
        return ans.toString();
    }

    public PriorityQueue<Pair> helper(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        for(char ch : map.keySet()){
            maxHeap.add(new Pair(ch, map.get(ch)));
            if(map.get(ch)/2 == s.length()/2){
                return null;
            }
        }
        return maxHeap;
    }

    class Pair implements Comparable<Pair> {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return o.count - this.count;
        }
    }
}
