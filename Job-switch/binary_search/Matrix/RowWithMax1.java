package Matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class RowWithMax1 {

    public int[] rowAndMaximumOnes2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] ans = new int[2];

        for (int row = 0; row < n; row++) {

            int low = 0;
            int high = m -1;

            while (low <= high) {
                int col = (low + high) / 2;
                if (mat[row][col] == 1) {
                    if (ans[1] < (m - col)) {
                        ans[0] = row;
                        ans[1] = m - col;
                    }
                    high = col - 1;
                } else {
                    low = col + 1;
                }
            }
        }
        return ans;
    }

    public static int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high + 1;
    }

    public static int[] rowAndMaximumOnes(int[][] list) {
        int max_1 = -1;
        int ans_idx = -1;
        int m = list[0].length;

        for (int i = 0; i < list.length; i++) {
            Arrays.sort(list[i]);
            int count_1 = m - lowerBound(list[i], 1);
            if (count_1 > max_1) {
                max_1 = count_1;
                ans_idx = i;
            }
        }
        return new int[]{ans_idx, max_1};
    }
    
}
