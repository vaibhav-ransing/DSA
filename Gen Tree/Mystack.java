import java.util.ArrayList;

public class Mystack {
    
    public static class stack{
        ArrayList<Integer> al = new ArrayList<>();
        int index=-1;

        void push(int val){
            al.add(val);
            index++;
        }
        void pop(){
            if(index!=-1){
                al.remove(index);
                index--;
            }else
                System.out.println("Empty Stack");
            
        }
        void display(){
            for (Integer x : al) {
                System.out.print(x+" ");
            }
        }
    }

    public static void main(String[] args) {
        stack s1 = new stack();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.display();
        s1.pop();
        System.out.println("");
        s1.display();

    }
}
