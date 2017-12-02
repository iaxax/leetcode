class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        int max = 0, start = 0;
        
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    if (dp[i] > max) {
                        max = dp[i];
                        start = i;
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>(max);
        for (int i = 0; i < max; ++i) {
            result.add(nums[start]);
            start = parent[start];
        }
        
        return result;
    }
}
