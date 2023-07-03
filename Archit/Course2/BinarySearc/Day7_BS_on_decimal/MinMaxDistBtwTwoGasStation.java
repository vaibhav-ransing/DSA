package Course2.BinarySearc.Day7_BS_on_decimal;

import java.util.Arrays;

public class MinMaxDistBtwTwoGasStation {

    public static boolean isPossible(int stations[], int maxStationsAllowed, double dist) {

        int reqStations = 0;

        for (int i = 1; i < stations.length; i++) {
            double gap = (stations[i] - stations[i - 1]) / dist;
            reqStations += (int) Math.ceil(gap) - 1;
        }

        return reqStations <= maxStationsAllowed;
    }

    public static double findSmallestMaxDist(int stations[], int totalStations) {
        // code here
        Arrays.sort(stations);

        double left = 0.0;
        double right = 0;
        for (int i = 1; i < stations.length; i++) {
            right = Math.max(right, stations[i] - stations[i - 1]);
        }

        while (right - left >= 0.0001) {

            double mid = (left + right) / 2.0;
            boolean possible = isPossible(stations, totalStations, mid);
            if (possible) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
