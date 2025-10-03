class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill (dp, 0);

        int ans = getDistinctWays(n, n, dp);
        return ans;
    }

    private int getDistinctWays(int n, int rem, int[] dp) {
        if (rem == 0) {
            return 1;
        }
        if (dp[rem] != 0) {
            return dp[rem];
        }
        
        int left = getDistinctWays(n, rem-1, dp);

        int right = 0;
        if (rem > 1) {
            right = getDistinctWays(n, rem-2, dp);
        }

        return dp[rem] = left + right;
    }
}