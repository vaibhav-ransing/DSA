package Day5;

public class RadixSort {
    public static int[] countSort(int[] arr, int place) {
        int[] ans = new int[arr.length];
        int[] freq = new int[10];

        // create frequency array
        for (int ele : arr) {
            int digit = (ele % (10 * place)) / place;
            freq[digit]++;
        }

        for(int i=1; i<freq.length; i++){
            freq[i] += freq[i-1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int ele = arr[i];
            int digit = (arr[i] % (10 * place)) / place;
            freq[digit]--;
            int idx = freq[digit];
            ans[idx] = ele;
        }
        return ans;
    }

    public static int[] radixSortSoln(int[] arr) {
        for (int place = 1; place <= (int) 1e8; place += 10) {
            arr = countSort(arr, place);
        }
        int gap = 0;
        for(int i=1; i<arr.length; i++){
            gap = Math.max(gap, arr[i]-arr[i-1]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 4, 8, 1, 3, 2, 1, 2 };
        radixSortSoln(arr);
    }
}
