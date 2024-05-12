public class PreordAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, 0, inorder, 0, inorder.length-1);
    }

    public TreeNode recursion(int[] preorder, int preIdx, int[] inorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        
        int val = preorder[preIdx];
        TreeNode currNode = new TreeNode(val);
        
        int currPreIdxInInorder = -1;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                currPreIdxInInorder = i;
                break;
            }
        }
        
        int leftSubtreeSize = currPreIdxInInorder - inLeft; // Size of the left subtree
        
        currNode.left = recursion(preorder, preIdx + 1, inorder, inLeft, currPreIdxInInorder - 1);
        // preIdx
        currNode.right = recursion(preorder, preIdx + leftSubtreeSize + 1, inorder, currPreIdxInInorder + 1, inRight);
        
        return currNode;
    }
    

   
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}