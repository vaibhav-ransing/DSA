
public class Main{

    static class Node{
        int data;
        Node next;
    }
    static class LinkedList{
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node n = new Node();
            n.data= val;
            n.next = null;

            if(size==0){
                head=tail=n;
            }else{
                tail.next=n;
                tail=tail.next;
            }
            size++;
        }
        void display(){
            while(head!=null){
                System.out.println(head.data);
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addLast(10);
        l1.addLast(20);
        l1.addLast(30);
        l1.display();
    }
}