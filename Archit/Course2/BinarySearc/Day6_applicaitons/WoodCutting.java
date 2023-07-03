package Course2.BinarySearc.Day6_applicaitons;

public class WoodCutting {

    public int solve(int[] arr, int reqWood) {
        long left = 0, right = 1000000;

        while (left <= right) {
            long mid = (left + right) / 2;
            boolean possibleCut = isPossbile(arr, reqWood, mid);
            if (possibleCut) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }

    public boolean isPossbile(int[] arr, int reqWood, long cut) {
        int collectedWood = 0;
        for (int val : arr) {
            long rw = val - cut;
            collectedWood += rw >= 0 ? rw : 0;
        }
        return collectedWood >= reqWood;
    }

    public static void main(String[] args) {

    }
}
