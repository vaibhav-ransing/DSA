import java.util.Arrays;

public class FreqOfMostFrequentElement {

    // Binary Search [1,4,8], k = 5 [13, 12, 8]
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = 1;
        int prefix[] = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            prefix[i] += arr[i] + prefix[i + 1];
        }
        for (int i = n - 1; i >= 0; i--) {

            int low = 0, high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int total = arr[i] * (i - mid);
                int prefixSumTillMid = prefix[mid] - prefix[i];
                int operationNeeded = total - prefixSumTillMid;
                if (operationNeeded > k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            max = Math.max(max, i - low + 1);
        }
        return max;
    }

    // Brute force
    public int maxFrequency2(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = 1;
        for (int i = n - 1; i >= 0; i--) {
            int tempK = k;
            int tc = 1;
            for (int j = i - 1; j >= 0; j--) {
                tempK -= (arr[i] - arr[j]);
                if (tempK < 0)
                    continue;
                tc++;
                max = Math.max(max, tc);
            }
        }
        return max;
    }
}