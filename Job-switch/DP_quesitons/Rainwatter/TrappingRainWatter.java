package Rainwatter;

public class TrappingRainWatter {

    public int trap(int[] height) {
        int n = height.length;

        int[] lm = new int[n];
        lm[0] = height[0];

        int[] rm = new int[n];
        rm[n - 1] = height[n - 1];

        // store the maximum height from 0 -> i  at i-th index
        for (int i = 1; i < n; i++) {
            lm[i] = Math.max(lm[i - 1], height[i]);
        }

        // store the maximum height at from right at j-th index
        for (int j = n - 2; j >= 0; j--) {
            rm[j] = Math.max(rm[j + 1], height[j]);
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans += Math.min(lm[i], rm[i]) - height[i];
        }
        return ans;
    }
}
