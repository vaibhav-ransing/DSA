public class SplitArrLargestSum {
    // lc 410
    public int splitArray(int[] arr, int totalStudens) {

        int n = arr.length;
        if (n < totalStudens)
            return -1;

        long left = 0, right = 0;

        for (int val : arr) {
            left = Math.max(left, val);
            right += val;
        }

        while (left <= right) {
            long mid =  (left + right) / 2;
            boolean possible = isDistributionPossible(arr, totalStudens, mid);
            if (possible) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }
     public boolean isDistributionPossible(int[] arr, int students, long maxLoad) {
        int i = 0;
        int sum = 0;
        int usedStudent = 1;
        while (i < arr.length) {
            if (sum + arr[i] <= maxLoad) {
                sum += arr[i];
            } else {
                sum = arr[i];
                usedStudent++;
            }
            i++;
        }
        return usedStudent <= students;
    }   
}
