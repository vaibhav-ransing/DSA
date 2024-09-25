package SweepLine.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DescribePaintin {

    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> ans = new ArrayList<>();
        Long[] arr = new Long[20002];
        boolean[] ends = new boolean[20002];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0L;
        }

        long startIdx = 20002;
        for (int[] seg : segments) {
            arr[seg[0]] += seg[2];
            arr[seg[1]] -= seg[2];
            ends[seg[1]] = true;

            startIdx = Math.min(seg[0], startIdx);
        }
        long prev = arr[(int) startIdx];

        System.out.println();

        for (int i = (int) startIdx + 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];

            if (arr[i] != prev || ends[i]) {
                List<Long> temp = new ArrayList<>();
                temp.add(startIdx);
                temp.add((long) i);
                temp.add(prev);
                ans.add(temp);
                startIdx = i;
                prev = arr[i];
            }
        }
        return ans;
    }

    public List<List<Long>> splitPaintingBetter(int[][] segments) {
        long mix[] = new long[100002], sum = 0, last_i = 0;
        boolean ends[] = new boolean[100002];
        List<List<Long>> res = new ArrayList<>();
        for (var s : segments) {
            mix[s[0]] += s[2];
            mix[s[1]] -= s[2];
            ends[s[0]] = ends[s[1]] = true;
        }
        for (int i = 1; i < 100002; ++i) {
            // sum > 0  check will make sure we dont add the initial empty paint i.e. 0...start0
            if (ends[i] && sum > 0) 
                res.add(Arrays.asList(last_i, (long) i, sum));

            // this will handle the starting condition
            last_i = ends[i] ? i : last_i; 
            sum += mix[i];
        }
        return res;
    }
}
