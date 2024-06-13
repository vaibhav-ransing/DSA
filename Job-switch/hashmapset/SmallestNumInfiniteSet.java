import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class SmallestNumInfiniteSet {

    class SmallestInfiniteSet {

        PriorityQueue<Integer> pq;
        HashSet<Integer> set;
        int min;

        public SmallestInfiniteSet() {
            pq = new PriorityQueue<>();
            set = new HashSet<>();
            min = 1;
        }

        public int popSmallest() {
            if (pq.size() > 0) {
                set.remove(pq.peek());
                return pq.poll();
                
            } else {
                return min++;
            }
        }

        public void addBack(int val) {
            if (min > val && !set.contains(val)){
                set.add(val);
                pq.add(val);
            }
        }
    }

}
