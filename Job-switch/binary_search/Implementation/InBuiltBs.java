import java.util.Arrays;

public class InBuiltBs {

    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            // If target is not found, binarySearch returns (-(insertion point) - 1)
            // We need to convert it to the insertion point
            index = -(index + 1);
        }
        return index;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 3, 4, 6, 7, 9 };
        int lowrBound = (Arrays.binarySearch(arr, 6) + arr.length) % arr.length;
        System.out.println(lowrBound);

    }
}