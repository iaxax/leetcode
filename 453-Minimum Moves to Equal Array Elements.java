public class Solution {
    public int minMoves(int[] nums) {
        int index = minIndex(nums);
        int n = nums.length, count = 0;
        for (int i = 0; i < n; ++i) {
            count += nums[i] - nums[index];
        }
        return count;
    }
    
    private int minIndex(int[] nums) {
        int index = 0, n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[index]) index = i;
        }
        return index;
    }
}
