// brute-force
class Solution {
    public boolean makesquare(int[] nums) {
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
        }
        
        if (len < 4 || sum % 4 != 0) return false;
        return makesquare(nums, new int[4], 0, sum / 4);
    }
    
    private boolean makesquare(int[] nums, int[] sum, int start, int edge) {
        if (start == nums.length) return sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3];
        
        for (int i = 0; i < 4; ++i) {
            if (sum[i] + nums[start] <= edge) {
                sum[i] += nums[start];
                boolean result = makesquare(nums, sum, start + 1, edge);
                if (result) return true;
                sum[i] -= nums[start];
            }
        }
        
        return false;
    }
}


// optimized brute force
class Solution {
    public boolean makesquare(int[] nums) {
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
        }
        
        if (len < 4 || sum % 4 != 0) return false;
        
        Arrays.sort(nums);
        return makesquare(nums, new int[4], len - 1, sum / 4);
    }
    
    private boolean makesquare(int[] nums, int[] sum, int start, int edge) {
        if (start < 0) return sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3];
        
        for (int i = 0; i < 4; ++i) {
            if (sum[i] + nums[start] <= edge) {
                sum[i] += nums[start];
                if (makesquare(nums, sum, start - 1, edge)) return true;
                sum[i] -= nums[start];
            }
        }
        
        return false;
    }
}
