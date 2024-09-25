package LinkedList;

import java.util.*;

public class LFU {

    class LFUCache {

        private int capacity;
        private int minFreq = 0;
        private Map<Integer, Integer> keyToVal = new HashMap<>();
        private Map<Integer, Integer> keyToFreq = new HashMap<>();
        private Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys = new HashMap<>();

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!keyToVal.containsKey(key))
                return -1;

            final int freq = keyToFreq.get(key);
            freqToLRUKeys.get(freq).remove(key);
            if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
                freqToLRUKeys.remove(freq);
                ++minFreq;
            }

            // Increase key's freq by 1
            // Add this key to next freq's list
            putFreq(key, freq + 1);
            return keyToVal.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0)
                return;
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                get(key); // Update key's count
                return;
            }

            if (keyToVal.size() == capacity) {
                // Evict LRU key from the minFreq list
                final int keyToEvict = freqToLRUKeys.get(minFreq).iterator().next();
                freqToLRUKeys.get(minFreq).remove(keyToEvict);
                keyToVal.remove(keyToEvict);
            }

            minFreq = 1;
            putFreq(key, minFreq); // Add new key and freq
            keyToVal.put(key, value); // Add new key and value
        }

        private void putFreq(int key, int freq) {
            keyToFreq.put(key, freq);
            freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());
            freqToLRUKeys.get(freq).add(key);
        }
    }

}

class DoublyLinkedList {

    // Node class for each element in the list
    private class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Add node at the front of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) { // List is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) { // List is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Remove the first node of the list
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) { // Only one element in the list
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Remove the last node of the list
    public void removeLast() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) { // Only one element in the list
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // Print the list in forward order
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Print the list in reverse order
    public void printReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Get size of the list
    public int getSize() {
        return size;
    }
}
