class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = 0, product = 1, count = 0, len = nums.length;
        while (end < len) {
            if (product * nums[end] >= k) {
                while (start < end && product * nums[end] >= k) {
                    product /= nums[start++];
                }
                if (nums[end] >= k) {
                    start = end = end + 1;
                }
            } else {
                count += end - start + 1;
                product *= nums[end++];
            }
        }
        return count;
    }
}
