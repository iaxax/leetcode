class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE, sum = 0.0;
        int n = nums.length;
        for (int i = 0; i < k; ++i) sum += nums[i];
        if (sum > maxSum) maxSum = sum;
        for (int i = k; i < n; ++i) {
            sum = sum - nums[i - k] + nums[i];
            if (sum > maxSum) maxSum = sum;
        }
        return maxSum / k;
    }
}
