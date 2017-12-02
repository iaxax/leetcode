class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        
        int left = 0;
        while (left + 1 < n && nums[left] <= nums[left + 1]) ++left;
        int right = n - 1;
        while (right - 1 >= left && nums[right] >= nums[right - 1]) --right;
        if (left == right) return 0;
        
        int min = nums[left], max = nums[right];
        for (int i = left; i <= right; ++i) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        while (left >= 0 && nums[left] > min) --left;
        while (right < n && nums[right] < max) ++right;
        return right - left - 1;
    }
}
