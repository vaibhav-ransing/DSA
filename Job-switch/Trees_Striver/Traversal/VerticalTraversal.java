package Traversal;

import java.util.*;

public class VerticalTraversal {

    static class Pair implements Comparable<Pair> {
        int col;
        int row;
        int val;

        Pair(int col, int row, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }

        public int compareTo(Pair o) {
            if (this.col == o.col && this.row == o.row) {
                return this.val - o.val;
            } else if (this.col == o.col) {
                return this.row - o.row;
            } else {
                return this.col - o.col;
            }
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        TreeMap<Integer, PriorityQueue<Pair>> map = new TreeMap<>();
        fillHashMap(root, 0, 0, map);

        for (int key : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            while (map.get(key).size() > 0) {
                System.out.print(map.get(key).peek().val + "("+map.get(key).peek().row + map.get(key).peek().col +") ");
                temp.add(map.get(key).remove().val);
            }
            ans.add(temp);
            System.out.println();
            System.out.println("----------");
        }

        return ans;
    }

    public static void fillHashMap(TreeNode node, int col, int row, TreeMap<Integer, PriorityQueue<Pair>> map) {

        if (node == null)
            return;

        if (map.containsKey(col)) {
            PriorityQueue<Pair> pq = map.get(col);
            pq.add(new Pair(col, row, node.val));

        } else {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(col, row, node.val));
            map.put(col, pq);
        }

        fillHashMap(node.left, col - 1, row + 1, map);
        fillHashMap(node.right, col + 1, row + 1, map);
    }

    public static void main(String[] args) {
        System.out.println("tst");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// public static List<List<Integer>> verticalTraversal(TreeNode root) {
// List<List<Integer>> ans = new ArrayList<>();
// if (root == null)
// return ans;

// HashMap<Integer, List<Integer>> map = new HashMap<>();
// fillHashMap(root, 0, map);

// Set<Integer> keys = new TreeSet<>();
// keys.addAll(map.keySet());

// for (int key : keys) {
// ans.add(map.get(key));
// }

// return ans;
// }

// public static void fillHashMap(TreeNode node, int col, HashMap<Integer,
// List<Integer>> map) {

// if (node == null)
// return;

// if (map.containsKey(col)) {
// map.get(col).add(node.val);
// } else {
// List<Integer> list = new ArrayList<>();
// list.add(node.val);
// map.put(col, list);
// }
// System.out.println(map.get(col));

// fillHashMap(node.left, col - 1, map);
// fillHashMap(node.right, col + 1, map);
// }