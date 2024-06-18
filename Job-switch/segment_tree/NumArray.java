public class NumArray {

    int seg[];
    int arr[];

    public NumArray(int[] arr) {

        int n = arr.length;
        seg = new int[2 * n - 1];
        this.arr = arr;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] += (arr[i] + prefixSum[i - 1]);
        }
        fillSegments(seg, 0, 0, n - 1, prefixSum);
    }

    public static void fillSegments(int[] segments, int idx, int low, int high, int[] prefixSum) {
        if (low > high || idx >= segments.length)
            return;

        int currSum = prefixSum[high] - (low - 1 >= 0 ? prefixSum[low - 1] : 0);
        segments[idx] = currSum;

        fillSegments(segments, (2 * idx) + 1, low, (low + high) / 2, prefixSum);
        fillSegments(segments, (2 * idx) + 2, (low + high) / 2 + 1, high, prefixSum);
    }

    public void update(int idx, int val) {
        int change = val - arr[idx];
        updateHelper(seg, 0, 0, arr.length - 1, change, idx);

    }

    public static void updateHelper(int[] segments, int idx, int low, int high, int change, int arr_idx) {
        if (low > high || idx >= segments.length)
            return;

        segments[idx] += change;
        int mid = (low + high) / 2;
        if (arr_idx <= mid) { // left
            updateHelper(segments, 2 * idx + 1, low, mid, change, arr_idx);
        } else {
            updateHelper(segments, 2 * idx + 2, mid + 1, high, change, arr_idx);
        }
    }

    // public int sumRange(int left, int right) {
    //     return sumRangeHelper(left, right, 0, arr.length - 1, 0);
    // }

    // public int sumRangeHelper(int left, int right, int low, int high, int idx) {
    //     if (low > high)
    //         return 0;
    //     if (left <= low && high <= right) {
    //         return seg[idx];
    //     }

    //     int sum = 0;
    //     int mid = (low + high) >> 1;

    //     if (left > mid) {
    //         // right
    //         sum += sumRangeHelper(left, right, mid + 1, high, 2 * idx + 2);
    //     } else if (mid > right) {
    //         // go left
    //         sum += sumRangeHelper(left, right, low, mid, 2 * idx + 1);
    //     } else {
    //         sum += sumRangeHelper(left, right, mid + 1, high, 2 * idx + 2)
    //                 + sumRangeHelper(left, right, low, mid, 2 * idx + 1);
    //     }
    //     return sum;
    // }

    public int sumRange(int left, int right) {
        int n = arr.length;
        return getSumRange(0, left, right, 0, n-1);
    }

    private int getSumRange(int idx, int left, int right, int treeStart, int treeEnd) {
        if(left>treeEnd || right<treeStart) {
            return 0;
        } else if(left<=treeStart && right>=treeEnd) {
            return seg[idx];
        } else {
            int mid = treeStart + (treeEnd - treeStart)/2;
            return getSumRange(2*idx+1, left, right, treeStart, mid) + getSumRange(2*idx+2, left, right, mid+1, treeEnd);
        }
    }
}
