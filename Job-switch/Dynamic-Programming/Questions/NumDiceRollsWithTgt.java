package Questions;

import java.util.HashMap;
import java.util.Map;

public class NumDiceRollsWithTgt {

    Map<String, Integer> memo;
    int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        memo = new HashMap<>();
        return rec(n, k, target);
    }

    public int rec(int dices, int k, int target) {
        if (target < 0)
            return 0;
        if (dices <= 0)
            return target == 0 ? 1 : 0;

        String key = dices + "," + target;
        if (memo.containsKey(key))
            return memo.get(key);

        int count = 0;
        for (int i = 1; i <= k; i++) {
            count = (count + rec(dices - 1, k, target - i)) % MOD;
        }
        memo.put(key, count);
        return count;
    }

}
