import java.util.PriorityQueue;

public class KthLargestElementInStream {
    
    class KthLargest {

        PriorityQueue<Integer> pq;
        int gk;
        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            gk = k;

            for(int val : nums){
                if(pq.size() < k){
                    pq.add(val);
                }else{
                    if(pq.peek() > val){
                        pq.remove();
                        pq.add(val);
                    }
                }
            }
            System.out.println(pq.peek());
        }
        
        public int add(int val) {
            if(pq.size() < gk){
                pq.add(val);
            }else{
                if(pq.peek() > val){
                    pq.remove();
                    pq.add(val);
                }
            }
            return pq.peek();
        }
    }

}
