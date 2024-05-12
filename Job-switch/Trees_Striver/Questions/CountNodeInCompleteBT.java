public class CountNodeInCompleteBT {
    

    public int countNodes(TreeNode root) {
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh != rh){
            return 1 + countNodes(root.left) + countNodes(root.right);
        }else{
            return (int) Math.pow(2, lh) - 1;
        }
    }
    public int 
}
