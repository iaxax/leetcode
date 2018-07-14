class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        for (int i = 1, max = result, min = result; i < nums.length; ++i) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}
