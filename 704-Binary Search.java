class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    private int search(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}