import java.util.PriorityQueue;

public class swimInRisingWater {
    
    static class pair implements Comparable<pair>{
        int wsf;
        int i;
        int j;
        pair(int i, int j, int wsf){
            this.i = i;
            this.j = j;
            this.wsf = wsf;
        }
        public int compareTo(pair o){
            return this.wsf - o.wsf;
        }
    }

    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int ans = Integer.MAX_VALUE;

        PriorityQueue<pair> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][m];
        pq.add(new pair(0, 0, grid[0][0]));
        int dir[][] ={{1,0}, {0,1}, {-1,0},{0,-1}};
        while(pq.size()>0){
            pair peek = pq.remove();
            if(peek.i==grid.length-1 && peek.j==grid[0].length-1){
                ans = Math.min(ans, peek.wsf);
                break;
            }
            visited[peek.i][peek.j] = true;
            for(int d=0; d<dir.length; d++){
                int ii = peek.i + dir[d][0];
                int jj = peek.j + dir[d][1];
                if(ii<0 || jj<0 || ii==n || jj==m){
                    continue;
                }
                if(visited[ii][jj]==false){
                    int remTime = grid[ii][jj] - peek.wsf;
                    int currWsf = remTime<0?peek.wsf:peek.wsf+remTime;
                    pq.add(new pair(ii, jj, currWsf));
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        
    }
}
