public class Solution {
    public void rotate(int[] nums, int k) {
        int step = k % nums.length;
        if (step == 0) {
            return;
        }
        
        int[] cache = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            cache[i] = nums[i];
        }
        
        for (int i = 0; i < step; ++i) {
            nums[i] = cache[nums.length - step + i];
        }
        
        for (int i = step; i < nums.length; ++i) {
            nums[i] = cache[i - step];
        }
    }
}