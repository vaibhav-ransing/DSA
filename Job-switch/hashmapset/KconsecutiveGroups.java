import java.util.Arrays;

public class KconsecutiveGroups {
    public boolean isNStraightHand(int[] hand, int k) {
        int n = hand.length;
        if (n % k != 0)
            return false;
        Arrays.sort(hand);

        for (int i = 0; i < n; i += k) {
            int lim = i + k;
            for (int j = i + 1; j < lim; j++) {
                if (hand[j - 1] != hand[j]) {
                    System.out.println("i= "+i +" | j= "+j +" |" + hand[j - 1] + " " + hand[j]);
                    return false;
                }
            }
        }
        return true;
    }
}
