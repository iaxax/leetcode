class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = 0, hi = 0;
        for (int num : nums) {
            hi += num;
            lo = Math.max(lo, num);
        }
        
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int k = 1, sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum > mid) {
                    sum = num;
                    k += 1;
                }
            }
            
            if (k <= m) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}