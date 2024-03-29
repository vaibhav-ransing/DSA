import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int n = 10;
        long totalSum = 0;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {  // ye wala loop  Math.sqrt(n) tak chalgea
                if (n % j == 0) {
                    sum += j;
                }
            }
            totalSum += sum;
        }

        System.out.println(totalSum);
    }

    public static int sumOfDivisors(int n) {
        int sum = 0;
        for (int j = 1; j <= n; j++) {
            if (n % j == 0) {
                sum += j;
            }
        }
        return sum;
    }
}
