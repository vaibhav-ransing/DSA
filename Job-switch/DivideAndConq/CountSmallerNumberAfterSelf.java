package DivideAndConq;

import java.util.*;

class Solution {

    public List<Integer> countSmaller(int[] nums) {
        int len = (nums == null ? 0 : nums.length);

        int[] idxs = new int[len];
        int[] count = new int[len];

        for (int i = 0; i < len; i++)
            idxs[i] = i;

        mergeSort(nums, idxs, 0, len, count);

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : count)
            list.add(i);

        return list;
    }

    private void mergeSort(int[] nums, int[] idxs, int start, int end, int[] count) {
        if (start + 1 >= end)
            return;

        int mid = (end - start) / 2 + start;
        mergeSort(nums, idxs, start, mid, count);
        mergeSort(nums, idxs, mid, end, count);

        merge(nums, idxs, start, end, count);
    }

    private void merge(int[] nums, int[] idxs, int start, int end, int[] count) {
        int mid = (end - start) / 2 + start;

        int[] tmp = new int[end - start];
        int[] tmpidx = new int[end - start];
        int i = start, j = mid, k = 0;
        while (k < end - start) {
            if (i < mid) {
                if (j < end && nums[j] < nums[i]) {
                    tmpidx[k] = idxs[j];
                    tmp[k++] = nums[j++];
                } else {
                    count[idxs[i]] += j - mid; // add those already counted
                    tmpidx[k] = idxs[i];
                    tmp[k++] = nums[i++];
                }

            } else {
                tmpidx[k] = idxs[j];
                tmp[k++] = nums[j++];
            }
        }

        System.arraycopy(tmpidx, 0, idxs, start, end - start);
        System.arraycopy(tmp, 0, nums, start, end - start);
    }
}

public class CountSmallerNumberAfterSelf {

    class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        ans = new int[nums.length];
        return null;
    }

    void check(Pair[] left, Pair[] right, int mid) {

    }

    void mergeSort(Pair[] arr, Pair[] temp, int left, int right) {

        if (left >= right)
            return;
        int mid = (left + right) / 2;

        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);

        merge(arr, temp, left, mid, right);
    }

    void merge(Pair[] arr, Pair[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i].val <= temp[j].val) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }
}
