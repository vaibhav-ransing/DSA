package Course2.BinarySearc.Day6_applicaitons;

import java.util.Arrays;

public class AgressiveCows {
    
    public static boolean isPossible(int[] stalls, int cows, long dist){
        int left = 0, right = 1;
        int cowsPlaced = 1;
        while(right<stalls.length){
            if(stalls[right] - stalls[left] >= dist){
                cowsPlaced++;
                left = right;
            }
            right++;
        }
        return cowsPlaced >= cows;
    }

    public static int solve(int n, int cows, int[] stalls) {
        
        Arrays.sort(stalls);
        long left = 0; 
        long right = (long)1e10;
        
        while(left <= right){
            long mid = (left+right)/2;
            boolean possible = isPossible(stalls, cows, mid);
            if(possible){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return (int) right;
    }
}
