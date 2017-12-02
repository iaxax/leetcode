public class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int sum1 = (1 + size) * size / 2;
        int sum2 = 0;
        for (int i = 0; i < size; ++i) {
            sum2 += nums[i];
        }
        return sum1 - sum2;
    }
}
