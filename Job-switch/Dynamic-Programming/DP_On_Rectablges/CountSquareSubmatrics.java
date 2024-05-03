package DP_On_Rectablges;

import java.util.Arrays;

public class CountSquareSubmatrics {

    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || matrix[i][j] == 0) { 
                    // All the 0th row and col should be as it is.
                    // if mat[i][j] is 0 then there can be no squares formed using i,j as ending edge.
                    dp[i][j] = matrix[i][j];
                } else {
                    int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    dp[i][j] = min + 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}