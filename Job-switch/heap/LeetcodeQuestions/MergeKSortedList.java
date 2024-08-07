import java.util.PriorityQueue;

public class MergeKSortedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode l : lists) {
            if (l != null)
                pq.add(l);
        }
        if (pq.size() == 0)
            return null;
        ListNode head = new ListNode(0);
        ListNode next = head;

        while (pq.size() > 0) {
            ListNode peek = pq.remove();
            next.next = peek;
            next = next.next;

            peek = peek.next;
            if (peek != null)
                pq.add(peek);
        }
        return head.next;
    }
}
