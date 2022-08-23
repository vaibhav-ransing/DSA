import java.util.ArrayDeque;
import java.util.Arrays;

public class test{

    

    static int solve(long N, int M, int K, int[][] Volcano) {
        // 1 1 1
        // 1 1 1`
        // 1 1 1`

        int graph[][] = new int[(int)N][M];
        int time=0;
        ArrayDeque<int[]> parentQueue = new ArrayDeque<>();
        ArrayDeque<int[]> childQueue = new ArrayDeque<>();
        for(int spot[]: Volcano){
            parentQueue.add(spot);
        }
        int dir[][] = {{1,0}, {0,1}, {-1,0},{0,-1}};
        while(parentQueue.size() > 0){
            int edge[] = parentQueue.pop();
            int i = edge[0];
            int j = edge[1];
            if(graph[i][j]==1){
                continue;
            }
            graph[i][j]=1;
            for(int d[]: dir){
                int i1 = d[0]+i;
                int j1 = d[1]+j;
                if(i1>=N || j1>=M || i1<0 || j1<0){
                    continue;
                }
                int temp[] = {i1, j1};
                childQueue.push(temp);
            }
            if(parentQueue.size()==0 && childQueue.size()>0){
                parentQueue = childQueue;
                childQueue = new ArrayDeque<>();
                time++;
            }
        }

        return time;
    }


    public static void main(String[] args) {
        int Volcano[][] = {{1,0},{1,2}};
        System.out.println(solve(3, 3, 2, Volcano));
    }
}