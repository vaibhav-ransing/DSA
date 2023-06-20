package Course2.Matrix;

public class DiagonalTraversal {
    
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[] = new int[m+n-1];
        for(int d=0; d<=m+n-2; d++){
            int row = (d<n) ? 0 : d-n+1;
            int col = (d<n) ? d:n-1;
            while(row<m && col>=0){
                // System.out.println(mat[row][col]+" ");
                ans[d] = mat[row][col];
                row++;
                col--;
            }
        }
        return ans;
    }

}
