
public class CountNoOfTeams {

    public int numTeams(int[] rating) {
        int[][][] dp = new int[rating.length][3][rating.length];

        int inc = recInc(0, rating, 0, -1, dp);
        int dsc = recDesc(0, rating, 0, -1, dp);
        return inc + dsc;
    }

    public int recInc(int idx, int rating[], int soldierPicked, int prevPicked, int[][][] dp) {
        if (idx == rating.length && soldierPicked == 3)
            return 1;
        if (idx == rating.length)
            return 0;
        int ans = 0;
        if (prevPicked == -1 || rating[prevPicked] < rating[idx]) {
            ans += recInc(idx + 1, rating, soldierPicked + 1, idx, dp);
        }
        ans += recInc(idx + 1, rating, soldierPicked, prevPicked, dp);
        return ans;
    }

    public int recDesc(int idx, int rating[], int soldierPicked, int prevPicked, int[][][] dp) {
        if (idx == rating.length && soldierPicked == 3)
            return 1;
        if (idx == rating.length)
            return 0;
        int ans = 0;
        if (prevPicked == -1 || rating[prevPicked] > rating[idx]) {
            ans += recDesc(idx + 1, rating, soldierPicked + 1, idx, dp);
        }
        ans += recDesc(idx + 1, rating, soldierPicked, prevPicked, dp);
        return ans;
    }

    // segment tree
    class Solution {
        // do not want to do it this way
        static class SegmentNode {
            public int l, r;
            public int count = 0;
            public SegmentNode left;
            public SegmentNode right;

            public SegmentNode() {
            }

            public SegmentNode(int l, int r) {
                this.l = l;
                this.r = r;
                this.count = count;
            }
        }

        int getValue(SegmentNode root, int l, int r) {
            // System.out.println(root.l+" "+root.r);
            if (root == null)
                return 0;
            if (r < root.l)
                return 0;
            if (root.r < l)
                return 0;
            if (l <= root.l && root.r <= r)
                return root.count;
            return getValue(root.left, l, r) + getValue(root.right, l, r);
        }

        void insert(SegmentNode root, int index) {
            if (index < root.l)
                return;
            if (index > root.r)
                return;
            if (root.l == root.r) {
                root.count++;
                return;
            }
            int mid = (root.l + root.r) / 2;
            if (root.left == null) {
                root.left = new SegmentNode(root.l, mid);
            }
            if (root.right == null) {
                root.right = new SegmentNode(mid + 1, root.r);
            }
            insert(root.left, index);
            insert(root.right, index);
            root.count = root.left.count + root.right.count;
        }

        public int numTeams(int[] rating) {
            int max = 200000;

            SegmentNode root_left = new SegmentNode(0, max);
            SegmentNode root_right = new SegmentNode(0, max);

            int[] left = new int[rating.length];
            int[] left_g = new int[rating.length];

            int[] right = new int[rating.length];
            int[] right_l = new int[rating.length];

            for (int i = 0; i < left.length; i++) {
                left[i] = getValue(root_left, 0, rating[i] - 1);
                left_g[i] = getValue(root_left, rating[i] + 1, max);
                insert(root_left, rating[i]);
            }
            for (int i = rating.length - 1; i >= 0; i--) {
                right[i] = getValue(root_right, rating[i] + 1, max);
                right_l[i] = getValue(root_right, 0, rating[i] - 1);
                insert(root_right, rating[i]);
            }
            int ans = 0;
            for (int i = 1; i < rating.length - 1; i++) {
                ans += left[i] * right[i];
                ans += left_g[i] * right_l[i];
            }
            return ans;
        }
    }
}
