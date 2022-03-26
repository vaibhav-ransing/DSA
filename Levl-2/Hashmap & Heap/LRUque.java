import java.util.HashMap;

public class LRUque {
    class LRUCache {

        class Node{
            int key;
            int val;
            Node prev;
            Node next;
        }
        Node head;
        Node tail;
        HashMap<Integer, Node> map = new HashMap<>();
        int cap;
        int size=0;

        public LRUCache(int capacity) {
            this.cap = capacity;
        }
        
        public int get(int key) {
            if(size==0){
                return -1;
            }else{
                Node n = map.get(key);
                moveToFirst(n);
                return n.val;
            }
        }
        
        public void put(int key, int val) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                removeNode(node);
                addFirst(key, val);

            }else if(map.size()==cap){
                int removeKey = tail.key;
                removeNode(tail);
                map.remove(removeKey);

                Node n = addFirst(key, val);
                map.put(key, n);
            }else{
                Node n = addFirst(key, val);
                map.put(key, n);
                size++;
            }
        }

        public void removeNode(Node node){
            if(size==0)
                return;
            if(head == tail){
                head = null;
                tail = null;
            }else if(node==head){
                head = head.next;
                head.prev = null;
            }else if(node==tail){
                tail = tail.prev;
                tail.next = null;
            }else{
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }
            size--;
        }
        public void moveToFirst(Node node){
            Node n = node;
            removeNode(node);
            n.next = head;
            head.prev = n;
            head = n;
        }
        public Node addFirst(int key, int val){
            Node n = new Node();
            n.val = val;
            n.key = key;
            if(size==0){
                head = tail = n;
            }else{
                n.next = head;
                head.prev = n;
                head = n;
            }
            return n;
        }

    }



    public static void main(String[] args) {
        
    }
}
