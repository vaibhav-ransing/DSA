import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharacterByFreq{

    
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char ch : map.keySet()){
            pq.add(new Pair(ch, map.get(ch)));
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            Pair peek = pq.remove();
            char ch = peek.ch;
            int count = peek.count;

            while (count > 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    class Pair implements Comparable<Pair>{
        char ch;
        int count;
        Pair(char ch, int count){
            this.count = count;
            this.ch = ch;
        }
        public int compareTo(Pair o){
            // return this.count - o.count;
            return o.count - this.count ;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}