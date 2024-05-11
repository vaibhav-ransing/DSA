package Traversal;
import java.util.*;

public class BottomView {

    static class Pair{
        int row;
        int data;

        Pair(int row, int data){
            this.row = row;
            this.data = data;
        }
    }

    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.
        TreeMap<Integer, Pair> map = new TreeMap<>();
        traverse(0, 0, map, root);
        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            ans.add(map.get(key).data);
        }
        System.out.println(ans);
        return ans;
    }

    public static void traverse(int row, int col, TreeMap<Integer, Pair> map, TreeNode node) {
        if (node == null)
            return;
        
        Pair currPair = new Pair(row, node.data);
        if (map.containsKey(col) == false) {
            map.put(col, currPair);
        }else{
            Pair peek = map.get(col);
            if(peek.row <= currPair.row){ // if row is same then let it update we want values from right of tree
                map.put(col, currPair);
            }
        }
        traverse(row + 1, col-1, map, node.left);
        traverse(row + 1, col+1, map, node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        bottomView(root);

    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}