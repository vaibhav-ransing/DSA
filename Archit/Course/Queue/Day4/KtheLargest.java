import java.util.ArrayList;
import java.util.PriorityQueue;

public class KtheLargest {
    
    public static ArrayList<Integer> kLargest(int arr[], int n, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int val: arr){
            if(pq.size()<k){
                pq.add(val);
            }else{
                if(val> pq.peek()){
                    pq.remove();
                    pq.add(val);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(pq.size()>0){
            int val = pq.remove();
            ans.add(ans.size()-1, val);
        }
        return ans;
    }
}
