package BS_On_Answer;

import java.util.Arrays;

public class MinimizeMaxProdDistributed {

    public static int minimizedMaximum(int n, int[] arr) {
        int low = 0, high = Arrays.stream(arr).max().orElse(-1);
        while (low < high) {
            int mid = (low + high) / 2;
            if (check(mid, n, arr)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean checkGpt(int size, int n, int[] arr) {
        int requiredStores = 0;
        for (int quantity : arr) {
            requiredStores += (quantity + size - 1) / size;  
            if (requiredStores > n) {
                return false; 
            }
        }
        return true; 
    }

    public static boolean check(int size, int n, int[] arr) {
        int idx = 0;
        int rem = arr[0];
        for (int i = 1; i <= n; i++) {
            rem -= size;
            if (rem <= 0) {
                if (idx == arr.length - 1)
                    return true;
                idx++;
                rem = arr[idx];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 15, 10, 10 };
        System.out.println(check(4, 7, arr));
    }
}
