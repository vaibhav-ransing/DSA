package BS_On_Answer;

public class NthRootOfInteger {
    public static int NthRoot(int n, int x) {
        // Write your code here.

        long low = 1, high = x;
        
        while (low <= high) {

            long mid = low + (high - low)/2;

            if(Math.pow(mid, n) <= x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        if(Math.pow(high, n) == x) return (int) high;
        return -1;
    }
}
