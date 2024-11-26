package AALastGo.String;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        int start = 0, prev = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int prevNum = nums[prev];
            if (prevNum + 1 == nums[i]) {
                prev = i;
            } else {
                String s = (start == prev ? nums[start] + "" : nums[start] + "->" + nums[prev]);
                ans.add(s);
                start = i;
                prev = i;
            }
        }
        String s = (start == prev ? nums[start] + "" : nums[start] + "->" + nums[prev]);
        ans.add(s);
        return ans;
    }
}
