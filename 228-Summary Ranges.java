class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>(100);
        for (int i = 0; i < n; ++i) {
            int start = nums[i];
            while (i + 1 < n && nums[i] + 1 == nums[i + 1]) ++i;
            if (nums[i] == start) {
                result.add(String.valueOf(nums[i]));
            }
            else {
                result.add(new StringBuilder().append(start).append("->").append(nums[i]).toString());
            }
        }
        return result;
    }
}
