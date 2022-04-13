import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

import javax.management.relation.Role;

public class bt {
    
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int val, Node left, Node right){
            this.data = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int size(Node node){
        if(node==null)
            return 0;
        int size = 0;
        size+=size(node.left);
        size+=size(node.right);
        return 1+size;
    }
    public static int contains(Node root , Node find){
        int s = 0;
        if(root.left==null && root.right==null)
            return 0;
        contains(root.left, find);
        if(root.data==find.data && root.left.data==find.left.data && root.right.data==find.right.data)
            s+=1;
        contains(root.left, find);
        return s;
    }
    static boolean ans = false;
    public static void duplicate(Node root, Node node){
        if(node==null)
            return;
        if(node.left==null && node.right==null)
            return;
        duplicate(root, node.left);
        Node temp = node;
        if(size(temp)==3){
            // if(contains(root, temp)==2)
            //     ans = true;
            int val = contains(root, temp);
            System.out.println("ans "+val);
        }
        duplicate(root, node.right);
    }

    public static void print(Node node){
        if(node==null)
            return;
        System.out.println(node.data);
        print(node.left);
        print(node.right);
    }
    public static void main(String[] args) {
        Node four = new Node(4, null, null);
        Node five = new Node(5, null, null);
        Node four1 = new Node(4, null, null);
        Node five1 = new Node(5, null, null);
        Node two = new Node(2, four, five);
        Node two1 = new Node(2, four1, five1);

        Node three = new Node(3, null, two1);
        Node root = new Node(1, two, three);
        duplicate(root, root);
        System.out.println(ans);
        
    }
}
