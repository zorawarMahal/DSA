class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max_pos = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0 && max_pos == i) {
                return false;
            }
            max_pos = Math.max(max_pos, nums[i] + i);
        }

        return true;
    }
}