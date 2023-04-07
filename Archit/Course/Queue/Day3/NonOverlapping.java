package Day3;

import java.util.Arrays;

public class NonOverlapping {
    

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->{
            return b[0] - a[0];
        });    
        int rem = 0;
        int[] next = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for(int[] curr: intervals){
            if(curr[1] <= next[0]){
                next = curr;
            }else{
                rem++;
            }
        }
        return rem;
    }

}
