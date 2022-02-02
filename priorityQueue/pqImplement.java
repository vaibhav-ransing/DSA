import java.io.*;
import java.util.*;

 class pq {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      data.add(val);
      int childIndex = data.size()-1;
      int parentIndex = (childIndex-1)/2; 

      while(data.get(parentIndex)>data.get(childIndex)){

            swap(parentIndex, childIndex);
            // System.out.println(data);

            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;
            if(childIndex==0)
                break;
      }
    }
    public void swap(int i, int j){
        int vali = data.get(i);
        int valj = data.get(j);
        data.set(i, valj);
        data.set(j, vali);
    }

    public int remove() {
      // write your code here
        if(data.size()==0)
            return -1;
        int lastIndex = data.size()-1;
        int rv = data.get(0);
        data.set(0, data.get(lastIndex));
        data.remove(lastIndex);
        
        int parentIndex = 0;
        int childIndex=1;
        if(data.size()<2){
            return rv;
        }
        if(data.size()>=3){
            if( data.get(1) > data.get(2))
                childIndex = 2;
        }

        while( parentIndex!=data.size() && childIndex!=data.size() && data.get(parentIndex)> data.get(childIndex)){

            System.out.println("pareindex "+ parentIndex);
            System.out.println("childIndex "+ childIndex);

            swap(parentIndex, childIndex);
            
            parentIndex = childIndex;
            if(parentIndex==data.size()-1)
                break;
            childIndex = 2*parentIndex+1;
            int childIndex2 = 2*parentIndex+2;
            if(childIndex2 < data.size()){
                if(data.get(childIndex)> data.get(childIndex2))
                    childIndex = childIndex2;
            }
        }   

        return rv;
    }

    public int peek() {
      // write your code here
      if(data.size()==0)
        return -1;
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
    public void display(){
        System.out.println(data);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }else
            System.out.println("underflow");
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }else
            System.out.println("UnderFLow");
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      } else if(str.startsWith("display")){
        qu.display();
      }
      str = br.readLine();
    }
  }
}