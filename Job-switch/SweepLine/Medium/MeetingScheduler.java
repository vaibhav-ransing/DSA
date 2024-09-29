package SweepLine.Medium;

import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> ans = new ArrayList<>();
        int[] prefix = new int[100005];
        for (int[] s : slots1) {
            prefix[s[0]]++;
            prefix[s[1] + 1]--;
        }
        for (int[] s : slots2) {
            prefix[s[0]]++;
            prefix[s[1] + 1]--;
        }
        int prevStart = prefix[0] == 2 ? 0 : -1;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
            if (prefix[i] == 2 && prevStart == -1) {
                prevStart = i;
            } else if (prefix[i] == 2) {
                if (i - prevStart == duration) {
                    ans.add(prevStart);
                    ans.add(i);
                }
            }else if(prefix[i] < 2){
                prevStart = -1;
            }
        }
        return ans;
    }
}
