
public class PartitionArrayDisjointInterval {
    
    // O(N) Space
    public static int partitionDisjoint(int[] arr) {
        int n = arr.length;
        int[] rightMinArr = new int[n];
        rightMinArr[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            rightMinArr[i] = Math.min(arr[i], rightMinArr[i+1]);
        }
        for(int val: rightMinArr){
            System.out.print(val+" ");
        }
        int max = Integer.MIN_VALUE;
        int ans = 1;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
            if(rightMinArr[i+1] > max){
                return i+1;
            }
        }
        return ans;
    }
    
    // O(1) Space 
    public static int partitionDisjoint2(int[] arr) {
        int leftMax = arr[0];
        int greater = arr[0];
        int ans = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > greater){
                greater = arr[i];
            }else if( leftMax > arr[i]){
                leftMax = greater;
                ans = i;
            }
        }
        return ans+1;
    }
    
    public static void main(String[] args) {
        int[] arr = {6,0,8,30,37,6,75,98,39,90,63,74,52,92,64};
        partitionDisjoint(arr);
    }
}
