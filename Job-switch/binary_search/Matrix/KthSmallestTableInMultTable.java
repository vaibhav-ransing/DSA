package Matrix;

public class KthSmallestTableInMultTable {
    // lc 668

    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        // find the smallest kth element in the range. Use binary search to speed up.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // check if have enough element for it to the kth element
            if (!check(mid, m, n, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean check(int mid, int m, int n, int k) {
        int count = 0;
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if (col * row > mid)
                    break;
                count++;
            }
            
        }
        return k >= count;
    }
}
