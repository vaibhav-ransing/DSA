package DoLastWeek.Expression;

public class SmallestNotPossibleValue {
    import java.util.HashSet;


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
        return (int) new javax.script.ScriptEngineManager()
            .getEngineByName("JavaScript").eval(expr);
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 2};
        int[] arr2 = {1, 2, 3};

        System.out.println(findSmallestMissingNumber(arr1)); // Output: 4
        System.out.println(findSmallestMissingNumber(arr2)); // Output: 10
    }
}

}
