class Solution {
    public int numSquares(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        return numSquares(n, nums);
    }
    
    private int numSquares(int n, int[] nums) {
        if (nums[n - 1] > 0) {
            return nums[n - 1];
        }
        
        int root = (int)Math.sqrt(n);
        if (root * root == n) {
            nums[n - 1] = 1;
            return 1;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = root; i >= 1; --i) {
            min = Math.min(min, 1 + numSquares(n - i * i, nums));
        }
        nums[n - 1] = min;
        return min;
    }
}
