import java.util.Arrays;

public class Implementation {

    public static void fillSegments(int[] segments, int idx, int low, int high, int[] prefixSum) {
        if (low > high || idx >= segments.length)
            return;

        int currSum = prefixSum[high] - (low - 1 >= 0 ? prefixSum[low - 1] : 0);
        segments[idx] = currSum;

        fillSegments(segments, (2 * idx) + 1, low, (low + high) / 2, prefixSum);
        fillSegments(segments, (2 * idx) + 2, (low + high) / 2 + 1, high, prefixSum);
    }

    public static void buildSegments(int arr[]) {
        int n = arr.length;
        seg = new int[2 * n - 1];

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] += (arr[i] + prefixSum[i - 1]);
        }
        fillSegments(seg, 0, 0, n - 1, prefixSum);

        // [13, 4, 9, 3, 1, 2, 7]
        // System.out.println(Arrays.toString(seg));
    }

    static int seg[];

    public static void update(int arr[], int idx, int val) {
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

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 7 };
        buildSegments(arr);
        System.out.println(Arrays.toString(seg));
        update(arr, 1, 4);
        System.out.println(Arrays.toString(seg));

    }

}