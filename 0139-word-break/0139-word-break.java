class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()+1];
        Arrays.fill(dp, null);
       Set<String> log = new HashSet<>(wordDict);
       return f(s, wordDict, 0, log, dp);
    }

    boolean f(String s, List<String> wordDict, int ind, Set<String> log, Boolean[] dp) {
        if (ind == s.length()) return true;
        if (dp[ind] != null) return dp[ind];

        for (int i = ind+1; i <= s.length(); i++) {
            String subS = s.substring(ind, i);
            if (log.contains(subS) && f(s, wordDict, i, log, dp)) return dp[ind] = true;
        }
        return dp[ind] = false;
    }
}