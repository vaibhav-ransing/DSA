// import java.util.NoSuchElementException;
// import java.util.Stack;
// public class bst{

//     static class Node{
//         int data;
//         Node left;
//         Node right;
//         Node(int data, Node l, Node r){
//             this.data = data;
//             this.left = l;
//             this.right = r;
//         }
//     }
//     static class Pair{
//         Node node;
//         int state;
//         Pair(Node n, int s){
//             this.node = n;
//             this.state = s;
//         }
//     }
//     // public static Node constructor(Integer arr[]){
//     //         Node node = new Node();
//     //         node.data = arr[0];
//     //         Stack<pair> stack = new Stack<>();
//     //         pair rp = new pair();
//     //         rp.node = node;
//     //         stack.push(rp);
//     //         int index = 1;
//     //         while(stack.size()>0 && index<arr.length){
//     //             pair peek = stack.peek();
//     //             if(arr[index]==null){
//     //                 peek.state++;
//     //                 index++;
//     //             }else{
//     //                 if(peek.state==1){
//     //                     Node leftChild = new Node();
//     //                     leftChild.data = arr[index];
//     //                     peek.node.left = leftChild;
//     //                     pair newPair = new pair();
//     //                     newPair.node = leftChild;
//     //                     index++;
//     //                     peek.state++;
//     //                     stack.push(newPair);
//     //                 }else if(peek.state==2){
//     //                     Node rightChild = new Node();
//     //                     rightChild.data = arr[index];
//     //                     peek.node.right = rightChild;
//     //                     pair newPair = new pair();
//     //                     newPair.node = rightChild;
//     //                     index++;
//     //                     peek.state++;
//     //                     stack.push(newPair);
//     //                 }else{
//     //                     stack.pop();
//     //                 }
//     //             }
//     //         }
//     //         return node;
//     //     }
//     public static Node construct(Integer[] arr) {
//         Node root = new Node(arr[0], null, null);
//         Pair rtp = new Pair(root, 1);
    
//         Stack<Pair> st = new Stack<>();
//         st.push(rtp);
    
//         int idx = 0;
//         while (st.size() > 0) {
//           Pair top = st.peek();
//           if (top.state == 1) {
//             idx++;
//             if (arr[idx] != null) {
//               top.node.left = new Node(arr[idx], null, null);
//               Pair lp = new Pair(top.node.left, 1);
//               st.push(lp);
//             } else {
//               top.node.left = null;
//             }
    
//             top.state++;
//           } else if (top.state == 2) {
//             idx++;
//             if (arr[idx] != null) {
//               top.node.right = new Node(arr[idx], null, null);
//               Pair rp = new Pair(top.node.right, 1);
//               st.push(rp);
//             } else {
//               top.node.right = null;
//             }
    
//             top.state++;
//           } else {
//             st.pop();
//           }
//         }
    
//         return root;
//       }

//     public static void display(Node root){

//         System.out.println(root.data);
//         if(root.left!=null)
//             display(root.left);
//         if(root.right!=null)
//             display(root.right);
//         // return;
//     }

//     public static void display2(Node node){
//         if(node == null){
//             return;
//         }

//         String str = " <- " + node.data + " -> ";
//         String lcstr = node.left == null? ".": node.left.data + "";
//         String rcstr = node.right == null? ".": node.right.data + "";
//         System.out.println(lcstr + str + rcstr);

//         display2(node.left); // will print the entire left tree
//         display2(node.right); // will print the entire right tree
//     }

//     public static Node leftClone(Node node){
//         if(node==null)
//             return null;
//         Node temp = node.left;
//         Node clone = new Node(node.data, null,null);
//         clone.data = node.data;
//         node.left = clone;
//         clone.left = temp;
//         leftClone(clone.left);
//         leftClone(node.right);
//         return node;
//     }

//     public static Node removeClone(Node node){



//         return node;
//     }

//     // whats wrong in this?
//     public static void printSingleChild(Node node, int parentChildren){
//         if(node==null)
//             return;
//         int var = 0;
//         if(node.left!=null)
//             var++;
//         if(node.right!=null)
//             var++;
//         System.out.println("Node "+ node.data+" parent children "+ parentChildren);
        
//         printSingleChild(node.left, var);
//         printSingleChild(node.right, var);
        
//         if(parentChildren==1){
//             System.out.println(node.data);
//         }
//     }

//     public static void printPath(Node node, int currSum , int sLimit, int Maxlimit, String path){
//         if(node==null)
//             return;
//         if(node.left!=null){
//                 printPath(node.left, currSum+node.data, sLimit, Maxlimit, path+node.data+" ");
//         }
//         if(node.right!=null){
//                 printPath(node.right, currSum+node.data, sLimit, Maxlimit, path+node.data+" ");
//         }
//         if(node.left==null && node.right==null){
//             if(currSum<Maxlimit && currSum>sLimit){
//                 path+=node.data;
//                 System.out.println(path);
//             }
//         }

//     }
    
//     public static class pair{
//         int state=0;
//         Node node;
//     }
//     public static void traversalIterative(Node node){
//         String preorder="";
//         String postorder="";
//         String inorder="";
//         pair p = new pair();
//         p.node = node;
//         Stack<pair> stack = new Stack<>();
//         stack.push(p);
//         while(stack.size()>0){
//             pair peek = stack.peek();
//             if(peek.state==0){
//                 preorder+=peek.node.data+" ";
//                 System.out.print("pre "+peek.node.data+" ");
//                 if(peek.node.left!=null){
//                     pair np = new pair();
//                     np.node = peek.node.left;
//                     stack.push(np);
//                 }
//                 peek.state++;
//             }else if(peek.state==1){
//                 System.out.print("inorder "+peek.node.data+" ");
//                 inorder+=peek.node.data+" ";
//                 if(peek.node.right!=null){
//                     pair np = new pair();
//                     np.node = peek.node.right;
//                     stack.push(np);
//                 }
//                 peek.state++;
//             }else if(peek.state==2){
//                 System.out.print("post "+peek.node.data+" ");
//                 postorder+=peek.node.data+" ";
//                 stack.pop();
//             }
//         }
//         System.out.println(preorder);
//         System.out.println(inorder);
//         System.out.println(postorder);
//     }


//     public static void main(String[] args) {
//                     // 50 25 12 n n           37 30  n n n          75 62 n     70 n n        87 n n
//         // Integer arr[] = {50,25,12,null, null, 37,30, null,null,null,75,62,null, 70,null,null, 87,null,null}; 
//         Integer arr[] = {50,null, null}; 
//         // Integer arr[] = {20, 10, null, null, 30,null ,null}; 
//         Node root = construct(arr);
//         // display(root);
//         // printSingleChild(root, 0);
//         pair p =new pair();
//         p.node = root;
//         // traversalIterative(root);
        
//     }
// }