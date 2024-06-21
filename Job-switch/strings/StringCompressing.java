public class StringCompressing {

    public int compress(char[] chars) {
        int i = 0, j = 0;
        int count = 0;
        int n = chars.length;
        while (j < n || count != 0) {
            if (j < n && chars[i] == chars[j]) {
                count++;
            } else if (i < n - 1) {
                i = i + 1;
                chars[i] = chars[(j == n ? j - 1 : j)];
                String count_str = Integer.toString(count);
                for (int k = 0; k < count_str.length(); k++) {
                    chars[i++] = count_str.charAt(k);
                }
                count = 0;
            }
            j++;
        }
        return i;
    }

    class Solution {
        public int compress(char[] chars) {
            int n = chars.length;
            if (n == 0)
                return 0;

            int i = 0; // Position in the compressed array
            int j = 0; // Position in the original array

            while (j < n) {
                char currentChar = chars[j];
                int count = 0;

                // Count the occurrences of the current character
                while (j < n && chars[j] == currentChar) {
                    j++;
                    count++;
                }

                // Update the character in the compressed array
                chars[i++] = currentChar;

                // If the count is greater than 1, append the count to the compressed array
                if (count > 1) {
                    String countStr = Integer.toString(count);
                    for (char c : countStr.toCharArray()) {
                        chars[i++] = c;
                    }
                }
            }

            return i;
        }
    }

}