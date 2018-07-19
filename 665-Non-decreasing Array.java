class Solution {
    public boolean checkPossibility(int[] nums) {
        List<Integer> point = new ArrayList<>();
        int n = nums.length;
        if (n <= 2) {
            return true;
        }
        
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                point.add(i);
            }
        }
        
        if (point.size() == 0) {
            return true;
        }
        if (point.size() >= 2) {
            return false;
        }
        
        int p = point.get(0);
        return p == n - 1 || p == 1 || nums[p + 1] >= nums[p - 1] || nums[p] >= nums[p - 2];
    }
}