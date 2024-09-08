package DoLastWeek.Expression;

import java.util.*;

// Given an array of distinct elements, you can choose any subset from the array and reorder them. You can place following operators between them: +, -, *, /, (, ) and evaluate the value of the expression. Your task is to find the minimum positive number which cannot be formed using the array elements. You can use the elements of an array only once for an expression.

// Example 1:
// Input: [1, 2]
// Output: 4
// Explanation:
// 1 and 2 are already present in the array.
// You can make 3 by adding 1 and 2 i.e. 3 = 1+2
// There no possible way to make 4.

// Example 2:
// Input: [1,2,3]
// Output: 10

public class SmallestNotPossibleValue {

    public class MinMissingNumber {

        // Function to find the smallest missing positive number
        public static int findSmallestMissingNumber(int[] nums) {
            Set<Integer> resultSet = new HashSet<>();
            generateAllResults(nums, resultSet);

            // Now find the smallest positive number that is not in the resultSet
            int smallestMissingNumber = 1;
            while (resultSet.contains(smallestMissingNumber)) {
                smallestMissingNumber++;
            }
            return smallestMissingNumber;
        }

        // Recursive function to generate all results
        private static void generateAllResults(int[] nums, Set<Integer> resultSet) {
            boolean[] visited = new boolean[nums.length];
            backtrack(nums, visited, resultSet, 0, "");
        }

        private static void myBackTrack(int[] nums, boolean[] vis, boolean prevOperator, boolean prevNumber, boolean prevOpenBracket, int count, String expr){

        }

        // Backtracking function to generate all possible expressions
        private static void backtrack(int[] nums, boolean[] visited, Set<Integer> resultSet, int count, String expr) {
            if (count == nums.length) {
                try {
                    // Evaluate the expression if all elements are used
                    int result = evaluateExpression(expr);
                    if (result > 0) {
                        resultSet.add(result);
                    }
                } catch (Exception e) {
                    // If there's an error in evaluating the expression, ignore it
                }
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;

                    // Add operators between the numbers
                    if (count == 0) {
                        backtrack(nums, visited, resultSet, count + 1, expr + nums[i]);
                    } else {
                        backtrack(nums, visited, resultSet, count + 1, expr + "+" + nums[i]);
                        backtrack(nums, visited, resultSet, count + 1, expr + "-" + nums[i]);
                        backtrack(nums, visited, resultSet, count + 1, expr + "*" + nums[i]);
                        if (nums[i] != 0) { // Avoid division by zero
                            backtrack(nums, visited, resultSet, count + 1, expr + "/" + nums[i]);
                        }
                    }
                    visited[i] = false;
                }
            }
        }

        // Function to evaluate a simple mathematical expression
        private static int evaluateExpression(String expr) {
            // Basic calculatro 3
            return 0;
        }

        public static void main(String[] args) {
            // Test cases
            int[] arr1 = { 1, 2 };
            int[] arr2 = { 1, 2, 3 };

            System.out.println(findSmallestMissingNumber(arr1)); // Output: 4
            System.out.println(findSmallestMissingNumber(arr2)); // Output: 10
        }

    }
}
