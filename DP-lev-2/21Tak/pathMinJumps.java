import java.util.ArrayDeque;
import java.util.Arrays;

public class pathMinJumps{

    public static void Solution(int arr[]){
        int dp[] = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[arr.length-1]=0;
        for(int i=arr.length-2; i>=0; i--){
            int jumps = arr[i];
            for(int j=1; j<=jumps; j++){
                int step = i+j;

                if(step<dp.length && dp[step]!= Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[step]+1, dp[i]);
                }
            }
        }
        System.out.println(dp[0]);
        printPath(dp, arr);
    }
    
    // 3,3,0,  2,1,2,4,2, 0, 0
    // 4 4 max 3 3 2 1 1 max 0
    static class pair{
        int jump;
        int dpStep;
        String asf;
        int idx;
        pair(int jump,  String asf, int idx){
            this.jump = jump;
            this.asf = asf;
            this.idx = idx;
        }
    }
    static void printPath(int dp[], int arr[]){

        ArrayDeque<pair> queue = new ArrayDeque<>();
        pair fp = new pair(arr[0],  "0", 0);
        queue.add(fp);
        while(queue.size()>0){
            pair p = queue.pop();
            if(p.idx==dp.length-1){
                System.out.println(p.asf+" .");
                continue;
            }   
            int step= dp[p.idx];
            for(int i=1; i<=p.jump; i++){
                if(p.idx+i<dp.length && dp[p.idx+i]==step-1){
                    pair np =new pair(arr[p.idx+i], p.asf+" -> "+(p.idx+i), p.idx+i);
                    queue.add(np);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,3,0,2,1,2,4,2,0,0};
        Solution(arr);
    }
}