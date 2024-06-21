public class Test {

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0)
                max += customers[i];
        }

        int i = 0, j = 0;
        int sum = max;
        while (j < n) {
            if (j - i == minutes) {
                if (grumpy[i] == 1) {
                    sum -= customers[i];
                }
                max = Math.max(max, sum);
                i++;
            }
            if (grumpy[j] == 1) {
                sum += customers[j];
            }
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {

        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;
        int result = maxSatisfied(customers, grumpy, minutes);
        System.out.println("Maximum satisfied customers: " + result);
    }
}