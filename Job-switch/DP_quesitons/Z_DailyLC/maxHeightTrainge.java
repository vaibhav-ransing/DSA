package Z_DailyLC;
/**
 * maxHeightTrainge
 */
public class maxHeightTrainge {

    public int maxHeightOfTriangle(int red, int blue) {
        int a1 = helper(red, blue);
        int a2 = helper(blue, red);
        return Math.max(a1, a2);
    }

    public int helper(int smallerOne, int biggerOne) {
        int nextLayer = 1;
        int ans = 0;

        boolean toggle = true;
        while (true) {
            // smallerOne >= nextLayer && biggerOne >= nextLayer
            if (toggle) { // placing smallerOne
                if (smallerOne < nextLayer)
                    break;
                smallerOne -= nextLayer;
            }
            if (!toggle) {
                if (biggerOne < nextLayer)
                    break;
                biggerOne -= nextLayer;
            }
            toggle = !toggle;
            nextLayer++;
            ans++;
        }
        return ans;
    }
}