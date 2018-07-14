// brute force
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S, 0, 0);
    }
    
    private int findTargetSumWays(int[] nums, int sum, int S, int start, int result) {
        int len = nums.length;
        if (start == len) {
            return sum == S ? result + 1 : result;
        }
        
        return findTargetSumWays(nums, sum + nums[start], S, start + 1, result) +
                findTargetSumWays(nums, sum - nums[start], S, start + 1, result);
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if (len == 0) return S == 0 ? 1 : 0;

        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(nums[0], 1);
        count.put(-nums[0], count.getOrDefault(-nums[0], 0) + 1);
        
        for (int i = 1; i < len; ++i) {
            HashMap<Integer, Integer> temp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                int key = entry.getKey(), value = entry.getValue();
                temp.put(key + nums[i], temp.getOrDefault(key + nums[i], 0) + value);
                temp.put(key - nums[i], temp.getOrDefault(key - nums[i], 0) + value);
            }
            count = temp;
        }

        return count.getOrDefault(S, 0);
    }
}

// dp
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
        }
        
        if (S > sum || (sum + S) % 2 != 0) return 0;
        return subsetSum(nums, (sum + S) >> 1);
    }
    
    private int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = target; i >=n; --i) {
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }
}
