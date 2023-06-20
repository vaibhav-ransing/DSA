package Course2.Matrix;

public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        int leftCol = 0;
        int rightCol = n - 1;

        while(leftCol < rightCol){
            for(int row=0; row<n; row++){
                int temp = matrix[row][leftCol];
                matrix[row][leftCol] = matrix[row][rightCol];
                matrix[row][rightCol] = temp;
            }
            leftCol++;
            rightCol--;
        }
    }
}
