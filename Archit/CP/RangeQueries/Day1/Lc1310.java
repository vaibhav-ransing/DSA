package CP.RangeQueries.Day1;

public class Lc1310 {
    
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
            root.sum = (root.left.sum ^ root.right.sum);
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
    public int[] xorQueries(int[] arr, int[][] queries) {
        Tree tree = new Tree();
        Node root = new Node(0, 0, arr.length-1);
        int ans[] = new int[queries.length];
        root = tree.build(0, arr.length-1, arr);
        int i=0;
        for(int [] cods: queries){
            ans[i++] = tree.getSum(root, cods[0], cods[1]);
        }
        return ans;
    }
}
