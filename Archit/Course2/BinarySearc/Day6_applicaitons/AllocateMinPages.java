public class AllocateMinPages {

    // leetcode 410 Split Array Largest Sum

    public static boolean isDistributionPossible(int[] arr, int students, long maxLoad) {
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

    public static int findPages(int[] arr, int n, int totalStudens) {
        if (n < totalStudens)
            return -1;

        long left = 0;
        long right = 0;

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

    public static void main(String[] args) {
        int arr[] = { 12, 34, 67, 90 };
        int totalStudens = 2;
        findPages(arr, arr.length, totalStudens);
    }
}
