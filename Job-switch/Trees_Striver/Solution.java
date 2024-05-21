import java.util.*;

class Solution {
    Stack<TreeNode> leftStack;
    Stack<TreeNode> rightStack;

    public boolean findTarget(TreeNode root, int k) {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
        
        TreeNode node = root;
        while (node != null) {
            leftStack.push(node);
            node = node.left;
        }
        node = root;
        while (node != null) {
            rightStack.push(node);
            node = node.right;
        }

        while (!leftStack.isEmpty() && !rightStack.isEmpty() && leftStack.peek() != rightStack.peek()) {
            int leftValue = leftStack.peek().val;
            int rightValue = rightStack.peek().val;
            int sum = leftValue + rightValue;
            System.out.println(leftValue + " " + rightValue + " " + sum);
            
            if (sum == k) {
                return true;
            } else if (sum < k) {
                TreeNode temp = leftStack.pop().right;
                while (temp != null) {
                    leftStack.push(temp);
                    temp = temp.left;
                }
            } else {
                TreeNode temp = rightStack.pop().left;
                while (temp != null) {
                    rightStack.push(temp);
                    temp = temp.right;
                }
            }
        }

        return false;
    }
}