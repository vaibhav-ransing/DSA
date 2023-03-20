import java.util.ArrayList;
import java.util.Collections;

public class heap {
    


    public static class myPriorityQueue<T>{
        public myPriorityQueue() {};

        ArrayList<Integer> list;
        public myPriorityQueue(T[] arr){
            list = new ArrayList<>();

        }
        void add(int val){
            list.add(val);
            
        }
        void upheapify(int idx){
            if(idx==0)  return;
            int parent = (idx-1)/2;
            if(list.get(parent) > list.get(idx)){
                Collections.swap(list, idx, parent);
            }
            upheapify(parent);
        }
    }
}
