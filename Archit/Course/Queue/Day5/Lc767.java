import java.util.*;

public class Lc767 {
    

    class Solution {
        public String reorganizeString(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
            PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(char key: map.keySet()){
                pair p = new pair(key, map.get(key));
                pq.add(p);
            }
            StringBuilder ans = new StringBuilder();
            pair prev = null;
            while(pq.size()>0){
                pair peek = pq.remove();
                ans.append(peek.ch);
                peek.freq--;
                if(prev!=null && prev.freq>0){
                    pq.add(prev);
                }
                prev = peek;
            }
            ans= ans.length()==s.length()? ans: new StringBuilder();
            return ans.toString();
        }
         static class pair implements Comparable<pair>{
            char ch;
            int freq;
            pair(char ch, int freq){
                this.ch=ch;
                this.freq = freq;
            }
            public int compareTo(pair o){
                return this.freq - o.freq;
            }
        }
    }
    
}
