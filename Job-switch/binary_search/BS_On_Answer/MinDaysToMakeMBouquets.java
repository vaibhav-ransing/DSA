package BS_On_Answer;

import java.util.Arrays;

public class MinDaysToMakeMBouquets {

    public static int minDays(int[] arr, int num, int size) {
        long mult = ((long) num * (long) size);
        System.out.println(mult);
        if (arr.length < mult)
            return -1;

        long low = 1;
        long high = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        int ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(arr, num, size, mid)) {
                high = mid - 1;
                ans = (int) mid;
            } else {
                low = mid + 1;
            }
        }
        // return ans;
        return (int)high + 1;
    }

    public static boolean check(int[] arr, int numOfBoq, int size, long daysPassed) {

        int adjCount = 0;
        int countOfBqofSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= daysPassed) { // a[i] contains number of days needed for blooming ith flower

                adjCount++;
            } else {
                countOfBqofSize += adjCount / size;
                adjCount = 0;
            }
        }
        countOfBqofSize += adjCount / size;
        return countOfBqofSize >= numOfBoq;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 10, 3, 10, 2 };
        int numOfBoq = 3, k = 1;

        System.out.println(check(arr, numOfBoq, k, 2));
    }

}
