import java.util.Arrays;

public class MinSwapsToGroupAll1 {

    public int minSwaps(int[] arr) {
        int totalOne = (int) Arrays.stream(arr).filter(val -> val == 1).count();
        int i = 0, j = 0;
        int onesInWindow = 0;
        int min = Integer.MAX_VALUE;
        while (j < arr.length + totalOne) {
            while (j - i + 1 > totalOne) {
                if (arr[i] == 1)
                    onesInWindow--;
                i++;
            }
            if (arr[j % arr.length] == 1)
                onesInWindow++;
            min = Math.min(min, totalOne - onesInWindow);
            j++;
        }
        return min;
    }
}