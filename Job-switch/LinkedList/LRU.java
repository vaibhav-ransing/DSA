package LinkedList;

import java.util.HashMap;

public class LRU {

    class LRUCache {

        Node head;
        Node tail;
        HashMap<Integer, Node> map;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail; // Initialize dummy nodes' next and prev pointers
            tail.prev = head; // Dummy tail points back to head
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            moveNodeToHead(map.get(key));
            return map.get(key).val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // move node to map.key node to head
                moveNodeToHead(map.get(key));
                return;
            }
            if (map.size() == capacity) {
                // remove tail
                map.remove(tail.key);
                removeTail();
            }

            Node node = new Node(key, value);
            map.put(key, node);
            addNewHead(node);
        }

        void addNewHead(Node node) {
            if (head.key == -1) {
                head = node;
                tail = node;
                return;
            }
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }

        void moveNodeToHead(Node node) {
            // if node is already head keep it as it is
            if (head == node)
                return;
            // If node is tail: remove the tail and move it to head
            if (node == tail) {
                Node curr = node;
                removeTail();
                addNewHead(curr);
                return;
            }
            // Node is some middle node
            Node curr = node;
            Node nodePrev = node.prev;
            Node nodeNext = node.next;

            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;

            addNewHead(curr);
        }

        void removeTail() {
            if (head == tail) {
                head = new Node(-1, -1);
                tail = new Node(-1, -1);
                return;
            }
            Node tailPrev = tail.prev;
            tailPrev.next = null;
            tail = tailPrev;
        }
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node() {
        }
    }
}
