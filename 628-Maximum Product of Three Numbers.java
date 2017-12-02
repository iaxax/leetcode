// O(nlogn) Solution
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }
}

// O(n) Solution
class Solution {
    public int maximumProduct(int[] nums) {
        int[] min3 = new int[4];
        for (int i = 0; i < 4; ++i) min3[i] = Integer.MAX_VALUE;
        int[] max3 = new int[4];
        for (int i = 0; i < 4; ++i) max3[i] = Integer.MIN_VALUE;
        
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = 0;
            while (j < 3 && min3[j] > nums[i]) {
                min3[j] = min3[j + 1]; ++j;
            }
            if (j > 0) min3[j - 1] = nums[i];
            
            j = 0;
            while (j < 3 && max3[j] < nums[i]) {
                max3[j] = max3[j + 1]; ++j;
            }
            if (j > 0) max3[j - 1] = nums[i];
        }
        
        return Math.max(min3[1] * min3[2] * max3[2], max3[0] * max3[1] * max3[2]);
    }
}
