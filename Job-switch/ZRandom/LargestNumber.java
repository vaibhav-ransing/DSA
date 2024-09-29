package ZRandom;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (a + b).compareTo(b + a));
        if (arr[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String val : arr) {
            sb.append(val);
        }

        return sb.reverse().toString();
    }

    class Solution {

        public String largestNumber(int[] nums) {

            String str[] = new String[nums.length];
            for (int i = 0; i < nums.length; i++)
                str[i] = Integer.toString(nums[i]);

            Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

            if (str[0].equals("0"))
                return "0";

            StringBuilder sb = new StringBuilder();

            for (String s : str)
                sb.append(s);

            return sb.toString();
        }
    }
}
