package LinkedList;

import LinkedList.subtractLinkedList.Node;

public class lc_2{

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode ans = new ListNode();
        ListNode temp = ans;
        while(l1!=null || l2!= null || carry!=0){
            int num = carry;
            if(l1!=null){
                num+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                num+=l2.val;
                l2 = l2.next;
            }
            carry = num/10;
            num = num%10;
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return ans;
    }

    int getSize(ListNode node) {
        int s = 0;
        while(node != null) {
            s++; node = node.next;
        }
        return s;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        if(sizeA>sizeB){
            while(sizeA!=sizeB){
                headA = headA.next;
                sizeA--;
            }
        }else if(sizeA<sizeB){
            while(sizeB!=sizeA){
                headB = headB.next;
                sizeB--;
            }
        }
        ListNode ans = null;
        while(headA!=null && headB!=null){
            if(headA==headB){
                ans = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}