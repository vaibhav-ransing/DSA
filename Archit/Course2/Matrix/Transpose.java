package Course2.Matrix;

public class Transpose {
    

    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] ans = new int[col][row];

        for(int r=0; r<ans.length; r++){
            for(int c=0; c<ans[0].length; c++){
                ans[r][c] = matrix[c][r];
            }
        }

        return ans;
    }
}
