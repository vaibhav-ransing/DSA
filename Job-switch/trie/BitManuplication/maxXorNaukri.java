package BitManuplication;

import java.util.ArrayList;

public class maxXorNaukri {

    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        // Write your code here.
        Trie trie = new Trie();
        for (int val : arr1) {
            trie.insert(val);
        }
        int max = 0;
        for (int val : arr2) {
            max = Math.max(max, trie.getMax(val));
        }
        return max;
    }

    static class Node {
        Node[] child;

        Node() {
            this.child = new Node[2];
        }
    }

    static class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null)
                    node.child[bit] = new Node();
                node = node.child[bit];
            }
        }

        int getMax(int num) {
            Node currentNode = root;

            // if we find opposite i-th bit of num then we move to that bit (opposite) and along with that toogle the i-th bit of maxXor;
            int maxXOR = 0;  // we will keep this as maximum we can find

            for (int i = 31; i >= 0; i--) {

                int bit = (num >> i) & 1;
                int desiredBit = 1 - bit;

                if (currentNode.child[desiredBit] != null) {
                    currentNode = currentNode.child[desiredBit];
                    maxXOR = maxXOR | (1 << i);  // enable the bit of maxXor 

                } else {
                    currentNode = currentNode.child[bit];
                }
            }
            return maxXOR;
        }
    }

}
