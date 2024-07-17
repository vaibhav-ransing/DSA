import java.util.Arrays;

public class ReverseVowels {

    public int removeDuplicates(int[] arr) {
        int idx = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[idx++] = arr[i];
            }
        }
        return idx;
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int i = 0, j = arr.length - 1;
        while (i < j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        String ans = "";
        for (String str : arr) {
            ans += str.trim() + " ";
        }
        return ans.substring(0, ans.length());
    }

    int MOD = 1000000007;

    public int numSubseq(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;

        for (int left = 0; left < arr.length; left++) {
            int right = arr.length - 1;
            while (left <= right) {
                if (arr[left] + arr[right] <= target) {
                    count = (count + (int) Math.pow(2, right - left) % MOD) % MOD;
                    break;
                }
                right--;
            }
        }

        return count % MOD;
    }

}