package PranavTest;
import java.util.List;

public class test{
    

    public static boolean[][] visited;
    public static int dir[][] = {{1,0}, {-1,0}, {0,1}, {0,-1} };
    public static int soln(List<List<Integer>> sample){
        int n = sample.size();
        visited = new boolean[n][n];
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == false){
                    int temp = bfs(sample, i, j, i, j);
                    max = Math.max(max, temp);
                }
            }
        }
        return max;
    }
    public static int bfs(List<List<Integer>> samples, int row, int col, int startRow, int startCol){
        if(row < 0 || col < 0 || row >= samples.size() || col >= samples.size())
            return 0;
        if(samples.get(row).get(col) == 0 || visited[row][col]) return 0;
        visited[row][col] = true;

        int val = 0;
        for(int[] d : dir){
            int rr = row + d[0];
            int cc = col + d[1];
            val = Math.max(val , bfs(samples, rr, cc, startRow, startCol));
        }
        int curr = 0;
        if(Math.abs((int)(row-startRow)) == Math.abs((int)(col-startCol))){
            curr = Math.abs((int)(row-startRow)) + 1;
        }
        return Math.max(curr, val);
    }

    public static void main(String[] args) {
        
    }
}