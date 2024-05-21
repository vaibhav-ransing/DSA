package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoSum {

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

    //      4
    //     2
    //   -3
    //     -1
    //       0

        while (leftStack.size() > 0 && rightStack.size() > 0 && leftStack.peek().val != rightStack.peek().val) {
            int sum = leftStack.peek().val + rightStack.peek().val;
            System.out.println(leftStack.peek().val +" "+ rightStack.peek().val +" "+sum);
            if(sum == k){
                return true;
            }else if(sum < k){ // increate the left stack value
                TreeNode temp = leftStack.pop().right;
                while(temp != null){
                    leftStack.push(temp);
                    temp = temp.left;
                }
            }else{
                TreeNode temp = rightStack.pop().left;
                // Changed to correctly handle the traversal of the left subtree's right descendants
                while (temp != null){
                    rightStack.push(temp); // Push the current node
                    temp = temp.right; // Move to the right child
                }
            }
        }

        return false;
    }

    // Brute force solution

    List<Integer> inorder;

    public boolean findTarget2(TreeNode root, int k) {
        inorder = new ArrayList<>();
        fillInorder(root);
        int i = 0;
        int j = inorder.size() - 1;
        System.out.println(inorder);
        System.out.println(i + " " + j + " " + (i < j));
        while (i < j) {
            int sum = inorder.get(i) + inorder.get(j);
            System.out.println(i + " " + j + " " + sum);
            if (sum == k)
                return true;
            else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public void fillInorder(TreeNode node) {
        if (node == null)
            return;
        fillInorder(node.left);
        inorder.add(node.val);
        fillInorder(node.right);
    }

    public static void main(String[] args) {

    }
}
