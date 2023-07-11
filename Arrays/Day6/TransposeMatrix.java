public class TransposeMatrix {
    
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans[][] = new int[n][m];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public int[][] transpose_n_dimension(int[][] matrix) {
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; i<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int left = 0, right = matrix.length-1;
        while(left < right){
            for(int i=0; i<matrix.length; i++){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
    }

    
    
}
