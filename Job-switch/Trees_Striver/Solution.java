import java.util.* ;
import java.io.*;

public class Solution 
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        TreeMap<Integer, PriorityQueue<Pair>> map = new TreeMap<>();
        fillHashMap(root, 0, 0, map);

        for (int key : map.keySet()) {
            while (map.get(key).size() > 0) {
                ans.add(map.get(key).remove().val);
            }
        }

        return ans;
    }

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


    public static void fillHashMap(TreeNode<Integer> node, int col, int row, TreeMap<Integer, PriorityQueue<Pair>> map) {

        if (node == null)
            return;

        if (map.containsKey(col)) {
            PriorityQueue<Pair> pq = map.get(col);
            pq.add(new Pair(col, row, node.data));

        } else {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(col, row, node.data));
            map.put(col, pq);
        }

        fillHashMap(node.left, col - 1, row + 1, map);
        fillHashMap(node.right, col + 1, row + 1, map);
    }
}


class TreeNode<T> 
{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) 
    {
        this.data = data;
        left = null;
        right = null;
    }
};
