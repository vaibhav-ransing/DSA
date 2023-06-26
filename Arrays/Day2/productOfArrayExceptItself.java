package Arrays.Day2;


public class productOfArrayExceptItself {

    public int[] productExceptSelf(int[] arr) {
        int[] right = new int[arr.length];
        int prod = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            prod *= arr[i];
            right[i] = prod;
        }
        int[] res = new int[arr.length];
        prod = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            int rp = right[i + 1];
            res[i] = rp * prod;
            prod *= arr[i];
        }
        res[arr.length-1] = prod;
        return res;
    }

    public int[] productExceptSelf23(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];
        int prod = 1;
        for(int i=n-1; i>=0; i--){
            prod *= arr[i];
            right[i] = prod;
        }

        int[] res = new int[n];
        prod=1;
        for(int i=0; i<n-1; i++){
            int rp = right[i+1];
            int lp = prod;
            res[i] = lp*rp;
            prod *= arr[i];
        }
        res[n-1] = prod;
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int prod = 1;
        boolean hasZero = false;
        boolean allZero = true;
        for (int val : nums) {
            prod *= val == 0 ? 1 : val;
            if (val == 0)
                hasZero = true;
            if (val != 0)
                allZero = false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && hasZero) {
                nums[i] = 0;
            } else if (nums[i] != 0 && !hasZero) {
                nums[i] = prod / nums[i];
            } else {
                nums[i] = allZero ? 0 : prod;
            }
        }
        return nums;
    }
}
