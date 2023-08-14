package DP.Day1;

public class Fibo {

    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);

    }

    public static int dpSolnTopDown(int n, int[] dp) {
        if (n == 0 || n == 1)
            return n;
        if (dp[n] != 0)
            return dp[n];
        int fib1 = dpSolnTopDown(n-1, dp);
        int fib2 = dpSolnTopDown(n-2, dp);
        dp[n] = fib1 + fib2;
        return dp[n];
    }

    public static void main(String[] args) {
        
    }
}
