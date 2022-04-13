import java.util.ArrayList;
import java.util.Stack;

public class genTree {
    
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }

    public static Node construcor(int arr[]){
        Stack<Node> stack= new Stack<>();
        Node root = new Node(arr[0]);
        stack.push(root);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==-1)
                stack.pop();
            else{
                Node newNode = new Node(arr[i]);
                stack.peek().children.add(newNode);
                stack.push(newNode);
            }
        }
        return root;
    }
    public static void display(Node node){
        
        System.out.println(node.data);
        for(Node child: node.children){
            display(child);
        }
        return;
    }
    
    public static int size(Node node){
        int size1 = 0;
        for(Node child: node.children){
            size1 += size(child);    
        }
        return size1+1;
    }
    
    public static int height(Node node){
        int h=0;
        for(Node child: node.children){
            h = Math.max(h, height(child));
        }
        return h+1;
    }

    static boolean v1 = false;
    static boolean v2 = false;
    static boolean firstTime = false;
    static Node ans = null;
    public static void LCA(Node node, int d1, int d2){
        if(node.data==d1)
            v1=true;
        


        for(Node child: node.children){
            LCA(child, d1, d2);

        }

    }


    public static void main(String[] args) {

        int arr[] = {10 ,20 ,-1 ,30 ,50 ,-1,60, -1 ,-1 ,40 ,-1 ,-1};
        Node root = construcor(arr);
        // System.out.println(n.data);
        System.out.println(height(root));

    }
}
