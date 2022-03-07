import java.util.Stack;

public class Main{

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node construct(int arr[], int low, int high){
        if(low>high){
            return null;
        }
        int mid = (low+high)/2;
        Node curr = new Node(arr[mid]);
        curr.left = construct(arr, low, mid-1);
        curr.right = construct(arr, mid+1, high);
        return curr;
    }
    static void display(Node node){
        if(node==null)
            return;
        display(node.right);
        System.out.println(node.data);
        display(node.left);
        // display(node.left);
        // System.out.println(node.data);
        // display(node.right);
    }

    public static int changeTree(Node node, int sum){
        if(node==null)
            return 0;
        int nodeVal = node.data;
        int rv = changeTree(node.right, sum);
        node.data = sum+rv;
        sum+=nodeVal+rv;
        System.out.println("node "+nodeVal+ " sum "+" "+sum);
        int leftVal = changeTree(node.left, sum);
        
        return Math.max(leftVal, sum);
    }   

    public static boolean find(Node node ,int data){
        if(node==null)
            return false;
        if(node.data==data)
            return true;
        boolean ans = false;
        if(data>node.data){
            ans = find(node.right, data);
        }else{
            ans = find(node.left, data);
        }
        return ans;
    }
    public static void targetSumPair(Node root,Node node,  int data){
        if(node==null)
            return;

        int val = data-node.data;
        targetSumPair(root, node.left, data);

        if(val> node.data){
            if(find(root, val) && val!=node.data){
                if(val<node.data)
                    System.out.println(val +" "+node.data );
                else
                    System.out.println(node.data +" "+val );
            }
        }

        targetSumPair(root, node.right, data);
    }
    
    public static void findPair(Node node , int sum, int t, String ans){
        if(node==null || sum<0 || (t==2 && sum!=0))
            return;
        if(t==2 && sum==0){
            System.out.println(ans);
            return;
        }
        findPair(node, sum-node.data, t+1, ans+node.data+" ");
        findPair(node.left, sum, t, ans);
        findPair(node.right, sum, t, ans);
    }
    
    static boolean visited1 = false;
    static boolean visited2 = false;
    static boolean lowest = true;
    static int ans = 0;
    public static void LCA(Node node , int d1, int d2){
        if(node==null)
            return;
        if(node.data==d1)
            visited1 = true;
        if(node.data==d2)
            visited2 = true;
        if(visited1 && visited2 )
            return;
        LCA(node.left, d1, d2);
        LCA(node.right, d1, d2);
        if(visited1 & visited2 & lowest){
            ans= node.data;
            lowest=false;
        }
    }

    public static void printInRange(Node node , int d1, int d2){
        if(node==null)
            return;
        
        if(d1< node.data && node.data <d2){
            System.out.println(node.data);
            printInRange(node.left, d1, d2);
            printInRange(node.right, d1, d2);
        }else if(node.data<d1 && node.data<d2){
            printInRange(node.left, d1, d2);
        }else{
            printInRange(node.right, d1, d2);
        }
    }

    static int max = 0;
    static boolean updated = false;
    public static Node getAndRemove_Max(Node node){
        if(node==null)
            return null;
        node.right =  getAndRemove_Max(node.right);
        if(updated==false){
            max = node.data;
            updated = true;
            if(node.left!=null){
                return node.left;
            }else  return null;
        }
        else{
            return node;
        }
    }
    public static Node remove(Node node,  int data){
        if(node==null)
            return null;
        if(node.data == data){
            if(node.left==null && node.right==null){
                return null;
            }else if(node.left==null){
                return node.right;
            }else if(node.right==null){
                return node.left;
            }else{
                node.left = getAndRemove_Max(node.left);
                node.data = max;
                return node;
            }
        }
        else if(node.data>data){
            node.left = remove(node.left, data);
        }else{
            node.right = remove(node.right, data);
        }
        return node;
    }

    public static int max(Node node){
        if(node==null)
            return Integer.MIN_VALUE;
        int max = node.data;
        return Math.max(max(node.right), max);
    }
    public static Node remove2(Node node, int data){
        if(node==null){
            return null;
        }        
        if(node.data> data){
            node.left = remove2(node.left, data);
        }else if(node.data<data){
            node.right = remove2(node.right, data);
        }else{
            if(node.left==null && node.right==null) {
                return null;
            }else if(node.right==null){
                return node.left;
            }else if(node.left==null){
                return node.right;
            }else{
                int max = max(node.left);
                node.data = max;
                return remove(node.left, max);
            }
        }
        return node;
    }


    

