import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
            pq.add(pile);
        }
        while (k-- > 0 && pq.size() > 0) {
            int peek = pq.remove();
            // if peek=5  
            // ceil of (5/2.0) = 3  -> so we are adding 3 back to the queue
            // the reduction in sum is not the ceil value of 5/2.0 rather 5/2 so we subtract 5/2 = 2 from sum
            sum -= peek/2;  
            pq.add((int) Math.ceil(peek / 2.0));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println((int) Math.ceil(6 / 2.0));
    }
}
