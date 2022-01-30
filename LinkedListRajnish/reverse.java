class reverse{


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
        
    class Solution {
        public ListNode reverse(ListNode head){
            ListNode curr = head;
            ListNode prev = null;
            
            while(curr!=null){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
        public void reorderList(ListNode head) {
            reverse(head);
        }
    }


    public static void main(String[] args) {
        
    }
}