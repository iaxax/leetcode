class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        int[] sort = Arrays.copyOf(nums, n);
        Arrays.sort(sort);
        
        String[] table = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] result = new String[n];
        for (int i = 0; i < n; ++i) {
            int index = Arrays.binarySearch(sort, nums[i]);
            result[i] = n - index <= 3 ? table[n - 1 - index] : String.valueOf(n - index);
        }
        return result;
    }
}
