package Subsequence;

import java.util.Arrays;

public class ParitionWithGIvenDIfference {

    public static int countPartitions(int n, int diff, int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int[][][] dp = new int[n][sum+1][sum+1];
        for(int idp[][] : dp){
            for(int d[] : idp){
                Arrays.fill(d, -1);
            }
        }
        return recursion(arr, 0, 0, n-1, diff, dp);
    }

    public static int recursion(int[] arr, int p1, int p2, int idx, int diff, int[][][] dp){
        if(idx < 0)
            return (p1 - p2) == diff ? 1 : 0;
        if(dp[idx][p1][p2] != -1)
            return dp[idx][p1][p2];
        int take1 = recursion(arr, p1 + arr[idx], p2, idx-1, diff, dp);
        int take2 = recursion(arr, p1 , p2+ arr[idx], idx-1, diff, dp);

        return dp[idx][p1][p2] = take1 + take2;
    }

    public static int tabulation(int arr[], int diff){

        int ts = Arrays.stream(arr).sum();
        
        return 0;
    }


    public static int minSubsetSumDifference(int[] arr, int n, int diff) {
        // Write your code here.
        n = arr.length;
        int sum = Arrays.stream(arr).sum();
        boolean dp[][] = new boolean[n + 1][sum + 1];

        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else {
                    boolean skip = dp[i - 1][j];
                    boolean take = false;
                    if (j - arr[i - 1] >= 0)
                        take = dp[i - 1][j - arr[i - 1]];
                    dp[i][j] = skip || take;
                }
            }
        }
        for (boolean d : dp[dp.length - 1]) {
            System.out.print(d + " ");
        }
        // true false true false true true true true true true true true true true false
        // true false true
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
        int min = sum;
        int count = 0;
        for (int i = 0; i < dp[0].length; i++) {
            if (dp[dp.length - 1][i]) {
                int rem = sum - i;
                if (rem - i == diff)
                    count++;
            }
        }
        // true true true true true
        // 0 1 2 3 4
        System.out.println();
        System.out.println("count " + count);
        // [8,6,5] = 19
        // true false false false false true true false true false false true false true
        // true false false false false true
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
        System.out.println(min);
        return min;
    }

    public static void main(String[] args) {
        // int arr[] = { 5, 2, 6, 4 };
        int arr[] = { 1, 1, 1, 1 };
        // minSubsetSumDifference(arr, arr.length, 0);
        System.out.println(countPartitions(arr.length, 0, arr));;
    }
}
