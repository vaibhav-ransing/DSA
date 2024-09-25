package BinaryIndexTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc315_SmallerElemToRightCount {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][]; // val, idx

        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { nums[i], i };
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int[] rank = new int[n + 1];
        for (int i = 1; i < rank.length; i++) {
            rank[arr[i - 1][1] + 1] = i;
        }

        BIT bit = new BIT(n);

        int[] temp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            temp[i] = bit.sum(rank[i + 1] - 1);
            bit.update(rank[i + 1], 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int val : temp) {
            ans.add(val);
        }

        return ans;
    }

    class BIT {

        int[] arr;

        BIT(int n) {
            arr = new int[n + 1];
        }

        void update(int i, int val) {
            while (i < arr.length) {
                arr[i] += val;
                i += (i & -i);
            }
        }

        int sum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += arr[i];
                i -= (i & -i);
            }
            return sum;
        }
    }
}
