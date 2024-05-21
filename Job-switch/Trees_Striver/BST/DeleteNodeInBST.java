package BST;

public class DeleteNodeInBST {

    TreeNode leafNode;

    public TreeNode deleteNode(TreeNode root, int key) {
        return goTillKey(root, key);
    }

    public TreeNode goTillKey(TreeNode node, int key) {
        if (node == null)
            return null;
        if (node.val == key) {
            node.right = helperFindLast(node.right);

            if (leafNode == null) {
                return node.left;
            } else {
                node.val = leafNode.val;
                return node;
            }
        }
        if (key < node.val) {
            node.left = goTillKey(node.left, key);
        } else {
            node.right = goTillKey(node.right, key);
        }
        return node;
    }

    public TreeNode helperFindLast(TreeNode node) {
        if (node == null)
            return null;
        if (node.left == null && node.right == null) {
            System.out.println(node.val);
            leafNode = node;
            return null;
        }

        if (node.left != null) {
            node.left = helperFindLast(node.left);
        } else {
            node.right = helperFindLast(node.right);
        }
        return node;
    }
}