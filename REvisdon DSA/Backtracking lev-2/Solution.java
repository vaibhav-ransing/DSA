class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, aux(grid, visited, i, j));
                }
            }
        }
        
        return max;
    }
    
    private int aux(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if (grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        int max = aux(grid, visited, i-1, j);
        max = Math.max(max, aux(grid, visited, i+1, j));
        max = Math.max(max, aux(grid, visited, i, j-1));
        max = Math.max(max, aux(grid, visited, i, j+1));
        visited[i][j] = false;
        return grid[i][j] + max;
    }
}