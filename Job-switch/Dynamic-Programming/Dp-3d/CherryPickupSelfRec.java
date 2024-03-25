public class CherryPickupSelfRec {

    public static int soln(int row1, int col1, int row2, int col2, int[][] matrix) {

        int n = matrix.length;
        if (row1 >= n || row2 >= n || col2 >= n || col2 >= n || matrix[row1][col1] == -1 || matrix[row2][col2] == -1)
            return Integer.MIN_VALUE;

        if (row1 == n - 1 && row2 == n - 2 && col1 == n - 1 && col2 == n - 2) {
            return matrix[row1][col1];
        }

        int cherries = 0;
        if (row1 == row2 && col1 == col2) {
            cherries += matrix[row1][col1];
        } else {
            cherries += matrix[row1][col1] + matrix[row2][col2];
        }

        int f1 = soln(row1, col1 + 1, row2, col2 + 1, matrix);
        int f2 = soln(row1 + 1, col1, row2 + 1, col2, matrix);
        int f3 = soln(row1 + 1, col1, row2, col2 + 1, matrix);
        int f4 = soln(row1, col1 + 1, row2 + 1, col2, matrix);

        cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));

        return cherries;
    }

    public static int cherryPickup(int[][] grid) {
        return soln(0, 0, 0, 0, grid);
    }

}
