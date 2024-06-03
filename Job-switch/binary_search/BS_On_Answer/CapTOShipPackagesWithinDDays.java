package BS_On_Answer;

import java.util.Arrays;

public class CapTOShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        long low = 1, high = Arrays.stream(weights).sum();
        while (low < high) {
            long mid = low + (high - low)/2;
            if(check(weights, mid, days)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return (int) high;
    }
    
    public boolean check(int[] weights, long maxLoad, int days) {
        int req_days = 1; // Start with one day
        int wt_count = 0;
        for (int wt : weights) {
            if (wt_count + wt <= maxLoad) {
                wt_count += wt;
            } else {
                req_days += 1; // Increment the day count
                wt_count = wt; // Start the new day with the current weight
                if (wt > maxLoad) { // If a single weight exceeds maxLoad, it's not feasible
                    return false;
                }
            }
        }
        return req_days <= days;
    }
}
// 15 kg in 3 days