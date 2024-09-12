package Revision;

public class Test {

    public boolean searchMatrix(int[][] arr, int tgt) {
        int n = arr.length;
        int m = arr[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int r = mid / m;
            int c = mid % m;
            if (arr[r][c] == tgt)
                return true;
            if (arr[r][c] > tgt) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
