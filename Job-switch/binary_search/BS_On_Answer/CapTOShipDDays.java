package BS_On_Answer;

import java.util.Arrays;

public class CapTOShipDDays {

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).min().orElse(0);
        int right = Arrays.stream(weights).sum();

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canShip(weights, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canShip(int[] weights, int days, int maxWtInADay) {
        int running = 0;
        for (int i = 0; i < weights.length; i++) {
            int cv = weights[i];
            if(cv > maxWtInADay) return false;
            if (cv + running > maxWtInADay) {
                days--;
                running = cv;
            } else {
                running += cv;
            }
        }
        return days >= 1;
    }
}
