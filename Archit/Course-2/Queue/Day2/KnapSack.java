package Day2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KnapSack {
    


    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    public static class comparatorValByWeight implements Comparator<Item> {
        
        @Override
        public int compare(Item t, Item o) {
            // return t.age - o.age;
            double val = (t.value*1.0/t.weight) - (o.value*1.0/o.weight);
            if(val>0){
                return -1;
            }else if(val<0){
                return +1;
            }else return 0;
        }
    }

    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        PriorityQueue<Item> pq = new PriorityQueue<>( new comparatorValByWeight());
        int i=0;
        while(i<n){
            pq.add(arr[i++]);
        }
        double ans = 0.0;
        while(pq.size()>0 && W>0){
            Item peek = pq.remove();
            if(peek.weight < W){
                ans+=peek.value;
                W-=peek.weight;
            }else{
                double temp = ((peek.value*(1.0))/peek.weight)*W;
                ans+=temp;
                break;
            }
        }
        return ans;
    }
}
