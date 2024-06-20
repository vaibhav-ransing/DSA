package BitManuplication;

import java.util.ArrayList;

public class Striver {

    class Node {
        Node[] links;
        Node() {
            links = new Node[2];
        }
        boolean containsKey(int bit) {
            return links[bit] != null;
        }
        Node get(int bit) {
            return links[bit];
        }
        void put(int bit, Node node) {
            links[bit] = node;
        }
    }

    class Trie {
        Node root;
        Trie() {
            root = new Node();
        }
        void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }
        int getMax(int num) {
            Node node = root;

            // Initialize the maximum XOR value
            int maxNum = 0;

            // Iterate through each bit of
            // the number (from left to right)
            for (int i = 31; i >= 0; i--) {

                // Extract the i-th
                // bit of the number
                int bit = (num >> i) & 1;

                // If the complement of the current
                // bit exists in the Trie
                if (node.containsKey(1 - bit)) {

                    // Update the maximum XOR
                    // value with the current bit
                    maxNum |= (1 << i);

                    // Move to the child node corresponding
                    // to the complement of the current bit
                    node = node.get(1 - bit);
                } else {

                    // Move to the child node
                    // corresponding to the current bit
                    node = node.get(bit);
                }
            }
            // Return the maximum XOR value
            return maxNum;
        }
    }

    class Main {
        int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
            Trie trie = new Trie();
            for (int it : arr1) {
                trie.insert(it);
            }
            // Initialize the maximum XOR value
            int maxi = 0;
            for (int it : arr2) {
                maxi = Math.max(maxi, trie.getMax(it));
            }
            return maxi;
        }
    }
}
