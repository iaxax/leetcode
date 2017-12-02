public class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int noneZeroIndex = 0;
        int n = nums.length;
        while (noneZeroIndex < n) {
            if (nums[noneZeroIndex] != 0) {
                nums[zeroIndex] = nums[noneZeroIndex];
                zeroIndex += 1;
            }
            noneZeroIndex += 1;
        }
        for (int i = zeroIndex; i < n; ++i) {
            nums[i] = 0;
        }
    }
}
