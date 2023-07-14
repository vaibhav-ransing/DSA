import java.util.ArrayList;

public class RatInMaze{

    static boolean[][] visited;
    static ArrayList<String> ans;

    public static ArrayList<String> findPath(int[][] matrix, int n) {
        visited = new boolean[n][n];
        ans = new ArrayList<>();
        bfs(matrix, 0, 0, "");
        return ans;
    }

    public static void bfs(int[][] matrix, int r, int c, String asf){
        if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || visited[r][c] || matrix[r][c] == 0){
            return;
        }   
        if(r == matrix.length -1 && c == matrix[0].length -1){
            ans.add(asf);
            return;
        }

        visited[r][c] = true;

        bfs(matrix, r-1, c, asf+"U");
        bfs(matrix, r+1, c, asf+"D");
        bfs(matrix, r, c-1, asf+"L");
        bfs(matrix, r, c+1, asf+"R");

        visited[r][c] = false;
    }


    public static void main(String[] args) {
        
    }
}