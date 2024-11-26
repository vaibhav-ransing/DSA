package AALastGo.FenwikTree;

import java.util.Arrays;

public class Impl {

    class NumArray {
        BIT bit;

        public NumArray(int[] nums) {
            bit = new BIT(nums);
        }

        public void update(int index, int val) {
            int currentValue = sumRange(index, index); // Get the current value at the index
            int diff = val - currentValue; // Calculate the difference
            bit.add(index + 1, diff); // Apply the difference
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return bit.sum(right);
            } else {
                return bit.sum(right) - bit.sum(left);
            }
        }
    }

    class BIT {

        int[] T;
        int n;

        BIT(int[] arr) {
            n = arr.length;
            T = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                add(i, arr[i - 1]);
            }
        }

        // We asume that data start from index 1 and not 0
        int[] populateArrInN(int[] arr) {
            int n = arr.length;
            int[] Tree = Arrays.copyOf(arr, n);

            for (int i = 1; i < Tree.length; i++) {
                int p = i + (i & -i); // index of parent
                if (p < T.length) {
                    Tree[p] += Tree[i];
                }
            }
            return Tree;
        }

        int sum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += T[i];
                i -= (i & -i);
            }
            return sum;
        }

        void add(int i, int val) {
            while (i < T.length) { // T.len == n + 1
                T[i] += val;
                i += i & -i; // add last set bit
            }
        }
    }

}