package BS_On_Answer;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumber3 {
    class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            long low = 1;
            long high = 2_000_000_000; // max value for binary search

            while (low <= high) {
                long mid = low + (high - low) / 2;

                if (countUglyNumbers(mid, a, b, c) >= n) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return (int) low;
        }

        // Function to count how many numbers are divisible by a, b, or c up to `num`
        public long countUglyNumbers(long num, int a, int b, int c) {
            return (num / a) + (num / b) + (num / c)
                    - (num / lcm(a, b)) - (num / lcm(b, c)) - (num / lcm(a, c))
                    + (num / lcm(a, lcm(b, c)));
        }

        // Helper function to compute the Greatest Common Divisor (GCD)
        private long gcd(long x, long y) {
            while (y != 0) {
                long temp = y;
                y = x % y;
                x = temp;
            }
            return x;
        }

        // Helper function to compute the Least Common Multiple (LCM)
        private long lcm(long x, long y) {
            return x * (y / gcd(x, y));
        }
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = a;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, n, a, b, c)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int mid, int n, int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = new int[] { a, b, c };
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr) {
            set.add(val);
            pq.add(val);
        }
        while (pq.size() > 0 && pq.peek() < mid && n-- > 1) {
            n--;
            int peek = pq.poll();
            for (int val : arr) {
                if (!set.contains(val * peek)) {
                    set.add(val * peek);
                    pq.add(val * peek);
                }
            }
        }
        return n <= 1;
    }
}
