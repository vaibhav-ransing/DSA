public class longestUnival {
    
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int ans =0;
    public int longestUnivaluePath(TreeNode root) {
        ans=0;
        pair p = helper(root);
        ans = Math.max(ans, p.len);
        return ans==0?0:ans-1;
    }   
    static class pair{
        int val;
        int len;
        pair(int val, int len){
            this.val = val;
            this.len = len;
        }
    }
    static pair helper(TreeNode node){
        if(node==null){
            return new pair(Integer.MAX_VALUE, 0);
        }
        pair left = helper(node.left);
        pair right = helper(node.right);

        ans = Math.max(ans, Math.max(left.len, right.len));

        if(left.val==right.val && right.val==node.val){
            ans = Math.max(ans, left.len+right.len+1);
            if(left.len>right.len){
                return new pair(node.val, left.len+1);
            }
            return new pair(node.val, right.len+1); 

        }else if(left.val==node.val){
            return new pair(node.val, left.len+1);

        }else if(right.val==node.val){
            return new pair(node.val, right.len+1);

        }else{
            return new pair(node.val, 1);
        }
    }





    public static void main(String[] args) {
        
    }
}
