public class GoogleQuestion {


    public boolean solution(int[] arr, int[][] queries){
        SegmentTree sg = new SegmentTree(arr);
        for(int[] q : queries){
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        
    }

    static class SegmentTree {

        int[] segments;
        int[] arr;

        SegmentTree(int[] arr) {
            int n = arr.length;
            this.arr = arr;
            segments = new int[4 * n];

            for (int i = 0; i < n; i++) {
                update(0, 0, n - 1, arr[i], i);
            }
        }

        public void update(int idx, int val) {
            int change = val - arr[idx];
            this.arr[idx] = val;
            update(0, 0, arr.length - 1, change, idx);
        }

        // 0, 0, n-1, 3, 0
        public void update(int idx, int low, int high, int change, int arr_idx) {
            if (arr_idx < low || arr_idx > high)
                return;

            segments[idx] += change;

            if (low == high)
                return;

            int mid = (low + high) / 2;
            update(2 * idx + 1, low, mid, change, arr_idx);
            update(2 * idx + 2, mid + 1, high, change, arr_idx);
        }

        public int sumRange(int left, int right) {
            return rangeHelper(0, 0, arr.length - 1, left, right);
        }

        public int rangeHelper(int idx, int segLeft, int segRight, int left, int right) {
            if (left > segRight || right < segLeft)
                return 0;

            if (segLeft >= left && segRight <= right)
                return segments[idx];

            int mid = (segLeft + segRight) / 2;
            int max = rangeHelper(2 * idx + 1, segLeft, mid, left, right);
            max = Math.max(max, rangeHelper(2 * idx + 2, mid + 1, segRight, left, right));

            return max;
        }
    }

}
