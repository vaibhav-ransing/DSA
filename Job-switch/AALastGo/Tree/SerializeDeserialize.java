package AALastGo.Tree;

import java.util.*;

public class SerializeDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {

        String[] arr = str.split(",");
        Stack<Pair> stack = new Stack<>();
        System.out.println(str);
        if (arr.length == 0 || arr[0].equals("null"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(arr[0]));

        stack.push(new Pair(node, 0));
        int idx = 1;

        while (idx < arr.length && stack.size() > 0) {

            String val = arr[idx]; // idx++ will break the code when poping we should then do idx--
            Pair peek = stack.peek();
            if (peek.count == 0) { // val should be left side
                if (!val.equals("null")) {
                    TreeNode nodeLeft = new TreeNode(Integer.parseInt(val));
                    peek.node.left = nodeLeft;
                    stack.push(new Pair(nodeLeft, 0));
                }
                peek.count += 1;
                idx++;
            } else if (peek.count == 1) { // right side
                if (!val.equals("null")) {
                    TreeNode nodeRight = new TreeNode(Integer.parseInt(val));
                    peek.node.right = nodeRight;
                    stack.push(new Pair(nodeRight, 0));
                }
                peek.count += 1;
                idx++;
            } else {
                stack.pop();
            }
        }
        return node;
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

class Pair {

    TreeNode node;
    int count;

    Pair(TreeNode node, int count) {
        this.node = node;
        this.count = count;
    }

    @Override
    public String toString() {
        return "node= " + node.val + " count= " + count;
    }
}