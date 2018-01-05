// slow solution
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        
        int sum = 0, max = Integer.MIN_VALUE;
        for (int n : nums) {
            sum += n;
            max = Math.max(n, max);
        }
        int target = sum / 2;
        if (sum % 2 == 1 || target < max) return false;
        
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int n : nums) {
            Set<Integer> temp = new HashSet<>();
            temp.addAll(set);
            for (int nn : temp) {
                if (nn + n == target) return true;
                set.add(nn + n);
            }
        }
        return false;
    }
}

// dp solution, faster
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, len = nums.length;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
        }
        
        if ((sum & 1) != 0) return false;
        
        sum >>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 0; i < len; ++i) {
            for(int j = sum; j >= 1; --j) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        
        return dp[sum];
    }
}
