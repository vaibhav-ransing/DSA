public class CherryPickRecursionPep {
    
    public static int cherryPickup(int[][] grid) {
        topToDown(0, 0, grid, 0);
        if(grid.length == 1){
            return grid[0][0];
        }
        return ans;
    }
    public static void topToDown(int row, int col, int[][] matrix, int ccsf){
        if(row >= matrix.length || col >= matrix[0].length || matrix[row][col] == -1){
            return;
        }
        if(row == matrix.length -1 && col == matrix[0].length - 1){
            bottomToUp(row, col, matrix, ccsf);
            return;
        }

        int cherries = matrix[row][col];
        matrix[row][col] = 0;
        topToDown(row+1, col, matrix, ccsf + cherries);
        topToDown(row, col+1, matrix, ccsf + cherries);
        matrix[row][col] = cherries;
        
    }
    
    static int ans = Integer.MIN_VALUE;

    public static void bottomToUp(int row, int col, int[][] matrix, int ccsf){
        if(row < 0 || col <0 || matrix[row][col] == -1)
            return;

        if(row == 0 && col == 0){
            ans = Math.max(ans, ccsf);
            return;
        }
        int cherries = matrix[row][col];
        matrix[row][col] = 0;
        bottomToUp(row-1, col, matrix, ccsf + cherries);
        bottomToUp(row, col-1, matrix, ccsf + cherries);
        matrix[row][col] = cherries;

    }

    public static void main(String[] args) {
        // int[][] matrix = {
        //     {0, 1, 1, 0, 0},
        //     {1, 1, 1, 1, 0},
        //     {-1, 1, 1, 1, -1},
        //     {0, 1, 1, 1, 0},
        //     {1, 0, -1, 0, 0}
        // };
        int[][] matrix = {
            {1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1}
        };
        cherryPickup(matrix);
        System.out.println(ans);
    }
}
