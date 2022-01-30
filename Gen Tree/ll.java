public class ll{

    public static class Node{
        int data;
        Node next;
    }
    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node n = new Node();
            n.data = val;
            if(size==0){
                head = tail = n;
            }else{
                tail.next = n;
                tail = n;
            }
            size++;
        }
        void display(){
            Node temp = head;
            while(temp!=null){
                System.out.println(temp.data);
                temp =temp.next;
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