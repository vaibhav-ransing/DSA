package Lc_Daily.Nov;

public class lc862 {

    public int shortestSubarray(int[] arr, int val) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (left <= right && sum >= val) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
