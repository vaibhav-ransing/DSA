import java.util.ArrayList;
import java.util.Stack;

public class Main1 {
    static class Node{
        int data;
        ArrayList<Node> child=new ArrayList<>();
        Node(int val){
            this.data =  val;
        }
    }
    static Node constructor(int arr[]){

        Node root=null;
        Stack<Node> st=new Stack<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1) {
                st.pop();
                continue;
            }
            Node t=new Node(arr[i]);
        
            if(st.size()==0) 
                root=t;
            else 
                st.peek().child.add(t);

            st.push(t);
        }
        return root;
    }
    static Node construct(int arr[]){
        Stack<Node> stack = new Stack<>();
        Node root = new Node(arr[0]); 
        stack.push(root);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==-1)
                stack.pop();
            else{
                Node temp = new Node(arr[i]);
                stack.peek().child.add(temp);
                stack.push(temp);
            }
        }
        return root;
    }

    public static Node construct2(int arr[]){
        Stack<Node> s = new Stack<>();
        Node root = new Node(arr[0]);
        s.push(root);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==-1){
                Node next = s.pop();
                if(s.size()>0)
                    s.peek().child.add(next);
            }else{
                Node n = new Node(arr[i]);
                s.push(n);
            }
        }
        return root;
    }


    static int size(Node root){
        int s = 0;
        for(Node child: root.child){
            s+=size(child);
        }
        return 1+s;
    }
    static void display(Node root){
        System.out.println(root.data);
        for(Node child: root.child)
            display(child);
    }

    public static void main(String[] args) {
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        // display(constructor(arr));
        Node root = constructor(arr);
        // display(root);
        // System.out.println(size(root));
        display(root);
        
    }
}