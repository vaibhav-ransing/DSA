package Stack;

import java.util.Arrays;

public class IncreasingTripletSubseq {

    public boolean increasingTriplet(int[] arr) {
        int m1 = arr[0];
        int m2 = 999;
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            if (curr < m1) {
                m2 = m1;
                m1 = curr;
            } else if (curr < m2) {
                m2 = curr;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = Integer.MAX_VALUE;
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            int curr = arr[i];
            min = Math.min(min, curr);
            left[i] = min;

        }

        right[n - 1] = Integer.MIN_VALUE;
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            right[i] = max;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            if (left[i] != curr && curr != right[i])
                return true;
        }
        return false;
    }
    // 5,7,6,9,2,4
}
