import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test{

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

    static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.size()>0){
            Node peek = queue.remove();
            if(peek==null){
                System.out.println();
                continue;
            }
            System.out.print(peek.data+" ");
            if(peek.left!=null){
                queue.add(peek.left);
            }
            if(peek.right!=null){
                queue.add(peek.right);
            }
            queue.add(null);
        }
    }

    static class pair{
        Node node;
        int horizontal;
        pair(Node node, int h){
            this.node = node;
            this.horizontal = h;
        }
    }

    static void topView(Node root){
        HashMap<Integer, String> map =  new HashMap<>();
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(queue.size()>0){
            pair peek = queue.remove();

            if(map.containsKey(peek.horizontal)==false){
                map.put(peek.horizontal, peek.node.data+"");
                min = Math.min(min, peek.horizontal);
                max = Math.max(max, peek.horizontal);
            }
            if(peek.node.left != null){
                queue.add(new pair(peek.node.left, peek.horizontal-1));
            }
            if(peek.node.right != null){
                queue.add(new pair(peek.node.right, peek.horizontal+1));
            }
        }

        int i = min;
        for(i=min; i<=max; i++){
            System.out.println(map.get(i));
        }
    }


    public static void main(String[] args) {
        Node lr = new Node(7, null, null);
        Node l = new Node(5, null, lr);
        Node r = new Node(20, null, null);

        Node root = new Node(10, l, r);
        // levelOrder(root);
        topView(root);
    }
}