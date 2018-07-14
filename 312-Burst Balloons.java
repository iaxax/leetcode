class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        return maxCoins(nums, 0, n - 1, dp);
    }
    
    private int maxCoins(int[] nums, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        
        int left = start == 0 ? 1 : nums[start - 1];
        int right = end == nums.length - 1 ? 1 : nums[end + 1];
        int coins = 0;
        for (int i = start; i <= end; ++i) {
            coins = Math.max(coins, left * nums[i] * right + maxCoins(nums, start, i - 1, dp) + maxCoins(nums, i + 1, end, dp));
        }
        dp[start][end] = coins;
        return coins;
    }
}