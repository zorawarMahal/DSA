class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        int ans = getMaxSum(nums, 0, dp);
        return ans;
    }

    private int getMaxSum(int[] nums, int ind, int[] dp) {
        if (ind >= nums.length) return 0;
        if (dp[ind] != -1) return dp[ind];

        // robbing the current house
        int robbed = nums[ind] + getMaxSum(nums, ind + 2, dp);

        // not robbing the current house
        int skipped = getMaxSum(nums, ind + 1, dp);

       // returning the maximum of the two paths originating from the current index
        return dp[ind] = Math.max(robbed, skipped);
    }
}