package BS_on_Ans_min_max_combo;
import java.util.Arrays;

public class AgressiveCows {

    public static int aggressiveCows(int[] stalls, int k) {
        long low = 0, high = Arrays.stream(stalls).max().orElse(Integer.MIN_VALUE);
        Arrays.sort(stalls);
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if(check(stalls, mid, k)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return (int) high;
    }

    public static boolean check(int[] stalls, long dis, int k) {
        int pre_placed_idx = 0;
        k--;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[pre_placed_idx] >= dis) {
                k--;
                pre_placed_idx = i;
            }
        }
        return k <= 0;
    }

    public static void main(String[] args) {

    }
}
