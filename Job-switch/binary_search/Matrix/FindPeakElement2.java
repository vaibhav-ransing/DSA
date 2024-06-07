package Matrix;

public class FindPeakElement2 {

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {
            int midCol = (low + high) / 2;
            int row = getMax(mat, midCol);

            int left = midCol - 1 >= 0 ? mat[row][midCol - 1] : -1;
            int right = midCol + 1 < mat[0].length ? mat[row][midCol + 1] : -1;
            int curr = mat[row][midCol];

            if (curr > left && curr > right) {
                return new int[] { row, midCol };
            } else if (left > curr) {
                high = midCol - 1;
            } else {
                low = midCol + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    public int getMax(int[][] mat, int col) {
        int max = 0;
        int row = -1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                row = i;
            }
        }
        return row;
    }

}
