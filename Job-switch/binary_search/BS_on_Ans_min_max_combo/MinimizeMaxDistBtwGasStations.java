public class MinimizeMaxDistBtwGasStations {

    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        double low = 0, high = Arrays.stream(stations).max().orElse(Integer.MIN_VALUE);
        double ans = 0;
        while (high - low > 1e-6) {
            double mid = (high + low) / 2;
            if (check(stations, k, mid)) {
                ans = mid;
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    public static boolean check(int[] stations, int k, double maxDistance) {
        int used = 0;
        for (int i = 1; i < stations.length; i++) {
            int start = stations[i - 1];
            int stop = stations[i];
            double diff = stop - start;
            used += (Math.ceil(diff / maxDistance) - 1);
        }
        return used <= k;
    }
}