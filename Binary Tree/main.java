import java.io.*;
import java.util.*;

public class main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
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

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static class pair{
        int state=0;
        Node node;
  }

  public static void iterativePrePostInTraversal(Node node) {
    // write your code here
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
                // System.out.print("pre "+peek.node.data+" ");
                if(peek.node.left!=null){
                    pair np = new pair();
                    np.node = peek.node.left;
                    stack.push(np);
                }
                peek.state++;
            }else if(peek.state==1){
                // System.out.print("inorder "+peek.node.data+" ");
                inorder+=peek.node.data+" ";
                if(peek.node.right!=null){
                    pair np = new pair();
                    np.node = peek.node.right;
                    stack.push(np);
                }
                peek.state++;
            }else if(peek.state==2){
                // System.out.print("post "+peek.node.data+" ");
                postorder+=peek.node.data+" ";
                stack.pop();
            }
        }
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
  }

  public static class maxPair{
    int max=0;
    int secMax=0;
  }
  public static int diameter(Node root, maxPair p){  
    if(root==null)
      return 0;
    int lenLeft=0;
    int lenRight=0;

    lenLeft+=diameter(root.left, p)+1;
    lenRight+=diameter(root.right, p)+1;

    int len = Math.max(lenLeft, lenRight);
    if(len>p.max){
      p.max = len;
    }else if(len>p.secMax){
      p.secMax = len;
    }
    return len;
  }

  public static Node removeLeaves(Node node){
    // write your code here
    if(node==null)
      return null;
    if(node.left!=null && node.right!=null){
      if(node.left.left==null && node.right.right==null)
        return null;
    }
    removeLeaves(node.left);
    removeLeaves(node.right);

    return node;
  }


  public static void main(String[] args) throws Exception {
    // Integer arr[] = {50,25,12,null, null, 37,30, null,null,null,75,62,null, 70,null,null, 87,null,null}; 
    Integer arr[] = {10,null,30,40,null,null,80,null,120,null,null}; 
    Node root = construct(arr);
    // iterativePrePostInTraversal(root);
    maxPair p = new maxPair();
    diameter(root, p);
    System.out.println(p.max);
    System.out.println(p.secMax);
  }
}