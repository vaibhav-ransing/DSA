package BS_On_Answer;

import java.util.Arrays;

public class KokoEatingBanana {

    public static int minEatingSpeed(int[] arr, int h) {
        if (h < arr.length)
            return -1;

        long high = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        long low = 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;    // mid is speed at which bana is eaten
            if(canEat(arr, mid, h)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (int) high;
    }

    public static boolean canEat(int[] arr, long speed, long hour) {
        long reqHrs = 0;
        for (long val : arr) {
            reqHrs += Math.ceilDiv(val, speed);
        }
        return reqHrs <= hour;
    }
    
    public static void main(String[] args) {
       long[] arr = {30,11,23,4,20};
       canEat(arr, 24, 5) ;
    // System.out.prlongln(Math.ceilDiv(30, 24));
    }
}
