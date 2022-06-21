package Day4;

import java.util.ArrayDeque;
public  class coloringBorder {
    static class pair{
        int i;
        int j;
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    } 
      
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        ArrayDeque<pair> que = new ArrayDeque<>();
        int f = grid[row][col];
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        que.add(new pair(row,col)) ;
        while(que.size()>0){
            pair peek = que.pop();
            if(visited[peek.i][peek.j]){
                continue;
            }
            visited[peek.i][peek.j] = true;
            boolean test = false;
            for(int d=0; d<4; d++) {
                int ii = peek.i + dir[d][0];
                int jj = peek.j + dir[d][1];
                if(ii<0 || jj<0 || ii==grid.length || jj==grid[0].length) {
                    test = true;
                    continue;
                } 
                System.out.println("curr "+ peek.i+" "+peek.j);   
                if(grid[ii][jj]==f){
                    que.add(new pair(ii, jj)) ;
                }
                if(grid[ii][jj]!=f || ii==0 || jj==0 || ii==grid.length-1 || jj==grid[0].length-1){
                    test = true;
                }
            } 
        }
        return grid;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,1},{1,2}};
        colorBorder(arr, 0, 0, 3);
    }
}
