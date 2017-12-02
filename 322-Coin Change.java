class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            int min = Integer.MAX_VALUE;
            boolean canMade = false;
            for (int c : coins) {
                if (i - c >= 0 && dp[i - c] != -1) {
                    min = Math.min(min, 1 + dp[i - c]);
                    canMade = true;
                }
            }
            dp[i] = canMade ? min : -1;
        }
        return dp[amount];
    }
}
