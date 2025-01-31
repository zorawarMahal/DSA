class Solution {
    public boolean canJump(int[] nums) {
        int max_pos = 0;

        for (int i=0; i < nums.length-1; i++) {
            if (max_pos == i && nums[i] == 0) {
                return false;
            }

            if (nums[i] + i > max_pos) {
                max_pos = i + nums[i];
            }
        }
        return true;
    }
}