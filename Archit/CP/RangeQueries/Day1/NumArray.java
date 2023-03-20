package CP.RangeQueries.Day1;


class Node{
    int sum, low, high;
    Node left,right;
    Node(int sum, int low, int high){
        this.sum = sum;
        this.low = low;
        this.high = high;
    }
}
class Tree{

    Node build(int low, int high, int[] nums){
        if(low>high) return new Node(0, low, high);
        if(low==high) return new Node(nums[low], low, high);
        Node root = new Node(0, low, high);
        int mid = (low+high)/2;
        root.left =  build(low, mid, nums);
        root.right =  build(mid+1, high, nums);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    Node update(Node root, int idx, int val){
        if(root.low==root.high){
            root.sum = val;
            return root;
        }
        int mid = (root.low+root.high)/2;
        if(idx<=mid){
            update(root.left, idx, val);
        }else{
            update(root.right, idx, val);
        }
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    int getSum(Node root, int low, int high){
        if(root.high<low || root.low>high) return 0;
        if(root.high<=high && root.low>=low) return root.sum;

        int l = getSum(root.left, low, high);
        int r = getSum(root.right, low, high);

        return l+r;
    }
}
class NumArray {
    Node root;
    Tree tree = new Tree();
    public NumArray(int[] nums) {
        root = new Node(0, 0, nums.length-1);
        root = tree.build(0, nums.length-1, nums);
    }
    
    public void update(int index, int val) {
        root = tree.update(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return tree.getSum(root, left, right);
    }
}

 

// class Node{
//     int sum, low, high;
//     Node left,right;
//     Node(int sum, int low, int high){
//         this.sum = sum;
//         this.low = low;
//         this.high = high;
//     }
// }
// class Tree{

//     Node build(int low, int high, int[] nums){
//         if(low>high) return new Node(0, low, high);
//         if(low==high) return new Node(nums[low], low, high);
//         Node root = new Node(0, low, high);
//         int mid = (low+high)/2;
//         root.left =  build(low, mid, nums);
//         root.right =  build(mid+1, high, nums);
//         root.sum = root.left.sum + root.right.sum;
//         return root;
//     }

//     Node update(Node root, int idx, int val){
//         if(root.low==root.high){
//             root.sum = val;
//             return root;
//         }
//         int mid = (root.low+root.high)/2;
//         if(idx<=mid){
//             update(root.left, idx, val);
//         }else{
//             update(root.right, idx, val);
//         }
//         root.sum = root.left.sum + root.right.sum;
//         return root;
//     }
//     int getSum(Node root, int low, int high){
//         if(root.high<low || root.low>high) return 0;
//         if(root.high<=high && root.low>=low) return root.sum;

//         int l = getSum(root.left, low, high);
//         int r = getSum(root.right, low, high);

//         return l+r;
//     }
// }


// class NumArray {
//     Node root;
//     Tree tree = new Tree();
//     public NumArray(int[] nums) {
//         root = new Node(0, 0, nums.length-1);
//         root = tree.build(0, nums.length-1, nums);
//     }
    
//     public void update(int index, int val) {
//         root = tree.update(root, index, val);
//     }
    
//     public int sumRange(int left, int right) {
//         return tree.getSum(root, left, right);
//     }
// }