import java.util.Arrays;

public class K_RadiusSubarrayAverages {

    public int[] getAverages(int[] arr, int k) {
        int i = 0, j = 0;
        int n = arr.length;
        int div = 2 * k + 1;
        int sum = 0;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        if(k >= n)
            return ans;
        
        while (j < n) {
            while (j - i <= 2 * k) {
                sum += arr[j++];
            }
            ans[k + i] = sum / div == 0 ? -1 : sum / div;
            sum -= arr[i++];
        }
        return ans;
    }
}