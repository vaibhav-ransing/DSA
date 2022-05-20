public class fixBst {
    
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

    static void solution(Node node){
        Node n1 = null;
        Node n2 = null;

        Node curr = node;
        while(curr!=null){

            int l=  Integer.MAX_VALUE;
            int r = Integer.MIN_VALUE;

            if(curr.left!=null){

            }else{
                
            }
        }

    }   

    static class pair{
        int min;
        int max;
        pair(int max, int min){
            this.max = max;
            this.min = min;
        }
    }
    static Node n1 = null;
    static Node n2 = null;
    static void solutionPair(Node node){
        helper(node);
        if(n1!=null && n2!=null){
            int temp = n1.data;
            n1.data = n2.data;
            n2.data =temp;
        }
    }
    static pair helper(Node node){
        if(node==null){
            return null;
        }
        pair left = new pair(node.data, node.data);
        pair right = new pair(node.data, node.data);
        if(node.left!=null)
            left = helper(node.left);
        if(node.right!=null)
            right = helper(node.right);
        System.out.println(node.data+" "+ left.max+" "+right.min);

        if(left.max>node.data){
            if(n1==null){
                n1 = node;
            }else{
                n2 = node;
            }
        }
        if(right.min<node.data){
            if(n1==null){
                n1 = node;
            }else{
                n2 = node;
            }
        }
        int min = Math.min( Math.min(left.min, right.min) , node.data);
        int max = Math.max(node.data, Math.max(left.max, right.max));
        return new pair(max, min);
    }
    static void display(Node node){
        if(node==null)
            return;
        System.out.println(node.data);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Node lr = new Node(70, null, null);
        Node l = new Node(20, null, lr);
        Node r = new Node(5, null, null);

        Node root = new Node(10, l, r);
        display(root);
        System.out.println("-----------");
        solutionPair(root);
        display(root);
    }
}
