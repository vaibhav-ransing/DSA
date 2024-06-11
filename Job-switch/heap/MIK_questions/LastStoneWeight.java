import java.util.PriorityQueue;

public class LastStoneWeight {
    

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones){
            pq.add(stone);
        }  
        while (pq.size() > 1) {
            int v1 = pq.remove();
            int v2 = pq.remove();
            int diff = v1 - v2;
            if(diff != 0) pq.add(diff);
        }
        return pq.size() > 0 ? pq.peek() : 0;
    }
}
