public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxNum = 0;
        int i = 0, n = nums.length;
        while (i < n) {
            while (i < n && nums[i] == 0) ++i;
            int num = 0;
            while (i < n && nums[i++] == 1) ++num;
            maxNum = Math.max(maxNum, num);
        }
        return maxNum;
    }
}
