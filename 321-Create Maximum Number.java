class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] result = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = maxNumber(maxNumber(nums1, i), maxNumber(nums2, k - i));
            if (greater(candidate, 0, result, 0)) result = candidate;
        }
        return result;
    }
    
    private int[] maxNumber(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] result = new int[n + m];
        for (int i = 0, j = 0, r = 0; r < m + n; ++r) {
            result[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return result;
    }
    
    private int[] maxNumber(int[] nums, int k) {
        int[] result = new int[k];
        int n = nums.length;
        for (int i = 0, j = 0; i < n; ++i) {
            while(n - i + j > k && j > 0 && nums[i] > result[j - 1]) --j;
            if (j < k) result[j++] = nums[i];
        }
        return result;
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        int n = nums1.length, m = nums2.length;
        while (i < n && j < m && nums1[i] == nums2[j]) {
            ++i; ++j;
        }
        return j == m || (i < n && nums1[i] > nums2[j]);
    }

    public static void main(String[] args) {
        new Solution().maxNumber(new int[]{1, 2, 3}, new int[]{4, 5, 7}, 3);
    }
}