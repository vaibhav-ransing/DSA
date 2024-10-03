package ZRandom;

public class JumpGame {

    public boolean canJump(int[] nums) {
        return rec(0, nums);
    }

    boolean rec(int idx, int nums[]) {
        if (idx == nums.length - 1)
            return true;
        boolean flag = false;
        for (int i = 1; i <= nums[idx]; i++) {
            flag |= rec(idx + i, nums);
        }
        return flag;
    }
}
