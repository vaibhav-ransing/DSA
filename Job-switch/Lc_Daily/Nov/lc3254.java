package Lc_Daily.Nov;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc3254 {
    class Solution {
        public int[] resultsArray(int[] nums, int k) {
            if (k == 1) {
                return nums.clone();
            }

            int n = nums.length;
            List<Integer> result = new ArrayList<>();
            Deque<Integer> window = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // Remove elements outside window
                while (!window.isEmpty() && i - window.peekFirst() >= k) {
                    window.pollFirst();
                }

                // Check consecutive sequence
                if (window.isEmpty() || nums[i] - nums[i - 1] == 1) {
                    window.offerLast(i);
                } else {
                    window.clear();
                    window.offerLast(i);
                }

                // Add result when window size is k
                if (i >= k - 1) {
                    result.add(window.size() == k ? nums[i] : -1);
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    class Solution2 {
        public int[] resultsArray(int[] nums, int k) {
            if (nums == null || nums.length < k) {
                return new int[0];
            }

            int arr[] = new int[nums.length - k + 1];
            int i = 0;
            int j = k - 1;
            int a = 0;
            while (j < nums.length) {
                if (solved(nums, i, j)) {
                    arr[a] = nums[j];
                } else {
                    arr[a] = -1;
                }
                i++;
                j++;
                a++;
            }
            return arr;

        }

        private boolean solved(int nums[], int start, int end) {
            for (int i = start; i < end; i++) {
                if (nums[i] + 1 != nums[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}