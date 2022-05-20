import java.util.ArrayList;
public class borderTraversal {
    
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static void solution(Node root){
        ArrayList<Integer> al = new ArrayList<>();
        leftwall(root, al);
        leafNode(root, al);
        rithWall(root.right, al);
    }

    static void leftwall(Node node, ArrayList<Integer> al){
        if(node.left==null && node.right==null)
            return;

        al.add(node.data);
        if(node.left!=null){
            leftwall(node.left,al );
        }else{
            leftwall(node.right, al);
        }
    }
    static void leafNode(Node node, ArrayList<Integer> al){
        if(node==null)
            return;
        if(node.left==null && node.right==null){
            al.add(node.data);
        }
        leafNode(node.left, al);
        leafNode(node.right, al);
    }

    static void rithWall(Node node, ArrayList<Integer> al){
        if(node.left==null && node.right==null)
            return;
        if(node.right!=null){
            rithWall(node.right, al);
        }else{
            rithWall(node.left, al);
        }
        al.add(node.data);
    }







    public static void main(String[] args) {
        
    }
}
