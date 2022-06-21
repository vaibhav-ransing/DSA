public class inorderSuccesor {
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

    static int solution(Node node, int x){
        Node prev=null;
        Node next;
        boolean falg =false;
        Node curr = node;
        while(curr!=null){
            if(prev.data==x)
                return curr.data;
            prev = curr;

            if(curr.left!=null){
                Node temp = curr.left;
                while(temp.right!=null || temp.right!=curr){
                    temp = temp.right;
                }
                if(temp.right==null){
                    temp.right =curr;
                    curr = curr.left;
                }else{
                    temp.right=null;
                    curr = curr.right;
                }
            }else{
                curr = curr.right;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        
    }
}
