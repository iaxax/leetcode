// O(n^2) Solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; ++i) {
            int temp = 0;
            for (int j = i - 1; j >= 0; --j) {
                temp = Math.max(temp, nums[i] > nums[j] ? dp[j] : 0);
            }
            dp[i] = temp + 1;
            if (dp[i] > maxLen) maxLen = dp[i];
        }
        return maxLen;
    }
}

// O(nlogn) Solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;
        for (int i = 1; i < n; ++i) {
            int low = 0, high = len - 1;
            boolean found = false;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (dp[mid] == nums[i]) {
                    found = true; break;
                }
                if (dp[mid] < nums[i]) low = mid + 1;
                else high = mid - 1;
            }
            if (found) continue;
            if (low >= len) {
                ++len;
            }
            dp[low] = nums[i];
        }
        return len;
    }
}
