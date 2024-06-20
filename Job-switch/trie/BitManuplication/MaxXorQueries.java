package BitManuplication;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MaxXorQueries {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        Trie trie = new Trie();

        PriorityQueue<int[]> queriesPq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            queriesPq.add(new int[] { query[0], query[1], i });
        }
        PriorityQueue<Integer> numsPq = new PriorityQueue<>();
        IntStream.range(0, nums.length).forEach(i -> numsPq.add(nums[i]));

        int ans[] = new int[queries.length];

        while (queriesPq.size() > 0) {
            int[] query = queriesPq.poll();
            int xi = query[0], mi = query[1];

            while (numsPq.size() > 0 && numsPq.peek() <= mi) {
                trie.insert(numsPq.poll());
            }
            if (trie.root.child[0] == null && trie.root.child[1] == null) {
                ans[query[2]] = -1;
            } else {
                ans[query[2]] = trie.getMax(xi);
            }
        }
        return ans;
    }

    class Node {
        Node[] child;

        Node() {
            this.child = new Node[2];
        }
    }

    class Trie {
        Node root = new Node();

        void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null) {
                    node.child[bit] = new Node();
                }
                node = node.child[bit];
            }
        }

        int getMax(int num) {
            int maxXor = 0;
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int desiredBit = 1 - bit;
                if (node.child[desiredBit] != null) {
                    node = node.child[desiredBit];
                    maxXor = maxXor | (1 << i);
                } else {
                    node = node.child[bit];
                }
            }
            return maxXor;
        }
    }

}
