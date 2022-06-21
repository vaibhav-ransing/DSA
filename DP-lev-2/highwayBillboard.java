import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class highwayBillboard {
    

    static class pair implements Comparable<pair> {
        int i;
        int value;
        pair(int i, int value){
            this.i = i;
            this.value = value;
        }
        public int compareTo(pair o){
            return this.i - o.i;
        }
    }

    public static int solution2(int n , int[] BB, int[] rev, int disBtw) {
        // write your code here
        int dp[] = new int[n];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0; i<BB.length; i++){
            pair p = new pair(BB[i], rev[i]);
            pq.add(p);
        }
        for(int i=0; i<dp.length; i++){

            if(pq.size()>0 && pq.peek().i==i){
                pair peek = pq.remove();
                int idx = peek.i;
                int val = peek.value;
                int left = (i-1)>=0?dp[i-1]:0;
                if(idx-disBtw-1 >=0){
                    val+=dp[idx-disBtw-1];
                }
                dp[i] = Math.max(left, val);
            }else{
                dp[i] = (i-1)>=0?dp[i-1]:0;
            }
        }
        for(int val:dp){
            System.out.print(val+" ");
        }
        return dp[dp.length-1];
    }
    public static int solution(int n , int[] BB, int[] rev, int dis) {
        // write your code here
        int dp[] = new int[n+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<BB.length; i++){
            map.put(BB[i], rev[i]);
        }
        for(int i=1; i<dp.length; i++){
            if(map.containsKey(i)){
                int take =  map.get(i);
                if(i-dis-1>=0) take+=dp[i-dis-1]; 
                dp[i] = Math.max(dp[i-1], take);
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }


    public static void main(String[] args) {
        int BB[] = {6,7,12,14,15};
        int rev[] ={5,8,5,3,1};
        solution(20, BB, rev, 5);
    }
}
