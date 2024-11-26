package Lc_Daily.Nov;

import java.util.Arrays;

public class lc2516 {

    class Solution {
        public int takeCharacters(String s, int k) {
            // Count the total occurrences of 'a', 'b', and 'c'
            int[] total = new int[3];
            for (char c : s.toCharArray()) {
                total[c - 'a']++;
            }

            // If it's impossible to have at least `k` of each character, return -1
            for (int count : total) {
                if (count < k)
                    return -1;
            }

            // Sliding window to find the maximum length of the middle part
            int n = s.length();
            int[] current = new int[3];
            int maxMiddle = 0, left = 0;

            for (int right = 0; right < n; right++) {
                current[s.charAt(right) - 'a']++;

                // Shrink the window if we have more than `total[i] - k` of any character
                while (current[0] > total[0] - k || current[1] > total[1] - k || current[2] > total[2] - k) {
                    current[s.charAt(left) - 'a']--;
                    left++;
                }

                // Update the maximum length of the valid middle part
                maxMiddle = Math.max(maxMiddle, right - left + 1);
            }

            // Minimum characters to take is the complement of the maximum middle length
            return n - maxMiddle;
        }
    }

    public int takeCharacters(String s, int k) {
        if (k == 0)
            return 0;
        int[] original = new int[3];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int[] count = Arrays.copyOf(original, original.length);
            count[s.charAt(i) - 'a']++;
            if (count[0] >= k && count[1] >= k && count[2] >= k) {
                min = Math.min(min, i + 1);
            }
            for (int j = s.length() - 1; j > i; j--) {
                count[s.charAt(j) - 'a']++;
                if (count[0] >= k && count[1] >= k && count[2] >= k) {
                    min = Math.min(min, i + 1 + (s.length() - j));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int takeCharacters1(String s, int k) {
        int ans = rec(s, 0, s.length() - 1, new int[3], 3, k);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int rec(String str, int i, int j, int[] arr, int count, int k) {
        if (count == 0) {
            return i + 1 + (str.length() - j);
        }
        if (i > j) {
            return Integer.MAX_VALUE;
        }

        arr[str.charAt(i) - 'a']++;
        int left = rec(str, i + 1, j, arr, (arr[str.charAt(i) - 'a'] == k ? count - 1 : count), k);
        arr[str.charAt(i) - 'a']--;

        arr[str.charAt(j) - 'a']++;
        int right = rec(str, i, j - 1, arr, (arr[str.charAt(i) - 'a'] == k ? count - 1 : count), k);
        arr[str.charAt(j) - 'a']--;

        return Math.min(left, right);
    }
}
