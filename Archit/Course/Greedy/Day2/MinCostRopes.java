package Day2;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class MinCostRopes {
    
    long minCost(long arr[], int n){
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(long val: arr){
            queue.add(val);
        }
        long total=0;
        while(queue.size()>1){
            long val1 = queue.remove();
            long val2 = queue.remove();
            total+=val1+val2;
            queue.add(val1+val2);
        }
        return total;
    }
}
