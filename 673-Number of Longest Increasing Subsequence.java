class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        int maxLen = 0, maxCount = 0;
        
        for (int i = 0; i < n; ++i) {
            int l = 1, c = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (1 + length[j] > l) {
                        l = 1 + length[j];
                        c = count[j];
                    } else if (1 + length[j] == l) {
                        c = c + count[j];
                    }
                }
            }
            length[i] = l;
            count[i] = c;
            
            if (l > maxLen) {
                maxLen = l;
                maxCount = c;
            } else if (l == maxLen) {
                maxCount = maxCount + c;
            }
        }
        
        return maxCount;
    }
}