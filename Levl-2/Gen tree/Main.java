import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  
  static Node deleteXandShift(Node node, int data){
    
    for(Node child: node.children){
        if(child.data==data){
            ArrayList<Node> temp = child.children;
            node.children.remove(child);
            replace(node, data, temp);
            
        }
    }
    for(Node child: node.children)
        deleteXandShift(child, data);
    return node;

  }
  static Node helper(Node node, int data){
    Node minNode = null;
    int min=Integer.MAX_VALUE;
    for(Node child: node.children){
        if(node.data!=data){
            if(child.children.size()<min)
                minNode = child;
        }
    }
    return minNode;
  }

  static void replace(Node node, int data, ArrayList<Node> temp){
    Node minNode = helper(node, data);

    for(int i=0;i<node.children.size();i++){
        if(node.children.get(i).data==minNode.data){
            for(Node elem: temp){
                node.children.get(i).children.add(elem);
            }
            break;
        }
    }
    
    
  }
  public static void main(String[] args) throws Exception {
    
    int arr[] = {10, 20,80,-1 ,-1, 30, 50,100,-1 ,-1 ,60 ,-1, -1, 40, -1, -1};
    Node  root = construct(arr);
    display(root);
    System.out.println("----------");
    root = deleteXandShift(root, 30);
    display(root);

  }

}