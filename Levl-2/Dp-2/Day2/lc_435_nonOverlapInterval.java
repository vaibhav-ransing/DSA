package Day2;

import java.util.ArrayList;
import java.util.Collections;

public class lc_435_nonOverlapInterval {
    
    public static class pair implements Comparable<pair>{
        int np;
        int sp;
        pair(int np, int sp){
            this.np = np;
            this.sp = sp;
        }
        public int compareTo(pair o){
            return this.np - o.np;
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        ArrayList<pair> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            pair p = new pair(intervals[i][0], intervals[i][1]);
            list.add(p);
        }
        Collections.sort(list);
        for(pair p: list){
            System.out.print(p.np +" "+p.sp);
        }
        System.out.println();
        int dp[] = new int[intervals.length];
        dp[0]=1;
        for(int i=1; i<dp.length; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                
                if(list.get(i).sp> list.get(j).sp){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int val: dp){
            max = Math.max(max, val);
        }
        // System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        
    }
}
