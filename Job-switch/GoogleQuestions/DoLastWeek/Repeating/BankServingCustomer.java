package DoLastWeek.Repeating;
public class BankServingCustomer {

    // given an array
    // you can start serving from any index in array
    // Once you start serving you cannot skip any customers req 
    // initially you have 0 deposit.
    // you can serve till you have
    public static void maxPeopleServed(int[] arr) {
        int sum = 0;
        int left = 0;
        int ans = 0;

        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum < 0 && left <= r) {
                sum -= arr[left];
                left++;
            }
            ans = Math.max(ans, r - left + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] arr = { 1, -3, 5, -2, 1 };
        maxPeopleServed(arr);
    }
}
