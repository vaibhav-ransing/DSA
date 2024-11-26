package AALastGo.TwoPointer;

import java.util.*;

public class SmallersRangeCoveringElementsKList {

    public int[] smallestRange(List<List<Integer>> list) {
        int n = list.size();
        int[] arr = new int[n]; // Pointers for each list

        int[] ans = new int[] { 0, Integer.MAX_VALUE };
        while (true) {
            int currMin = Integer.MAX_VALUE;
            int currMax = Integer.MIN_VALUE;
            int minListIdx = -1;

            // Find the current minimum value and maximum value among the pointers
            for (int i = 0; i < n; i++) {
                int val = list.get(i).get(arr[i]);
                if (val < currMin) {
                    currMin = val;
                    minListIdx = i;
                }
                currMax = Math.max(currMax, val);
            }

            // Update the smallest range if the current range is smaller
            if (currMax - currMin < ans[1] - ans[0]) {
                ans[0] = currMin;
                ans[1] = currMax;
            }

            // Move the pointer of the list that contributed the minimum value
            arr[minListIdx]++;
            if (arr[minListIdx] == list.get(minListIdx).size()) {
                break; // Exit if we've reached the end of one list
            }
        }

        return ans;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> list) {
        int n = list.size();
        int[] ans = new int[] { 0, Integer.MAX_VALUE };

        // PriorityQueue to store the current elements along with their list index and
        // element index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int currMax = Integer.MIN_VALUE;

        // Initialize the PriorityQueue with the first element of each list
        for (int i = 0; i < n; i++) {
            int val = list.get(i).get(0);
            pq.add(new int[] { val, i, 0 }); // {value, listIndex, elementIndex}
            currMax = Math.max(currMax, val);
        }

        while (true) {
            int[] curr = pq.poll(); // Get the smallest element
            int currMin = curr[0];
            int listIdx = curr[1];
            int elemIdx = curr[2];

            // Update the smallest range if the current range is smaller
            if (currMax - currMin < ans[1] - ans[0]) {
                ans[0] = currMin;
                ans[1] = currMax;
            }

            // Move to the next element in the same list
            if (elemIdx + 1 < list.get(listIdx).size()) {
                int nextVal = list.get(listIdx).get(elemIdx + 1);
                pq.add(new int[] { nextVal, listIdx, elemIdx + 1 });
                currMax = Math.max(currMax, nextVal);
            } else {
                break; // If we reach the end of a list, stop the process
            }
        }

        return ans;
    }
}
