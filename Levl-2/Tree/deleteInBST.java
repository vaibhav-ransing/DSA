import java.sql.RowId;

public class deleteInBST {
    
    static class Node{
        int val;
        Node left;
        Node right;
    }

    static Node deleteNodeInBst(Node root, int val){
        
        if(val==root.val){
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null || root.right==null){
                return root.left==null?root.right:root.left;
            }else{
                setLeftMax(root, root.left);
            }
        }else{
            if(root.val>val){
                root.left =  deleteNodeInBst(root.left, val);
            }else{
                root.right = deleteNodeInBst(root.right, val);
            }
        }
        return root;
    }
    static Node setLeftMax(Node parent, Node currNode){
        if(currNode.right==null){
            parent.val = currNode.val;
            return currNode.left;
        }
        currNode.right = setLeftMax(parent, currNode.right);
        return currNode;
    }



    public static void main(String[] args) {
        
    }
}
