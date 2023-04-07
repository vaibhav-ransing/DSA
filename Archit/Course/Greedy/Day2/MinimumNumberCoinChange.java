package Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumNumberCoinChange {
    

    static List<Integer> minPartition(int N)
    {
        // code here
        int change[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int val: change){
            queue.add(val);
        }
        List<Integer> list = new ArrayList<>();
        while(N>0){
            if(queue.peek()>N){
                queue.remove();
            }else{
                list.add(queue.peek());
                N-=queue.peek();
            }
        }
        return list;
    }
}
