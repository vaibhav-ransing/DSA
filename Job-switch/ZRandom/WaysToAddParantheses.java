package ZRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WaysToAddParantheses {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> temp = rec(0, expression.length() - 1, expression);
        return temp;
    }

    public List<Integer> rec(int left, int right, String str) {
        if (left == right) {
            return new ArrayList<>(Arrays.asList(Integer.parseInt(str.charAt(left) + "")));
        }

        // "2 * 3 - 4 * 5"
        List<Integer> currList = new ArrayList<>();
        for (int i = left + 1; i < right; i += 2) {
            char ch = str.charAt(i);
            List<Integer> l = rec(left, i - 1, str);
            List<Integer> r = rec(i + 1, right, str);
            if (ch == '*') {
                for (int v1 : l) {
                    for (int v2 : r) {
                        currList.add(v1 * v2);
                    }
                }
            } else if (ch == '-') {
                for (int v1 : l) {
                    for (int v2 : r) {
                        currList.add(v1 - v2);
                    }
                }
            } else { // +
                for (int v1 : l) {
                    for (int v2 : r) {
                        currList.add(v1 + v2);
                    }
                }
            }
        }
        return currList;
    }

    // Single digit fix
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            return rec(0, expression.length() - 1, expression);
        }

        // Recursive function to evaluate different ways to compute the expression
        public List<Integer> rec(int left, int right, String str) {
            // Base case: If the substring is a number, directly return it as a list
            String sub = str.substring(left, right + 1);
            if (sub.chars().allMatch(Character::isDigit)) {
                return new ArrayList<>(Arrays.asList(Integer.parseInt(sub)));
            }

            List<Integer> currList = new ArrayList<>();

            // Iterate over the expression, looking for operators
            for (int i = left; i <= right; i++) {
                char ch = str.charAt(i);
                // If we find an operator, split the expression and solve left and right parts
                if (ch == '+' || ch == '-' || ch == '*') {
                    List<Integer> l = rec(left, i - 1, str);
                    List<Integer> r = rec(i + 1, right, str);

                    // Compute the result based on the operator
                    for (int v1 : l) {
                        for (int v2 : r) {
                            if (ch == '+') {
                                currList.add(v1 + v2);
                            } else if (ch == '-') {
                                currList.add(v1 - v2);
                            } else if (ch == '*') {
                                currList.add(v1 * v2);
                            }
                        }
                    }
                }
            }

            return currList;
        }
    }

}
