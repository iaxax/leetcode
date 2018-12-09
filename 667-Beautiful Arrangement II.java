class Solution {
    public int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        int i = 0, end = k + 1, start = 1;
        while (i < k + 1) {
            nums[i++] = start++;
            if (i < k + 1) {
                nums[i++] = end--;
            }
        }
        while (i < n) {
            nums[i] = i + 1;
            i = i + 1;
        }
        return nums;
    }
}