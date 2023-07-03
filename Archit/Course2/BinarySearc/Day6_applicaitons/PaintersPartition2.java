package Course2.BinarySearc.Day6_applicaitons;

public class PaintersPartition2 {

    public static boolean isPossbile(int[] arr, int k, long allocation) {
        // 10, 5, 20, 25, 17, 23, 2, 9, 4, 13
        int painters = 1;
        int sum = 0;
        for (int val : arr) {
            if (sum + val <= allocation) {
                sum += val;
            } else {
                sum = val;
                if (sum > allocation)
                    return false;
                painters++;
            }
        }
        return painters <= k;
    }

    static long minTime(int[] arr, int n, int k) {
        long left = 0;
        long right = (long) 1e5;

        while (left <= right) {
            long mid = (left + right) / 2;
            boolean poss = isPossbile(arr, k, mid);
            if (poss) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 20, 25, 17, 23, 2, 9, 4, 13 };
        int n = arr.length;
        int k = 10;
        System.out.println(isPossbile(arr, k, 15));

    }
}
