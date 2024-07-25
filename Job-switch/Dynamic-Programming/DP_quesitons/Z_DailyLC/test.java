package Z_DailyLC;
public class test {

    boolean ans = false;
    // 0, n-1, great, rgeat
    public String rec(int low, int high, String s1, String s2) {

        if (low == high)
            return s1.charAt(low) + "";

        for(int k = low+1; k<high; k++){
            String left = rec(low, k, s1, s2);
            String right = rec(k+1, high, s2, s2);
            
        }
    }
}
