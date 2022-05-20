public class morisInorder {
    

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

    static void inorderTraversal(Node node){

        Node temp = node;
        while(temp!=null){

            if(temp.left!=null){
                Node iop = temp.left;
                while(iop.right !=null && iop.right!=temp){
                    iop = iop.right;
                }
                
                if(iop.right==null){
                    // System.out.println(temp.data);
                    iop.right=temp;
                    temp = temp.left;
                }else{
                    iop.right = null;
                    System.out.println(temp.data);
                    temp = temp.right;
                }
            }else{
                System.out.println(temp.data);
                temp = temp.right;
            }
        }
    }




    public static void main(String[] args) {
        Node lr = new Node(7, null, null);
        Node l = new Node(5, null, lr);
        Node r = new Node(20, null, null);

        Node root = new Node(10, l, r);
        inorderTraversal(root);
        // levelOrder(root);
    }
}
