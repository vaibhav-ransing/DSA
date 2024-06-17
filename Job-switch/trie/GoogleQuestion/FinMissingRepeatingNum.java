package GoogleQuestion;

public class FinMissingRepeatingNum {

    int[] findTwoElement(int arr[], int n) {
        int[] temp = new int[n + 1];
        int repeating = -1;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (temp[val] == 1) {
                repeating = val;
            }
            temp[val]++;
        }
        for (int i = 1; i <= n; i++) {
            if (temp[i] == 0) {
                return new int[] { repeating, i };
            }
        }
        return new int[] { -1, -1 };
    }
}
// 21