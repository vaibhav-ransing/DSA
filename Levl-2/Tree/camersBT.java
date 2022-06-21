public class camersBT {
    

    static class Node{
        int val;
        Node left;
        Node right;
    }
    static int count =0;
    static void soln(Node root){
        int val = helper(root);
        if(val==-1) count++;
    }
    static int helper(Node node){
        if(node == null)
            return 0;
        int left = helper(node.left);
        int right = helper(node.right);

        if(left==-1 || right==-1){
            count++;
            return 1;
        }
        if(left==0 || right==0){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
