package BitManuplication;

public class TrieMaxXorSelf {

    class Node {
        Node[] child;

        Node() {
            this.child = new Node[2];
        }
    }

    class Trie {
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
            int maxXOR = 0;

            for (int i = 31; i >= 0; i--) {

                int bit = (num >> i) & 1;
                int desiredBit = 1 - bit;

                if (currentNode.child[desiredBit] != null) {
                    currentNode = currentNode.child[desiredBit];
                    maxXOR = maxXOR | (1 << i);
                    
                } else {
                    currentNode = currentNode.child[bit];
                }
            }
            return maxXOR;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int val : nums) {
            trie.insert(val);
        }
        int max = 0;
        for (int val : nums) {
            max = Math.max(max, trie.getMax(val));
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 9;
        int v = (n >> 3) & 1;
        System.out.println(v);
    }
}