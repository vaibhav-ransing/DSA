package LinkedList;

public class subtractLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node subLinkedList(Node l1, Node l2) {
        long num1 = findNum(l1);
        long num2 = findNum(l2);
        long ans;
        if(num1>=num2){
            ans = num1-num2;
        }else{
            ans = num2-num1;
        }
        if(ans==0){
            return null;
        }
        Node temp = new Node((int) ans%10);
        ans = ans/10;
        while(ans!=0){
            Node curr = new Node((int) ans%10);
            ans = ans/10;
            curr.next = temp;
            temp = curr;
        }
        return temp;
    }

    static long findNum(Node list){
        StringBuilder num = new StringBuilder();
        while(list!=null){
            num.append(list.data);
            list = list.next;
        }
        return Long.parseLong(num.toString());
        // return Integer.parseInt(num.toString());
    }

    public static void main(String[] args) {
        System.out.println("jel");
    }
}
