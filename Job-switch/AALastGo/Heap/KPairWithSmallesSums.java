package AALastGo.Heap;

import java.util.*;

public class KPairWithSmallesSums {
    
    public List<List<Integer>> kSmallestPairs(int[] arr1, int[] arr2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // idx1, idx2, sum
        pq.add(new int[] { 0, 0, (arr1[0] + arr2[0]) });
        Set<String> set = new HashSet<>();
        set.add(0 + "," + 0);
        List<List<Integer>> ans = new ArrayList<>();

        while (k-- > 0 && pq.size() > 0) {
            int[] peek = pq.remove();
            int i = peek[0];
            int j = peek[1];

            ans.add(Arrays.asList(arr1[i], arr2[j]));

            if (i + 1 < arr1.length && !set.contains((i + 1) + "," + j)) {
                set.add((i + 1) + "," + j);
                pq.add(new int[] { i + 1, j, arr1[i + 1] + arr2[j] });
            }
            if (j + 1 < arr2.length && !set.contains(i + "," + (j + 1))) {
                set.add(i + "," + (j + 1));
                pq.add(new int[] { i, j + 1, arr1[i] + arr2[j + 1] });
            }
        }
        return ans;
    }
}
