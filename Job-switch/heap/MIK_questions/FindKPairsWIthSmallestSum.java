import java.util.*;

public class FindKPairsWIthSmallestSum {

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


    public List<List<Integer>> kSmallestPairsBrute(int[] nums1, int[] nums2, int k) {

        // sort the priority queue based on the sum of edges
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]); // vertex1, vertex2, sum (i.e vertex1 +
                                                                              // vertex2)

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                int v1 = nums1[i];
                int v2 = nums2[j];
                int sum = v1 + v2;

                if (pq.size() < k) { // we need k elements so keep adding the edges until we have k elements into it
                    pq.add(new int[] { v1, v2, sum });

                } else { // if the new edge sum is smaller than existing sum in queue then pop it and add
                         // new one
                    if (pq.peek()[2] > sum) {
                        pq.remove();
                        pq.add(new int[] { v1, v2, sum });
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (pq.size() > 0) {
            int[] peek = pq.remove();
            ans.add(Arrays.asList(peek[0], peek[1]));
        }
        Collections.reverse(ans);
        return ans;
    }
}

// bold important points
// Remove java-8
// Tech used section insead of filling in points
// add technologies used

// projet link too
// remove dates for project

// remove courses

// pramp.com