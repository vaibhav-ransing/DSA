import java.util.ArrayList;
import java.util.HashMap;

public class KadensAlgoWithPrefixSum {
    // https://leetcode.com/discuss/interview-question/4929501/Google-onsite-Interview

    public static int[] findMaxSumSubarrayWithSameEnds(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            prefix[i] = sum;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        int ans = 0;
        int ansArr[] = new int[2];
        for (ArrayList<Integer> list : map.values()) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int idxi = list.get(i);
                    int idxj = list.get(j);
                    int prevAns = ans;
                    if (idxi == 0) {
                        ans = Math.max(ans, prefix[idxj]);
                    } else {
                        ans = Math.max(ans, prefix[idxj] - prefix[idxi - 1]);
                    }
                    if (prevAns < ans) {
                        ansArr[0] = idxi;
                        ansArr[1] = idxj;
                    }
                }
            }
        }
        System.out.println(ansArr[0] + " " + ansArr[1]);
        return ansArr;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 3, 5, 6, 3, -6, 3 };
        int arr[] = { 3, -6, 10, 9, 2, -6 };
        findMaxSumSubarrayWithSameEnds(arr);
    }
}
