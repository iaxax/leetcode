class Solution {
    public int singleNonDuplicate(int[] nums) {
        int result = nums[0], len = nums.length;
        for (int i = 1; i < len; ++i) {
            result ^= nums[i];
        }
        return result;
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i += 2) {
            if (nums[i] != nums[i + 1]) return nums[i];
        }
        return nums[len - 1];
    }
}
