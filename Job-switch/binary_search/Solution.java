class Solution {
    public int findPeakElement(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int n = nums.length;
        int index = 0;

        if (n == 3) {
            for (int i = 0; i < n - 1; i += 2) {

                int prev = max1;
                // prev=0
                // [1,2,3] 2
                max1 = Math.max(max1, Math.max(nums[i], nums[i + 1]));
                // max1=2
                if (prev != max1) {
                    prev = max1;
                    if (nums[i] > nums[i + 1])
                        index = i;
                    else
                        index = i + 1;
                }
            }
        }
        else {
            for (int i = 0; i < n - 1; i += 2) {

                int prev = max1;
                // prev=0
                // [1,2,3] 2
                max1 = Math.max(max1, Math.max(nums[i], nums[i + 1]));
                // max1=2
                if (prev != max1) {
                    prev = max1;
                    if (nums[i] > nums[i + 1])
                        index = i;
                    else
                        index = i + 1;
                }
            }
        }
        return index;
    }
}