class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, len = nums.length;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; ++i) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i - 1] : nums[i - 1];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
