package LinkedList;

public class subtractLinkedList {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node subLinkedList(Node l1, Node l2) {
        
    }

    static int findNum(Node list){
        StringBuilder num = new StringBuilder();
        while(list!=null){
            num.append(list.data);
            list = list.next;
        }
        return Integer.parseInt(num.toString());
    }

    public static void main(String[] args) {
        System.out.println("jel");
    }
}
