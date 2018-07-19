class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int length = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (i + 1 < n && nums[i + 1] > nums[i]) {
                i += 1;
            }
            length = Math.max(length, i - j + 1);
        }
        return length;
    }
}