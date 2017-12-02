class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int count = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int temp = i;
            while (i + 1 < n && nums[i] == nums[i + 1]) ++i;
            if (k == 0 && i - temp == 0) continue;
            if (Arrays.binarySearch(nums, i, n, nums[i] + k) >= 0) ++count;
        }
        return count;
    }
}
