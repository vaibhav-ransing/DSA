package Questions;

public class ChildrenSumPropertyStriver {

    public static void changeTree(BinaryTreeNode<Integer> root) {
        // Write your code here.
    }

    public static int sendValAndGetVal(BinaryTreeNode<Integer> root, int addition) {

        if (root == null)
            return 0;

        int left = root.left == null ? 0 : root.left.data;
        int right = root.right == null ? 0 : root.right.data;

        if (root.data > left + right) {
            sendValAndGetVal(root.left, root.data);
            sendValAndGetVal(root.right, root.data);
        }
        left = root.left == null ? 0 : root.left.data;
        right = root.right == null ? 0 : root.right.data;

        root.data = left + right;

        return root.data;
    }
}

class BinaryTreeNode<Integer> {
    int data;
    BinaryTreeNode<Integer> left;
    BinaryTreeNode<Integer> right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}