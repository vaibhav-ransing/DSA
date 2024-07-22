import java.util.*;

public class FirstNegativeWindow {

    public static long[] printFirstNegativeInteger(long arr[], int n, int k) {

        long[] ans = new long[arr.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>(); // index of -ve values
        int l = 0, r = 0;
        while (r < n) {
            // x <= 2
            while (!queue.isEmpty() && queue.peekLast() < l) {
                queue.removeLast();
            }
            if (arr[r] < 0) {
                queue.addFirst(r);
            }
            if (r - l + 1 == k) {
                ans[l] = queue.isEmpty() ? 0 : arr[queue.getLast()];
                l++;
            }
            r++;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void test() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll.peekFirst());
        System.out.println(ll.peekLast());
        System.out.println(ll.removeLast());
    }

    public static void main(String[] args) {
        // long[] arr = { -8, 2, 3, -6, 10 };
        long[] arr = { -8, -6, 10 };
        printFirstNegativeInteger(arr, arr.length, 2);
    }
}