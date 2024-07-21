package Lc_Contests.Contest407;

public class MoveOnesToEnd {

    public int maxOperations(String s) {
        // 1001101
        int n = s.length(), oneCount = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') oneCount++;
            if(s.charAt(i) == '1' && s.charAt(i+1) == '0'){
                ans += oneCount;
            }
        }
        return ans;
    }
}
