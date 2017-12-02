public class NumArray {
    
    private int[] accumulation;

    public NumArray(int[] nums) {
        int n = nums.length;
        accumulation = new int[n + 1];
        accumulation[0] = 0;
        for (int i = 1; i <= n; ++i) {
            accumulation[i] = accumulation[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return accumulation[j + 1] - accumulation[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
