// import java.lang.invoke.ClassSpecializer.Factory;
import java.util.*;
public class genTree {
    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        void levelOrder(){
            Node root = this;
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);
            while(q.size()>0){
                Node temp =  q.remove();
                System.out.print(temp.data+" ");
                for (Node child : temp.children){
                    q.add(child);
                    }
                }   
            }
    }   

    public static Node construct(int arr[]){
        Stack<Node> s = new Stack<>();
        Node root = new Node();
        root.data = arr[0];
        s.push(root);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==-1){
                Node next = s.pop();
                if(s.size()>0)
                    s.peek().children.add(next);
            }else{
                Node n = new Node();
                n.data = arr[i];
                s.push(n);
            }
        }
        return root;
    }

    public static void lineOrder(Node root){

        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> childQue = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            while(q.size()>0) {
                Node temp = q.remove();
                System.out.print(temp.data+" ");
                for (Node child : temp.children) {
                    childQue.add(child);
                }
            }
            
            System.out.println(".");
            // if(q.size()==0){
                q=childQue;
                childQue = new ArrayDeque<>();
            // }
        }
    }

    public static int size(Node root){
        if(root.children.size()==0){
            return 1;
        }
        int s = 0;
        for(Node child: root.children){
            s+=size(child);
        }
        return s+1;
    }

    public static int max(Node root){
        if(root.children.size()==0)
            return root.data;
        int max = 0;
        for(Node child: root.children){
            max = Math.max(max, max(child));
        }
        return Math.max(max, root.data);
    }

    public static int height(Node root){
        if(root.children.size()==0)
            return 1;
        int len=0;
        for(Node child: root.children){
            len = Math.max(height(child), len);
        }
        return len+1;
    }

    public static void levelOrderLinewise(Node root){
        Queue<Node> parent = new ArrayDeque<>();
        Queue<Node> children = new ArrayDeque<>();
        parent.add(root);
        while(parent.size()>0){
            while(parent.size()>0){
                for(Node currNode: parent){
                    System.out.print(currNode.data+" ");
                    for(Node child: currNode.children){
                        children.add(child);
                    }
                    parent.remove();
                }
            }
            System.out.println();
            parent = children;
            children = new ArrayDeque<>();
        }

    }

    public static void levelOrder(Node root){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0){
            int s = queue.size();
            for(int i=0;i<queue.size();i++){
                System.out.print(queue.get(i).data+" ");
            }
            for(int i=0;i<s;i++){
                Node temp = queue.removeFirst();
                for(Node child: temp.children){
                    queue.add(child);
                }
            }
        }
    }
    
    public static void levelOrderZigZag(Node root){
        LinkedList<Node> q = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        boolean even = false;
        q.add(root);
        while(q.size()>0){
            if(even==false){
                Node temp = q.removeLast();
                for(Node child: temp.children){
                    stack.add(child);
                }
                System.out.print(temp.data+" ");
            }else{
                Node temp = q.removeLast();
                System.out.print(temp.data+" ");
                for(int i=temp.children.size()-1; i>=0;i--){
                    stack.add(temp.children.get(i));
                }
            }
            if(q.size()==0){
                even = !even;
                q= stack;
                stack = new LinkedList<>();
                System.out.println();
            }
        }
           
    }

    public static void preOrderTraversal(Node root){
        System.out.print(root.data+"-> ");
        for(Node child: root.children){
            System.out.print(child.data+" ");
        }
        System.out.println();
        if(root.children.size()==0){
            return;
        }
        for(Node child: root.children){
            preOrderTraversal(child);
        }
        return;
    }

    public static void postOrderTraversal(Node root){
        if(root.children.size()==0){
            System.out.println(root.data);
            return;
        }
        for(Node child: root.children){
            postOrderTraversal(child);
        }
        System.out.println(root.data);
        return;
    }

    public static void serialize(Node root,  ArrayList<Integer> list){
        if(root.children.size()==0){
            list.add(root.data);
            return;
        }
        list.add(root.data);
        for(Node child: root.children){
            serialize(child, list);
            list.add(-1);
        }
    }

    public static void Mirror(Node root){
        if(root.children.size()==0)
            return;
        for(Node child: root.children){
            Mirror(child);
        }
        for(int i=0, j=root.children.size()-1; j>i; i++,j--){
            Node temp = root.children.get(i);
            root.children.set(i, root.children.get(j));
            root.children.set(j, temp);
        } 
        // Collections.reverse(root.children);
    }

    public static boolean areTreeSimilar(Node root1 , Node root2){
        if(root1.children.size()!=root2.children.size()){
            System.out.println("ansTest "+false);
            return false;
        }
        for(int i=0;i<root1.children.size();i++){
            Node child1 = root1.children.get(i);
            Node child2 = root2.children.get(i);

            if(areTreeSimilar(child1, child2)==false)
                return false;
        }
        return true;
    }
   
    public static boolean areTreeMirrorSimilar(Node root1 , Node root2){
        if(root1.children.size()!=root2.children.size()){
            // System.out.println("ansTest "+false);
            return false;
        }
        for(int i=0, j=root1.children.size()-1; i<root1.children.size(); i++, j--){
            Node child1 = root1.children.get(i);
            Node child2 = root2.children.get(j);
            if(areTreeSimilar(child1, child2)==false)
                return false;
        }
        return true;
    }
    
    public static boolean isTreeSymmetric(Node rootL, Node rootR){
        if(rootL.children.size()!= rootR.children.size())
            return false;
        for(int i=0, j=rootL.children.size()-1; i<rootR.children.size(); i++, j--){
            Node child1 = rootL.children.get(i);
            Node child2 = rootR.children.get(j);
            if(isTreeSymmetric(child1, child2)==false)
                return false;
        }
        return true;
    }

    public static Node  predSuc(Node root , Node pred, Node suc, int val, int index){
        if(index==1){
            return root;
        }
        pred = root;
        for(Node child: root.children){
            boolean visited = false;
            if(root.data==val){
                visited=true;
            }
            if(visited==false)
                predSuc(child, pred, suc, val,0);
            else{
                suc = predSuc(child, pred, suc, val, 1);
                System.out.println(suc.data);
                break;
            }
        }
        System.out.println(pred.data);
        return root;
    }

    public static class heapMover{
        int max= Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int height = 0;
    }
    public static void multiSolver(Node root, int depth , heapMover mover){
        if(root.data>mover.max)
            mover.max = root.data;
        if(root.data<mover.min)
            mover.min = root.data;
        if(depth>mover.height)
            mover.height = depth;
        for(Node child: root.children){
            multiSolver(child, depth+1, mover);
        }
    } 

    public static class ceilFloor{
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;
    }
    public static void ceilFloorSoln(Node root, int val, ceilFloor c){
        if(root.data>val && root.data<c.ceil){
            c.ceil = root.data;
        }
        if(root.data<val && root.data>c.floor){
            c.floor = root.data;
        }
        for(Node child: root.children){
            ceilFloorSoln(child, val, c);
        }
    }

    public static int kthLargest(Node root, int k){
        
        int kthLargest = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ceilFloor c = new ceilFloor();
            ceilFloorSoln(root, kthLargest, c);
            kthLargest = c.floor;
        }
        return kthLargest;
    }

    public static void mirror(Node node){
        Node root = node;
        // write your code here
        System.out.print(node.data+" -> ");
        for(Node child: node.children){
            System.out.print(child.data+", ");
        }
        System.out.println(".");
        for(Node child: node.children){
            mirror(child);
        }
        Collections.reverse(node.children);
        // for(int i=0, j=root.children.size()-1; j>i; i++,j--){
        //     Node temp = root.children.get(i);
        //     root.children.set(i, root.children.get(j));
        //     root.children.set(j, temp);
        // }
        for(Node child: node.children){
            mirror(child);
        }
    }

    public static void removeLeaves(Node node) {

        int index=0;
        for(int i=index;i<node.children.size();i++){
            if(node.children.get(i).children.size()==0){
                node.children.remove(i);
                i--;
            }else{
                removeLeaves(node.children.get(i));
                index++;
            }
        }
    }

    public static class pair{
        int state;
        Node node;
    }
    public static void traversal(Node root){
        String preorder="";
        String postorder="";
        Stack<pair> s = new Stack<>();
        pair p = new pair();
        p.state = -1;
        p.node = root;
        s.push(p);
        while(s.size()!=0){
            if(s.peek().state==-1){
                preorder+=s.peek().node.data+" ";
                s.peek().state++;
            }else if(s.peek().state>=0 && s.peek().node.children.size()>s.peek().state){
                pair newPair = new pair();
                newPair.node = s.peek().node.children.get(s.peek().state);
                newPair.state=-1;
                s.peek().state++;
                s.push(newPair);
            }else if(s.peek().state == s.peek().node.children.size()){
                postorder+= s.peek().node.data+" ";
                s.peek().state++;
            }else{
                s.pop();
            }
        }
        System.out.println(preorder);
        System.out.println(postorder);
    }

    public static class preSucState{
        Node pred;
        Node suc;
        int state;
    }
    public static void predecisorSuccessor(Node root,int val, preSucState p){
        if(p.state>1){
            return;
        }
        if(p.state==1){
            p.suc=root;
            p.state=2;
        }
        if(root.data==val){
            p.state=1;
        }

        for(Node child: root.children){
            if(p.state==0)
                p.pred = root;
            predecisorSuccessor(child, val,p);
        }
    }

    public static class sumObj{
        int sum=Integer.MIN_VALUE;
        Node node;
    }
    public static void maxSumNode(Node root, sumObj s){
        int curSum=0;
        for(Node child: root.children){
            maxSumNode(child, s);
            curSum+=child.data;
        }
        curSum+=root.data;
        System.out.println(root.data+" "+ curSum);
        if(s.sum<curSum){
            s.node = root;
            s.sum = curSum;
        }
    }

    static class diameterObject{
        int max;
        int sexMax;
        ArrayList<Integer> al = new ArrayList<>();
    }
    public static int  diameter(Node root, diameterObject obj){
        int curL = 0;
        for(Node child: root.children){
            curL= Math.max(curL, diameter(child, obj));
        }
        obj.al.add(curL+1);
        return curL+1;
    }

    static class diameterObject2{
        int max=0;
        int secMax=0;
    }
    public static int diameter(Node root , diameterObject2 obj){

        int len = 0;
        for(Node child: root.children){
            len = Math.max(len, diameter(child, obj));
        }
        if(obj.max<len+1){
            obj.max = len+1;
        }else if(obj.secMax<len+1){
            obj.secMax = len+1;
        }
        return 1+len;

    }

    static boolean visited= false;
    public static void nodeToRootPathRecursive(Node root , int data){

        if(root.data==data){
            System.out.println(root.data);
            visited = true;
        }
        boolean visitedPre = false;
        for(Node child: root.children){
            if(visited==false)
                nodeToRootPathRecursive(child, data);
            if(visitedPre!=visited){
                System.out.println(root.data);
                return;
            }

        }
    }

    static class traverse{
        int size;
        Node node;
    }
    public static ArrayList<Integer> nodeToRootPath(Node root, int data){
        // write your code here
        ArrayList<Integer> al = new ArrayList<>();
        Stack<traverse> stack = new Stack<>();
        traverse obj = new traverse();
        obj.size = 0;
        obj.node = root;
        stack.add(obj);
        boolean visited = false;
        while(stack.size()!=0){
            traverse peek = stack.peek();
            if(visited==true){
                al.add(peek.node.data);
                stack.pop();
            }else{
                if(peek.node.data==data){
                    al.add(peek.node.data);
                    stack.pop();
                    visited = true;
                }else{
                    if(peek.node.children.size()==0){
                        stack.pop();
                    }else if(peek.node.children.size()>0 && peek.size<peek.node.children.size()){
                        traverse newPair = new traverse();
                        newPair.node = peek.node.children.get(peek.size);
                        newPair.size=0;
                        peek.size++;
                        stack.push(newPair);

                    }else {
                        stack.pop();
                    }
                }
            }
        }
        return al;
     }

    public static boolean find(Node node, int data) {
    // write your code here
    if(node.data==data)
      return true;
    boolean ans = false;
    for(Node child: node.children){
      if(ans==false)
        ans = find(node , data);
    }
    return ans;
  }

  public static class pair2{
    boolean firstVisit;
    Node ancestor;
    boolean data1;
    boolean data2;
  }
  public static int lca2(Node node, int d1, int d2, pair2 p) {

    // write your code here
    if(p.data1==true && p.data2==true)
        p.firstVisit= true;
    if(p.firstVisit==true)
        return p.ancestor.data;
    if(d1==node.data)
      p.data1 = true;
    if(d2==node.data) 
      p.data2 = true;

    for(Node child: node.children){
        if(p.firstVisit==false){
            lca2(child,d1,d2,p);
            if(p.data1==false || p.data2==false)
                p.ancestor = node;
        }
    }
    return p.ancestor.data;
  }

  public static class ceilFloorPair2{
      int ceil = Integer.MAX_VALUE;
      int floor = Integer.MIN_VALUE;
  }
  public static void ceilFloor2(Node root, int val, ceilFloorPair2 cp){     
    
    if(root.data>val && root.data<cp.ceil){
        cp.ceil = root.data;
    }
    if(root.data<val &&  root.data>cp.floor){
        // System.out.println("cp "+ cp.ceil);
        cp.floor = root.data;
    }
    for(Node child: root.children){
        ceilFloor2(child, val, cp);
    }
  }

  public static int kthLargest2(Node root , int k){
    int kthLargest = Integer.MAX_VALUE;
    for(int i=0;i<k;i++){
        ceilFloorPair2 cp = new ceilFloorPair2();
        ceilFloor2(root, kthLargest, cp);
        kthLargest = cp.floor;
    }
    return kthLargest;
  }


  public static class mst{
    int sum=Integer.MIN_VALUE;
    Node node;
  }
  public static int maxSubTree(Node root, mst s){
        int sum = 0;
        for(Node child: root.children){
            sum+=maxSubTree(child,s);
        }
        sum+=root.data;
        if(s.sum<sum){
            s.sum = sum;
            s.node = root;
        }
        return sum;
  }

  public static class pair3{
    boolean firstTime=true;
    boolean visited1;
    boolean visited2;
    Node lowest;
  }
  public static void lac(Node node, int d1, int d2, pair3 p){

        for(Node child: node.children){
            lac(child, d1, d2, p);
        }
        pair3 pSend = new pair3();
        boolean ans = contains(node, d1, d2, pSend);
        if(ans==true && p.firstTime){
            // System.out.println(node.data);
            p.lowest = node;
            p.firstTime = false;
        }

  }
  public static boolean contains(Node node, int d1, int d2, pair3 p){
        if(node.data==d1)
            p.visited1 = true;
        if(node.data==d2)
            p.visited2 = true;
        if(p.visited1 && p.visited2)
            return true;
        boolean ans=false;
        for(Node child: node.children){
            ans = contains(child, d1, d2, p);
        }
        return ans;
  }



    public static void main(String[] args) {
        // int arr[] = {10,20,40,-1,50,-1,-1,30,60,-1,70,80,-1,90,-1,-1,-1,-1};
        int arr[] = {10,-20,50,-1,-60,-1,-1,30,70,-1,80,110,-1,-120,-1,-1,-90,-1,-1,-40,-100,-1,-1,-1};
        // int arr[] = {10 ,20 ,50 ,-1, 60 ,-1 ,-1, 30 ,70 ,-1, 80 ,110 ,-1, 120, -1 ,-1, 90 -1 ,-1 ,40 ,100 ,-1 ,-1 ,-1};
        // int arr[] = {10, 20 ,50, -1, 60 ,-1 ,-1 ,30, 70, -1 ,80 ,110 ,-1, 120 ,-1 ,-1 ,90 ,-1 ,-1 ,40 ,100 ,-1 ,-1 ,-1};
        // int arr[] = {10,20,-1,40,-1,-1};
        // int arr2[] = {10,20,-1,40,-1,-1};
        Node root = construct(arr);
        pair3 p = new pair3();
        // lac(root, 70, 110, p);
        lac(root, 50, 110, p);
        System.out.println(p.lowest.data);




    }
}
