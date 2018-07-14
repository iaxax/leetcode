class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        
        Arrays.sort(nums);
        return canPartitionKSubsets(nums, new int[k], nums.length - 1, sum / k);
    }
    
    private boolean canPartitionKSubsets(int[] nums, int[] sum, int end, int target) {
        int len = nums.length;
        if (end < 0) {
            for (int s : sum) {
                if (s != target) return false;
            }
            return true;
        }
        
        int k = sum.length;
        for (int i = 0; i < k; ++i) {
            if (sum[i] + nums[end] <= target) {
                sum[i] += nums[end];
                if (canPartitionKSubsets(nums, sum, end - 1, target)) return true;
                sum[i] -= nums[end];
            }
        }
        return false;
    }
}
