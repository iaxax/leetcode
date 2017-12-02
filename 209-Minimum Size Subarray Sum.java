public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = nums.length + 1;
        int start = 0, end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= s) {
                minLen = Math.min(minLen, end - start);
                sum -= nums[start++];
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
