package Day2;

import java.util.*;

public class lec_1235_jobSchedule {
    
    public static class pair implements Comparable<pair>{
        int np;
        int sp;
        int profit;
        pair(int np, int sp, int profit){
            this.np = np;
            this.sp = sp;
            this.profit = profit;
        }
        public int compareTo(pair o){
            return this.np - o.np;
        }
    }

    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {   
        ArrayList<pair> list = new ArrayList<>();
        for(int i=0; i<startTime.length; i++){
            pair p = new pair(startTime[i], endTime[i], profit[i]);
            list.add(p);
        }
        Collections.sort(list);
        
        int dp[] = new int[startTime.length];
        dp[0]=list.get(0).profit;
        for(int i=1; i<dp.length; i++){
            dp[i]=list.get(i).profit;
            for(int j=0; j<i; j++){
                
                if(list.get(i).sp < list.get(j).np){
                    dp[i] = Math.max(dp[i], dp[j]+list.get(i).profit);
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

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<pair> list = new ArrayList<>();
        for(int i=0; i<startTime.length; i++){
            pair p = new pair(startTime[i], endTime[i], profit[i]);
            list.add(p);
        }
        Collections.sort(list);
        
        int dp[] = new int[startTime.length];
        dp[0]=list.get(0).profit;
        for(int i=1; i<dp.length; i++){
            dp[i]=list.get(i).profit;
            for(int j=0; j<i; j++){
                
                if(list.get(i).sp < list.get(j).np){
                    dp[i] = Math.max(dp[i], dp[j]+list.get(i).profit);
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
