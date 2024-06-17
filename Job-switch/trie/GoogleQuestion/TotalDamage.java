package GoogleQuestion;

import java.util.*;

public class TotalDamage {

    public static long maximumTotalDamage(int[] power) {
        int n = power.length;
        Arrays.sort(power);

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int val : power) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }

        long dp[] = new long[n];

        for (int i = 0; i < n; i++) {
            int currentPower = power[i];
            int lowbound = binarySearch(power, i - 1, currentPower);
            long preDp = (lowbound >= 0) ? dp[lowbound] : 0;
            dp[i] = (freqMap.get(currentPower) * (long) currentPower) + preDp;
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    public static int binarySearch(int[] power, int j, int val) {
        int low = 0, high = j;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (power[mid] < val - 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 3, 4 };
        maximumTotalDamage(arr);
        // binarySearch(arr, 3, 4);
    }

    class HashSetSolution {

        int range[] = { -2, -1, 1, 2 };
        HashSet<Integer> set;

        public long maximumTotalDamageLis(int[] power) {
            set = new HashSet<>();
            return helper(0, power, 0);
        }

        public long helper(int idx, int[] power, long sum) {
            if (idx == power.length) {
                return sum;
            }

            long skip = helper(idx + 1, power, sum);

            long take = 0;
            if (!set.contains(power[idx])) {

                for (int i = 0; i < 4; i++) {
                    set.add(range[i] + power[idx]);
                }
                take = helper(idx + 1, power, sum + power[idx]);
                for (int i = 0; i < 4; i++) {
                    set.remove(range[i] + power[idx]);
                }
            }
            return Math.max(skip, take);
        }
        
    }

}
