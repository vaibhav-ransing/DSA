// public import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class test {
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

  static class Pair2{
    Node node;
    int state;
    Pair2(Node node , int state){
      this.node = node;
      this.state = state;
    }
  }
  public static void iterativePrePostInTraversal(Node node) {
    // write your code here
    String pre="";
    String inorder="";
    String post="";
    Pair2 p = new Pair2(node, 0);
    Stack<Pair2> stack = new Stack<>();
    stack.add(p);

    while(stack.size()>0){
      Pair2 peek = stack.peek();
      if(peek.state==0){
        pre+=peek.node.data+" ";
        peek.state=1;
        if(peek.node.left!=null){
          stack.add(new Pair2(node.left , 0));
        }System.out.println(pre+" pre");

      }else if(peek.state==1){
        inorder+=peek.node.data+" ";
        peek.state=2;
        if(peek.node.right!=null){
          stack.add(new Pair2(node.right , 0));
        }System.out.println(inorder+" in");

      }else{
        post+=peek.node.data+" ";
        stack.pop();
      }
    }
    System.out.println(pre);
    System.out.println(inorder);
    System.out.println(post);

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    iterativePrePostInTraversal(root);
  }

}