    public static void printIterative(Node node){
        Stack<pair> list = new Stack<>();
        pair p = new pair(node);
        String pre="";
        String inorder = "";
        String post = "";
        list.push(p);

        while(list.size()>0){
            pair peek = list.peek();
            if(peek.state==0){
                pre+=peek.node.data+" ";
                peek.state++;
                if(peek.node.left!=null){
                    pair newPair = new pair(node.left);
                    list.push(newPair);
                }
            }else if(peek.state==1){
                inorder+=peek.node.data+" ";
                peek.state++;
                if(peek.node.right!=null){
                    pair newPair = new pair(node.right);
                    list.push(newPair);
                }
            }else{
                post+=peek.node.data+" ";
                list.pop();
            }
        }
        System.out.println(pre);
        System.out.println(inorder);
        System.out.println(post);
    }
   

    static int size(Node node){
        if(node==null)
            return 0;
        return 1+ size(node.left) + size(node.right);
    }
    static class pair{
        Node node;
        int state = 0;
        pair(Node node){
            this.node = node;
        }
    }
    public static void findPair(Node node , int data){
        System.out.println("klasdjf;klasdf");
        Stack<pair> stackLeft = new Stack<>();
        pair pLeft = new pair(node);
        stackLeft.push(pLeft);

        Stack<pair> stackRight = new Stack<>();
        pair pRight = new pair(node.right);
        stackRight.push(pRight);
        System.out.println("askldjtklasf");
        while(stackLeft.peek().node.data < stackRight.peek().node.data){
            pair topLeft = stackLeft.peek();
            pair topRight = stackRight.peek();
            if(topLeft.node.data + topRight.node.data > data){
                if(topLeft.state==0){
                    topLeft.state++;
                    if(topLeft.node.left!=null){
                        pair newP = new pair(node.left);
                        stackLeft.push(newP);
                    }
                }else if(topLeft.state==1){
                    topLeft.state++;
                    if(topLeft.node.right!=null){
                        pair newP = new pair(node.right);
                        stackLeft.push(newP);
                    }
                }else{
                    stackLeft.pop();
                }
            }else if(topLeft.node.data + topRight.node.data < data){
                if(topRight.state==0){
                    topRight.state++;
                    if(topRight.node.right!=null){
                        pair newP = new pair(node.right);
                        stackRight.push(newP);
                    }
                }else if(topRight.state==1){
                    topRight.state++;
                    if(topRight.node.left!=null){
                        pair newP = new pair(node.left);
                        stackRight.push(newP);
                    }
                }else{
                    stackRight.pop();
                }
            }else{
                System.out.println(topLeft.node.data +" "+ topRight.node.data);
                // leftStack processed
                if(topLeft.state==0){
                    topLeft.state++;
                    if(topLeft.node.left!=null){
                        pair newP = new pair(node.left);
                        stackLeft.push(newP);
                    }
                }else if(topLeft.state==1){
                    topLeft.state++;
                    if(topLeft.node.right!=null){
                        pair newP = new pair(node.right);
                        stackLeft.push(newP);
                    }
                }else{
                    stackLeft.pop();
                }
                // rightStack processed
                if(topRight.state==0){
                    topRight.state++;
                    if(topRight.node.right!=null){
                        pair newP = new pair(node.right);
                        stackRight.push(newP);
                    }
                }else if(topRight.state==1){
                    topRight.state++;
                    if(topRight.node.left!=null){
                        pair newP = new pair(node.left);
                        stackRight.push(newP);
                    }
                }else{
                    stackRight.pop();
                }
            }
        }
    }

    // public static void findPair2(Node root , int data){
    //     Stack<pair> leftStack = new Stack<>();
    //     pair leftP = new pair(root);
    //     leftStack.push(leftP);

    //     Stack<pair> rightStack = new Stack<>();
    //     pair rightP = new pair(root);
    //     rightStack.push(rightP);

    //     // Node left = getInorder(leftStack);
    //     // Node right = getReverseInorder(rightStack);

    //     while(left.data < right.data){
    //         if(left.data + right.data <data){

    //         }else if(left.data + right.data > data){

    //         }else{

    //         }
    //     }

    // }
    // public static Node getInorder(Stack<pair> stack){
    //     pair top = stack.peek();
    //     if(top.state==0){
    //         top.state++;
    //         if(top.node.left!=null){
    //             pair lp = new pair(top.node.left);
    //             stack.push(lp);
    //         }
    //     }else if(top.state==1){
    //         top.state++;
    //         if(top.node.right!=null){
    //             pair rp = new pair(top.node.right);
    //             stack.push(lp);
    //         }
    //     }else{
    //         stack.pop();
    //     }
    // }
    // public static Node getReverseInorder(Stack<pair> stack){

    // }


    public static void main(String[] args) {
        int arr[] = {10,20,40,50,60,70,80};
        // int arr[] = {12,25,30,37,50,60,62,70,75,87};
        Node root = construct(arr, 0, arr.length-1);
        // changeTree(root, 0);
        findPair(root, 60);
    }
}