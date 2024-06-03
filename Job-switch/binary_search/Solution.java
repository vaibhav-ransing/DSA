import java.util.Arrays;

public class Solution {
    public static int minimumRateToEatBananas(int []arr, int h) {
        if (h < arr.length)
            return -1;

        long high = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        long low = 1;
        
        while (low <= high) {
            long mid = low + (high - low) / 2; // mid is speed at which bana is eaten
            if (canEat(arr, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
        // Write Your Code Here
    }

    public static boolean canEat(int[] arr, long speed, long hour) {
        long reqHrs = 0;
        for (long val : arr) {
            reqHrs += Math.ceilDiv(val, speed);
        }
        return reqHrs <= hour;
    }
}



