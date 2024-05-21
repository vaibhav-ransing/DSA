package BST;

public class DeleteNode2 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left != null && root.right == null){
                return root.left;
            }else if(root.left == null && root.right !=null){
                return root.right;
            }else{
                TreeNode leftMax = bringMax(root.left);
                root.val = leftMax.val;
                root.left =  deleteNode(root.left, leftMax.val);
            }
            return root;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode bringMax(TreeNode node){
        TreeNode temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }
}
