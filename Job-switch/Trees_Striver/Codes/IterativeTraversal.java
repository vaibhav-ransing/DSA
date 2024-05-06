package Codes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversal {

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(preOrderIterative(root)); // preorder

        return ans;
    }

    public static List<Integer> preOrderIterative(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if (node == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (stack.size() > 0) {
            node = stack.pop();
            ans.add(node.data); // preorder
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return ans;
    }

    public static List<Integer> inOrderIterative(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if (node == null)
            return ans;

        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.data);
            // if there is no right part 
                // node will be null, the internal while loop wont execute and stack.pop i.e parent node will be popped of curr node.
            node = node.right;

        }
        return ans;
    }

    // using 2 stack
    public static List<Integer> postOrderIterativeUsing2Stack(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if (node == null)
            return ans;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(node);

        while (stack1.size() > 0) {
            
            node = stack1.pop();
            stack2.push(node);

            if(node.left != null) stack1.push(node.left);
            if(node.right != null) stack1.push(node.right);
        }

        while (stack2.size() > 0) {
            ans.add(stack2.pop().data);
        }
        return ans;
    }

    // public static List<Integer> postOrderIterativeUsing1Stack(TreeNode node) {
    //     List<Integer> ans = new ArrayList<>();
    //     if(node == null) return ans;

    //     Stack<TreeNode> stack = new Stack<>();

    //     while (node != null && stack.size() > 0) {
            
    //         while (node != null) {
    //             stack.push(node);
    //             node = node.left;
    //         }
    //         node = stack.peek().left;
    //         if(node != null) continue;
            
            
    //     }


    //     return null;
    // }
};

class Pair {

    int order;
    TreeNode node;

    Pair(TreeNode node, int order) {
        this.node = node;
        this.order = order;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};