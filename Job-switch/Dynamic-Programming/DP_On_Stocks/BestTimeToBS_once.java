import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BestTimeToBS_once {

    public static int maximumProfit(ArrayList<Integer> prices) {
        int n = prices.size();
        int maxToRight[] = new int[n];
        maxToRight[n - 1] = prices.get(n - 1);

        Stack<Integer> stack = new Stack<>();
        stack.add(prices.get(n - 1));

        for (int i = n - 2; i >= 0; i--) {
            int curr = prices.get(i);
            while (stack.size() > 0 && curr > stack.peek()) {
                stack.pop();
            }
            maxToRight[i] = stack.size() > 0 ? stack.peek() : curr;
            // stack.push(curr); // this we do to find nearest greater to right.
            if (stack.size() == 0)
                stack.push(curr);
        }
        // you can do the below step in above loop also but for redability
        int maxDiff = 0;
        for (int i = 0; i < maxToRight.length; i++) {
            maxDiff = Math.max(maxDiff, (maxToRight[i] - prices.get(i)));
        }
        return maxDiff;
    }

    // Leetcode
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int maxToRight[] = new int[n];
        maxToRight[n - 1] = prices[n - 1];

        Stack<Integer> stack = new Stack<>();
        stack.add(prices[n - 1]);

        int maxDiff = 0;

        for (int i = n - 2; i >= 0; i--) {
            int curr = prices[i];
            while (stack.size() > 0 && curr > stack.peek()) {
                stack.pop();
            }
            maxToRight[i] = stack.size() > 0 ? stack.peek() : curr;
            // stack.push(curr); // this we do to find nearest greater to right.
            if (stack.size() == 0)
                stack.push(curr);
            maxDiff = Math.max(maxDiff, (maxToRight[i] - curr));
        }

        return maxDiff;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;

        int min = prices[0];
        for(int currVal : prices){
            if(currVal >= min){
                profit = Math.max(profit, currVal - min);
            }else{
                min = currVal;
            }
        }
        return profit;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(10);
        list.add(15);
        list.add(18);
        maximumProfit(list);
        // (ArrayList<Integer>) Arrays.asList(2,10,15,12);
        // maximumProfit(list);
    }
}