import java.io.*;
import java.util.*;

 class temp {

  public static class PriorityQueue{
        ArrayList<Integer> data;
        PriorityQueue(){
            data = new ArrayList<>();
        }
        public void add(int val){
            data.add(val);
            upheapyfy(data.size()-1);
        }
        public void upheapyfy(int i){
            if(i==0)
                return;
            int parentIndex =  (i-1)/2;
            if(data.get(parentIndex) > data.get(i)){
                swap(i, parentIndex);
                upheapyfy(parentIndex);
            }
        }
        public void swap(int i, int j){
            int val = data.get(i);
            data.set(i, data.get(j));
            data.set(j, val);
        }
        
        public int remove(){
            if(data.size()==0)
              return -1;
            int rv = data.get(0);
            data.set(0, data.get(data.size()-1));
            data.remove(data.size()-1);

            downHeapify(0);
            return rv;
        }
        public void downHeapify(int pi){
            if(pi==data.size()-1)
                return;
            int min = pi;
            int li = 2*pi +1;
            if(li<data.size() && data.get(li) < data.get(min))
                min = li;

            int ri = 2*pi +2;
            if(ri<data.size() && data.get(ri) < data.get(min))
                min = ri;
            
            if(min!=pi){
                swap(min, pi);
                downHeapify(min);
            }
        }

        
        public int peek(){
            if(data.size()==0)
              return -1;
            return data.get(0);
        }
        public int size(){
            return data.size();
        }
        public void display(){
            System.out.println(data);
        }

    }

  public static int minNum(int yashDaily, int rohitDaily , int diff){
    if(yashDaily > rohitDaily)
      return -1;

    int days = 1;
    int dayYash = yashDaily + diff;
    int dayRohit = rohitDaily;
    diff = dayYash - dayRohit;
    if(diff > 0){
      days += minNum(yashDaily, rohitDaily, diff);
    }
    return days;
  }
  
  public static void main(String[] args) throws Exception {


    System.out.println(minNum(3, 5, 5));



    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // PriorityQueue qu = new PriorityQueue();

    // String str = br.readLine();
    // while (str.equals("quit") == false) {
    //   if (str.startsWith("add")) {
    //     int val = Integer.parseInt(str.split(" ")[1]);
    //     qu.add(val);
    //   } else if (str.startsWith("remove")) {
    //     int val = qu.remove();
    //     if (val != -1) {
    //       System.out.println(val);
    //     }else
    //       System.out.println("Underflow");
    //   } else if (str.startsWith("peek")) {
    //     int val = qu.peek();
    //     if (val != -1) {
    //       System.out.println(val);
    //     }else
    //       System.out.println("Underflow");
    //   } else if (str.startsWith("size")) {
    //     System.out.println(qu.size());
    //   } else if (str.startsWith("display")) {
    //         qu.display();
    // }
    //   str = br.readLine();
    // }
  }
}