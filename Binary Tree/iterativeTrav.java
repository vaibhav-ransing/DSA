import java.util.Stack;
public class iterativeTrav {
    
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node l, Node r){
            this.data = data;
            this.left = l;
            this.right = r;
        }
    }

    static class Pair{
        Node node;
        int state;
        Pair(Node n, int s){
            this.node = n;
            this.state = s;
        }
    }
    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
    
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
    
        int idx = 0;
        while (st.size() > 0) {
          Pair top = st.peek();
          if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
              top.node.left = new Node(arr[idx], null, null);
              Pair lp = new Pair(top.node.left, 1);
              st.push(lp);
            } else {
              top.node.left = null;
            }
    
            top.state++;
          } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
              top.node.right = new Node(arr[idx], null, null);
              Pair rp = new Pair(top.node.right, 1);
              st.push(rp);
            } else {
              top.node.right = null;
            }
    
            top.state++;
          } else {
            st.pop();
          }
        }
    
        return root;
      }


    public static class pair{
        int state=0;
        Node node;
    }
    public static void traversalIterative(Node node){
        String preorder="";
        String postorder="";
        String inorder="";
        pair p = new pair();
        p.node = node;
        Stack<pair> stack = new Stack<>();
        stack.push(p);
        while(stack.size()>0){
            pair peek = stack.peek();
            if(peek.state==0){
                preorder+=peek.node.data+" ";
                System.out.print("pre "+peek.node.data+" ");
                if(peek.node.left!=null){
                    pair np = new pair();
                    np.node = peek.node.left;
                    stack.push(np);
                }
                peek.state++;
            }else if(peek.state==1){
                System.out.print("inorder "+peek.node.data+" ");
                inorder+=peek.node.data+" ";
                if(peek.node.right!=null){
                    pair np = new pair();
                    np.node = peek.node.right;
                    stack.push(np);
                }
                peek.state++;
            }else if(peek.state==2){
                System.out.print("post "+peek.node.data+" ");
                postorder+=peek.node.data+" ";
                stack.pop();
            }
        }
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }
// 
    public static void main(String[] args) {
        // Integer arr[] = {50,null, null}; 
        // Node root = construct(arr);
        Node left = new Node(10, null, null);
        Node right = new Node(10, null, null);
        Node root = new Node(10, left, right);
        traversalIterative(root);

    }   
}
