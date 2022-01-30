import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void solve(int n,int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            if(pq.size()<k){
                pq.add(val);
            }else{
                if(val>=pq.peek()){
                    pq.remove();
                    pq.add(val);
                }
            }
        }
        String ans = "";
        while(pq.size()>0){
            int val2 = pq.remove();
            ans = val2+" "+ ans;
        }
        System.out.print(ans);
    }

    public static class pair  implements Comparable{
        int data;
        int li;
        int di;

        // +ve -> this is bigger
        // -ve -> this is smaller
        public int compareTo(Object o){
            pair other = (pair)o; // ye yaad rakhna hai?
            return this.data - other.data;
        }
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0;i<lists.size();i++){
            pair p = new pair();
            p.data = lists.get(i).get(0);
            p.li = i;
            p.di = 0;
            pq.add(p);
        }
        while(pq.size()>0){
            pair p = pq.peek();
            pq.remove();
            rv.add(p.data);
            p.di++;
            if(p.di < lists.get(p.li).size() ){
                pair pnew = new pair();
                pnew.data = lists.get(p.li).get(p.di);
                pnew.li = p.li;
                pnew.di = p.di;
                pq.add(pnew);
            }
        }
  
        return rv;
     }

    public static void sortKsortedArray(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(arr[i]);
            }else{
                int top = pq.peek();
                System.out.println(top);
                pq.remove();
                pq.add(arr[i]);
            }
        }
        while(pq.size()!=0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }

    public static class MedianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
    
        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }
    
        public void add(int val) {
            if (left.size() == 0 && right.size() == 0) {
              left.add(val);
            }
            else if (left.size() == 1 && right.size() == 0) {
              if (val > left.peek()) {
                right.add(val);
              } else {
                int rVal = left.remove();
                left.add(val);
                right.add(rVal);
              }
            }
            else if (left.size() == right.size()) {
              if (val < right.peek()) {
                left.add(val);
              } else {
                left.add(right.remove());
                right.add(val);
              }
            }
            else {
              if (val > left.peek()) {
                right.add(val);
              } else {
                right.add(left.remove());
                left.add(val);
              }
            }
          }
        public int peek() {
          // write your code here
          if(left.size()>=right.size()){
              return left.peek();
          }else{
              return right.peek();
          }
        }
    
        public int remove() {
          // write your code here
          if(left.size()>=right.size()){
            return left.remove();
        }else{
            return right.remove();
        }
        }
    
        public int size() {
          // write your code here
          return left.size()+right.size();
        }
      }
    

    public static void main(String[] args) {
        // int arr[]  ={44 ,-5, -2 ,41 ,12 ,19 ,21 ,-6 };
        int arr[]  ={10 ,20 ,30,40, 40, 50};

    }
}
