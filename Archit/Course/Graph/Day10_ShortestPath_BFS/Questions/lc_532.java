package Course.Graph.Day10_ShortestPath_BFS.Questions;

public class lc_532 {
    

    int[][] dir = {{0,1},{0,-1}, {1,0}, {-1,0}};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = 999;
                }
            }
        } 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    System.out.println("i= "+i +" "+ "j= "+j);
                    mat[i][j] = bfs(mat, i, j, 0);
                }
            }
        } 
        
        return mat;
    }
    public int bfs(int[][] mat, int r, int c, int distance){
        if(mat[r][c] == 0) return distance;
        if(mat[r][c] != 999) return mat[r][c];

        for(int[] d : dir){
            int rr = r+d[0], cc = c+d[1];
            if(rr==mat.length || cc==mat[0].length || rr<0 || cc<0) continue;
            int dis = bfs(mat, rr, cc, distance+1);
            mat[r][c] = Math.min(mat[r][c], dis);
        }

        return mat[r][c];
    }   


    // public int[][] updateMatrix(int[][] mat) {
    //     int n = mat.length;
    //     int m = mat[0].length;

    //     int[][] visited = new int[n][m];
    //     boolean[][] visited2 = new boolean[n][m];
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(mat[i][j] != 0){
    //                 visited[i][j] = 9999;
    //             }
    //         }
    //     }
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(mat[i][j] != 0){
    //                 visited[i][j] = bfs(mat, visited, i, j, 0,visited2);
    //             }
    //         }
    //     }
    //     return visited;
    // }
   
    // public int bfs(int[][] mat, int[][] visited, int r, int c, int dist, boolean[][] visited2){
    //     if(r==mat.length || c==mat[0].length || r<0 || c<0 ) return 9999;
    //     if(visited[r][c] != 9999) return visited[r][c];
    //     if(mat[r][c] == 0){
    //         System.out.println("distcan " + dist);
    //         return dist;
    //     } 
    //     if(visited2[r][c]) return 9999;
    //     visited2[r][c] = true;
    //     for(int[] d : dir){
    //         int dis = bfs(mat, visited, r+d[0], c+d[1], dist+1,visited2);
    //         System.out.println(dis);
    //         if(dis != 9999)
    //             visited[r+d[0]][c+d[1]] = Math.min(visited[r+d[0]][c+d[1]], dis);
    //     }

    //     return visited[r][c];
    // }

}
