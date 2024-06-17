package Questions;

public class SumOfSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long) Math.sqrt(c);

        while (low <= high) {
            long sumOfSquares = low * low + high * high;

            if (sumOfSquares == c) {
                return true;
            } else if (sumOfSquares < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(9));
    }
}
