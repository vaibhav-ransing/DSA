import java.util.Arrays;

public class Test {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int firstOcc = -1;
        int lastOcc = -1;

        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        int idx = 1;

        int min = Integer.MAX_VALUE;

        while(right != null){
            if(
                (left.val > mid.val && right.val > mid.val) || 
                (left.val < mid.val && right.val < mid.val)
            ){
                firstOcc = firstOcc == -1 ? idx : firstOcc;
                lastOcc = idx;
                min = Math.min(min, lastOcc - firstOcc);
            }
            idx++;
        }
        if(min == Integer.MAX_VALUE)
            return new int[] {-1,-1};
        return new int[] {min, lastOcc - firstOcc};
    }


    static class SegmentTree {
        int[] segments;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            segments = new int[2 * n];
            build(arr);
        }

        void build(int[] arr) {
            // Insert leaf nodes in the segment tree
            for (int i = 0; i < n; i++) {
                segments[n + i] = arr[i];
            }
            // Build the segment tree by calculating parents
            for (int i = n - 1; i > 0; i--) {
                segments[i] = segments[2 * i] + segments[2 * i + 1];
            }
        }

        // Function to update a tree node
        void update(int index, int value) {
            // Set value at position p
            index += n;
            segments[index] = value;

            // Move upward and update parents
            for (int i = index; i > 1; i /= 2) {
                segments[i / 2] = segments[i] + segments[i ^ 1];
            }
        }

        // Function to get sum on interval [l, r)
        int query(int left, int right) {
            int sum = 0;
            left += n;
            right += n;

            while (left < right) {
                if ((left & 1) == 1) {
                    sum += segments[left];
                    left++;
                }
                if ((right & 1) == 1) {
                    right--;
                    sum += segments[right];
                }
                left /= 2;
                right /= 2;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 7 };
        SegmentTree sg = new SegmentTree(arr);

        // Print the initial segment tree
        System.out.println("Initial Segment Tree: " + Arrays.toString(sg.segments));

        // Update and print the segment tree after each update
        for (int i = 0; i < arr.length; i++) {
            sg.update(i, arr[i]);
            System.out.println("After updating index " + i + ": " + Arrays.toString(sg.segments));
        }

        // Query example
        System.out.println("Sum of range [1, 3): " + sg.query(1, 3)); // Should output 3 (1 + 2)
    }
}
