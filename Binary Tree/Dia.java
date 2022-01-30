import java.io.*;
import java.util.*;

public class Dia {
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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }


  public static int diameter1(Node node) {
    ans = 0;
    dia1(node);
    return ans;
  }

  //static method which is first Approach
  static int ans = 0;
  public static int dia1(Node node)
  {
    if (node == null)
    {
      return -1;
    }

    int lh = dia1(node.left);
    int rh = dia1(node.right);

    ans = Math.max(lh + rh + 2, ans);

    return Math.max(lh, rh) + 1;
  }

  //heapMover method -->Method -2
  public static class HeapMover {
    int dia = 0;
  }
  public static int dia2(Node node,HeapMover mover)
  {
    if (node == null)
    {
      return -1;
    }

    int lh = dia2(node.left,mover);
    int rh = dia2(node.right,mover);

    mover.dia = Math.max(lh + rh + 2,mover.dia);

    return Math.max(lh, rh) + 1;
  }
  
  //method 3
  public static int dia3(Node node)
  {
      if(node == null)
      {
          return 0;
      }
      
      int lh = height(node.left);
      int rh = height(node.right);
      
      int myDia = lh + rh + 2;
      
      int leftDia = dia3(node.left);
      int rightDia = dia3(node.right);
      
      return Math.max(myDia,Math.max(leftDia,rightDia));
  }
  
  //method-4
  public static class DiaAHg{
      int dia = 0;
      int hi = -1;
  }
  
  public static DiaAHg dia4(Node node)
  {
      if(node == null)
      {
          return new DiaAHg();
      }
      DiaAHg left = dia4(node.left);
      DiaAHg right = dia4(node.right);
      
      DiaAHg mine = new DiaAHg();
      mine.hi = Math.max(left.hi,right.hi) + 1;
      mine.dia = Math.max(left.hi + right.hi + 2,Math.max(left.dia,right.dia));
      
      return mine;
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

    // int diameter = 0;
    // diameter = diameter1(root);
    // System.out.println(diameter);
    
    // HeapMover mover = new HeapMover();
    // dia2(root,mover);
    // System.out.println(mover.dia);
    
    // System.out.println(dia3(root));
    
    DiaAHg p = dia4(root);
    System.out.println(p.dia);
  }

}