package Course2.BinarySearc.Day6_applicaitons;

public class ShipPackagesDdays {

    public boolean isPossbile(int[] weights, int days, long maxLoad) {
        long load = 0;
        int reqDays = 1;
        for (int val : weights) {

            if (val > maxLoad)
                return false;

            if (load + val <= maxLoad) {
                load += val;
            } else {
                reqDays++;
                load = val;
            }
        }
        return reqDays <= days;
    }

    public long getMaxWeight(int[] weights) {
        long max = 0;
        for (int val : weights) {
            max = Math.max(max, val);
        }
        return max;
    }

    public long getTotalSum(int[] weights) {
        long sum = 0;
        for (int val : weights) {
            sum += val;
        }
        return sum;
    }

    public int shipWithinDays(int[] weights, int days) {
        long left = getMaxWeight(weights);
        long right = getTotalSum(weights);

        while(left <= right){
            long mid = (left + right)/2;
            boolean poss = isPossbile(weights, days, mid);
            if(poss){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return (int) left;
    }
}
