class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        long low = 1, high = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (check(nums, threshold, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) high;
    }

    public boolean check(int[] nums, int threshold, long mid) {
        int count = 0;
        for (int val : nums) {
            count += Math.ceilDiv(val, mid);
        }
        return count <= threshold;
    }

}