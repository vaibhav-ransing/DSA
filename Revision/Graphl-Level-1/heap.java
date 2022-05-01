import java.util.ArrayList;
import java.util.Collections;

public class heap {
    

    static class myPQ{
        ArrayList<Integer> list;

        myPQ(){
            list = new ArrayList<>();
        }
        void add(int val){
            list.add(val);
            upHeap(list.size()-1);
        }
        void upHeap(int index){
            if(index==0)
                return;
            int pi = (index - 1)/2;
            if(list.get(pi)>list.get(index)){
                Collections.swap(list, pi, index);
                upHeap(pi);
            }
        }
        void remove(){
            if(list.size()==0){
                System.out.println("emptly lis");
                return;
            }
            list.set(0, list.get(list.size()-1));
            list.remove(list.size()-1);
            downHeap(0);

        }   
        void downHeap(int index){
            int pi = index;
            int cl = 2*index+1;
            int cr = 2*index+2;

            if(cl<list.size() && list.get(pi)> list.get(cl))
                pi = cl;
            if(cr< list.size() && list.get(pi)>list.get(cr))
                pi = cr;
            if(index != pi){
                Collections.swap(list, pi, index);
                downHeap(pi);
            }
        }
        void display(){
            System.out.println(list);
        }
    }






    public static void main(String[] args) {
        myPQ pq = new myPQ();
        pq.add(10);
        pq.add(5);
        pq.display();
    }
}
