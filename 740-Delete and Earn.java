class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        int[] map = new int[10001];
        int[] dp = new int[10001];
        for (int n : nums) {
            map[n] += 1;
            maxNum = Math.max(maxNum, n);
        }
        dp[1] = map[1];
        
        for (int i = 2; i <= maxNum; ++i) {
            dp[i] = Math.max(dp[i - 1], i * map[i] + dp[i - 2]);
        }
        
        return dp[maxNum];
    }
}